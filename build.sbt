
name := """Junit5-Module-Test-Suite"""

lazy val dependencies =
  new {
    val junit             = "org.junit.jupiter"               % "junit-jupiter-api"             % "5.9.0"   % Test
    val junitEngine       = "org.junit.jupiter"               % "junit-jupiter-engine"          % "5.9.0"   % Test
    val junitRunner       = "org.junit.platform"              % "junit-platform-runner"         % "1.9.0"   % Test
    val junitSuiteEngine  = "org.junit.platform"              % "junit-platform-suite-engine"   % "1.9.0"   % Test
    val jupiterInterface  = "net.aichler"                     % "jupiter-interface"             % "0.11.0"  % Test
  }

lazy val testDependencies = Seq(
  dependencies.junit,
  dependencies.junitEngine,
  dependencies.junitRunner,
  dependencies.junitSuiteEngine,
  dependencies.jupiterInterface
)

lazy val commonSettings = Seq(
  organization := "com.test.junit",
  version := "0.1",
  scalaVersion := "2.13.8",
  publishArtifact := false,
  crossPaths := false,
  Compile / doc / sources := List(),
  excludeDependencies ++= Seq(
    ExclusionRule("junit", "junit")
  ),
  libraryDependencies ++= testDependencies
)

lazy val root = (project in file("."))
  .settings(
    commonSettings
  )
  .dependsOn(junit)
  .aggregate(junit)

lazy val junit = (project in file("junit"))
  .settings(
    commonSettings
  )

Test / testFrameworks := Seq(jupiterTestFramework)
Test / testOptions += Tests.Argument(jupiterTestFramework, "-v")
Test / fork := true

Compile / doc / sources := List()

ThisBuild / javacOptions ++= Seq("-source", "11", "-target", "11")