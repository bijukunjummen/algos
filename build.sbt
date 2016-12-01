name := "algos"

version := "1.0"

organization := "org.bk.algos"

scalaVersion := "2.12.0"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

libraryDependencies += "org.slf4j" % "slf4j-api" % "1.6.1"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.7"

libraryDependencies += "ch.qos.logback" % "logback-core" % "1.1.7"

libraryDependencies += "io.reactivex" % "rxjava" % "1.2.0"

libraryDependencies += "junit" % "junit" % "4.12" % "test"

libraryDependencies += "org.hamcrest" % "hamcrest-core" % "1.2.1" % "test"

libraryDependencies += "org.hamcrest" % "hamcrest-library" % "1.2.1" % "test"



javaOptions += "-Xmx1G"
