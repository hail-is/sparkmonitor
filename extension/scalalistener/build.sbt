name := "sparkmonitor"

version := "1.1"

scalaVersion := "2.12.4"

organization := "cern"

val sparkVersion = "3.1.1"

libraryDependencies ++= List(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "net.sf.py4j" % "py4j" % "0.10.4"
)
artifactPath in Compile in packageBin :=
   (baseDirectory { base => base / "../sparkmonitor/listener.jar" }).value
