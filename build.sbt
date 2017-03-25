lazy val root = (project in file(".")).settings(
  organization := "org.skinny-framework",
  name         := "skinny-logback",
  version      := "1.0.13",
  resolvers ++= Seq(
    "sonatype releases"  at "https://oss.sonatype.org/content/repositories/releases"
    //,"sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
  ),
  crossPaths       := false,
  autoScalaLibrary := false,
  libraryDependencies ++= Seq(
    "ch.qos.logback" % "logback-classic" % "1.2.2"  % Compile exclude("org.slf4j", "slf4j-api"),
    "org.slf4j"      % "slf4j-api"       % "1.7.25" % Compile
  ),
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (version.value.trim.endsWith("SNAPSHOT")) Some("snapshots" at nexus + "content/repositories/snapshots")
    else Some("releases" at nexus + "service/local/staging/deploy/maven2")
  },
  publishMavenStyle := true,
  sbtPlugin := false,
  scalaVersion := "2.12.1",
  ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) },
  scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature"),
  publishMavenStyle := true,
  publishArtifact in Test := false,
  pomIncludeRepository := { x => false },
  transitiveClassifiers in Global := Seq(Artifact.SourceClassifier),
  incOptions := incOptions.value.withNameHashing(true),
  logBuffered in Test := false,
  updateOptions := updateOptions.value.withCachedResolution(true),
  javacOptions ++= Seq("-source", "1.7", "-target", "1.7", "-encoding", "UTF-8", "-Xlint:-options"),
  javacOptions in doc := Seq("-source", "1.7"),
  pomExtra :=
    <url>http://skinny-framework.org/</url>
      <licenses>
        <license>
          <name>MIT License</name>
          <url>http://www.opensource.org/licenses/mit-license.php</url>
          <distribution>repo</distribution>
        </license>
      </licenses>
      <scm>
        <url>git@github.com:skinny-framework/skinny-logback.git</url>
        <connection>scm:git:git@github.com:skinny-framework/skinny-logback.git</connection>
      </scm>
      <developers>
        <developer>
          <id>seratch</id>
          <name>Kazuhiro Sera</name>
          <url>http://git.io/sera</url>
        </developer>
      </developers>
)
