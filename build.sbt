name := "blocking-slick"

organization := "com.github.takezoe"

version := "0.0.4"

scalaVersion := "2.11.8"

crossScalaVersions := List("2.11.8", "2.12.1")

libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick"           % "3.1.1",
  "org.scalatest"      %% "scalatest"       % "3.0.1"   % "test",
  "com.h2database"      % "h2"              % "1.4.192" % "test",
  "ch.qos.logback"      % "logback-classic" % "1.1.8"   % "test"
)

publishMavenStyle := true

publishTo <<= version { (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT")) Some("snapshots" at nexus + "content/repositories/snapshots")
  else                             Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

scalacOptions := Seq("-deprecation", "-feature")

fork in Test := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <url>https://github.com/takezoe/blocking-slick</url>
    <licenses>
      <license>
        <name>The Apache Software License, Version 2.0</name>
        <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
      </license>
    </licenses>
    <scm>
      <url>https://github.com/takezoe/blocking-slick</url>
      <connection>scm:git:https://github.com/takezoe/blocking-slick.git</connection>
    </scm>
    <developers>
      <developer>
        <id>takezoe</id>
        <name>Naoki Takezoe</name>
      </developer>
    </developers>
)
