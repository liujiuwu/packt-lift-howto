organization := "packt"

name := "Packt Lift SQL Template"

version := "0.1"

scalaVersion := "2.9.1"

// scalacOptions += "-deprecation"

seq(webSettings :_*)

resolvers += "Java.net Maven2 Repository" at "http://download.java.net/maven/2/"

resolvers += "Sonatype scala-tools repo" at "https://oss.sonatype.org/content/groups/scala-tools/"

resolvers += "Sonatype scala-tools snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies ++= {
    val liftVersion = "2.5-SNAPSHOT"
    Seq(
      "net.liftweb" %% "lift-webkit" % liftVersion % "compile",
      "net.liftweb" %% "lift-mapper" % liftVersion % "compile"
    )
  }

libraryDependencies ++= Seq(
  "org.eclipse.jetty" % "jetty-server" % "7.6.0.v20120127" % "container,test->default",
  "org.eclipse.jetty" % "jetty-webapp" % "7.6.0.v20120127" % "container,test->default",
  "javax.servlet" % "servlet-api" % "2.5" % "provided->default",
  "org.specs2" %% "specs2" % "1.9" % "test",
  "org.pegdown" % "pegdown" % "1.1.0" % "test",
  "junit" % "junit" % "4.8" % "test->default", // For JUnit 4 testing
  "com.h2database" % "h2" % "1.2.138",
  "org.slf4j" % "slf4j-simple" % "1.6.1" % "compile"
)

// If using JRebel uncomment next line
scanDirectories := Nil

// Remove Java directories, otherwise sbteclipse generates them
unmanagedSourceDirectories in Compile <<= (scalaSource in Compile)(Seq(_))

unmanagedSourceDirectories in Test <<= (scalaSource in Test)(Seq(_))

// If you want to change the Jetty port
// port in container.Configuration := 9999
