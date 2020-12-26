
import Dependencies._

name := "trykafka"

version := "0.1"

scalaVersion := "2.13.3"

libraryDependencies ++=  prodConsExample
libraryDependencies += "org.apache.kafka" % "kafka-clients" % "0.10.1.0"
libraryDependencies += "org.apache.kafka" % "kafka-streams" % "2.1.0"
libraryDependencies += "org.apache.kafka" % "kafka-streams-scala" % "2.1.0"
