
lazy val sharedSettings = Seq(
  organization := "com.pagerduty",
  scalaVersion := "2.10.6",
  crossScalaVersions := Seq("2.10.6", "2.11.7")
)

lazy val api = (project in file("api")).
  settings(sharedSettings: _*).
  settings(
    name := "metrics-api"
  )

lazy val dogstatsd = (project in file("dogstatsd")).
  dependsOn(api).
  settings(sharedSettings: _*).
  settings(
    name := "metrics-dogstatsd",
    libraryDependencies ++= Seq(
      "com.indeed" % "java-dogstatsd-client" % "2.0.13"

      //"org.scalatest" %% "scalatest" % "2.2.6" % "test",
      //"org.scalamock" %% "scalamock-scalatest-support" % "3.2.2" % "test"
    )
  )
