name := "name-client"

version := "0.1"

scalaVersion := "2.12.7"

PB.targets in Compile := Seq(
  scalapb.gen() -> (sourceManaged in Compile).value
)

PB.protoSources in Compile += target.value / "protobuf_external" / "com" / "github" / "qaemma"

val scalaPbRuntime = "com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion

libraryDependencies ++= Seq(
  // protobuf dependency
  scalaPbRuntime % "protobuf",
  "com.github.qaemma" % "common" % "0.1-SNAPSHOT" % "protobuf",

  scalaPbRuntime,
  "com.thesamet.scalapb" %% "scalapb-runtime-grpc" % scalapb.compiler.Version.scalapbVersion,
  "io.grpc" % "grpc-netty" % scalapb.compiler.Version.grpcJavaVersion
)
