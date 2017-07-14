package io.animesh.akka.learn.rest


import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.model.StatusCodes._
import akka.http.scaladsl.server._

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._

import sangria.parser.QueryParser
import sangria.execution.{ErrorWithResolver, QueryAnalysisError, Executor}
import sangria.marshalling.sprayJson._
import sangria.renderer.SchemaRenderer

import spray.json._
import akka.actor.ActorSystem
import scala.util.{Success, Failure}

/**
  * Created by animesh on 7/15/17.
  */
class UserRoute (implicit val system: ActorSystem) {
  import system.dispatcher
  import DefaultJsonProtocol._

  sealed case class Error(error: String)
  implicit val errorWriter = jsonFormat1(Error)
  val repository = new MongoUserRepository

  val route: Route = cors() {
  path("users") {
  post {
  entity(as[String]) { document =>
  QueryParser.parse(document) match {
  case Success(queryAst) =>
  complete(Executor.execute(SchemaDefinition.UserSchema, queryAst, repository)
  .map(OK -> _)
  .recover {
  case error: QueryAnalysisError => BadRequest -> error.resolveError
  case error: ErrorWithResolver => InternalServerError -> error.resolveError
})

  case Failure(error) => complete(BadRequest -> Error(error.getMessage))
}
}
} ~ get {
  complete(SchemaRenderer.renderSchema(SchemaDefinition.UserSchema))
}
}
}
}
