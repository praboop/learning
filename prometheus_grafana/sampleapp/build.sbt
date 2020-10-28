name := "resourceconsumer"

version := "0.1"

scalaVersion := "2.13.3"

libraryDependencies ++= Seq(
  "com.lihaoyi" %  "cask_2.13" % "0.7.5",
  "io.prometheus" % "simpleclient" % "0.9.0",
  "io.prometheus" % "simpleclient_common" % "0.9.0",
  "io.prometheus" % "simpleclient_hotspot" % "0.9.0",
  "ch.qos.logback" % "logback-classic" % "1.2.3"
)
