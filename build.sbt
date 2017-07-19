name := "graphql-akka-http"

version := "1.0"

scalaVersion := "2.12.1"

scalacOptions ++= Seq("-deprecation", "-feature")


libraryDependencies ++= Seq(
  "org.sangria-graphql" %% "sangria" % "1.1.0",
  "org.sangria-graphql" %% "sangria-spray-json" % "1.0.0",
  "com.typesafe.akka" %% "akka-slf4j" % "2.5.0",
  "com.typesafe.akka" %% "akka-stream" % "2.5.0",
  "com.typesafe.akka" %% "akka-http" % "10.0.5",
  "com.typesafe.akka" %% "akka-http-spray-json" % "10.0.5",
  "org.sangria-graphql" %% "sangria-akka-streams" % "1.0.0",
  "ch.qos.logback" % "logback-classic" % "1.1.3",
  "ch.megard" %% "akka-http-cors" % "0.2.1",
  "org.reactivemongo" %% "reactivemongo" % "0.12.1",

  "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)
        