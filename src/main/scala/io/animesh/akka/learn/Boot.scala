package io.animesh.akka.learn

import akka.http.scaladsl.Http

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import io.animesh.akka.learn.rest.UserRoute


/**
  * Created by animesh on 7/15/17.
  */

object Boot extends App {
  implicit val system = ActorSystem("graphql-server")
  implicit val materializer = ActorMaterializer()
  Http().bindAndHandle(new UserRoute().route, "0.0.0.0", 48080)
}