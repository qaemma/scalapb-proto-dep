val commonSettings = Seq(
  organization := "com.github.qaemma",
  crossPaths := false,
  autoScalaLibrary := false,
  publishArtifact in (Compile, packageDoc) := false
)

lazy val root = (project in file(".") withId "proto-gen").settings(commonSettings:_*).settings(
  skip in publish := true
).aggregate(
  common
)

lazy val common = (project in file("common")).settings(commonSettings:_*).settings(
  version := "0.1-SNAPSHOT"
)
