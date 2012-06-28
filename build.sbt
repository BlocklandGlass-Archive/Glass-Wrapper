name := "glass-wrapper"

organization := "blocklandglass"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.9.1"

resolvers += "Nullable.se" at "http://nexus.nullable.se/nexus/content/groups/public/"

publishMavenStyle := true

publishTo <<= (version) { version: String =>
  val nexus = "http://nexus.nullable.se/nexus/content/repositories/"
  if (version.trim.endsWith("-SNAPSHOT")) Some("snapshots" at nexus + "snapshots/") 
  else                                   Some("releases"  at nexus + "releases/")
}

libraryDependencies += "com.typesafe.akka" % "akka-actor" % "2.0.2"

libraryDependencies += "com.typesafe.akka" % "akka-slf4j" % "2.0.2"

libraryDependencies += "jline" % "jline" % "0.9.93"

libraryDependencies += "blocklandglass" %% "jocklaunch" % "0.0.1-SNAPSHOT"

libraryDependencies += "blocklandglass" %% "glass-common"  % "0.0.1-SNAPSHOT"