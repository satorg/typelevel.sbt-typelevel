val modules = List(
  "ci",
  "ci-release",
  "ci-signing",
  "core",
  "github",
  "github-actions",
  "kernel",
  "mergify",
  "mima",
  "no-publish",
  "scalafix",
  "settings",
  "site",
  "sonatype",
  "sonatype-ci-release",
  "versioning"
)

Compile / unmanagedSourceDirectories ++= modules.map { module =>
  baseDirectory.value.getParentFile / module / "src" / "main" / "scala"
}

Compile / unmanagedResourceDirectories ++= modules.map { module =>
  baseDirectory.value.getParentFile / module / "src" / "main" / "resources"
}

libraryDependencies ++= Seq(
  "io.get-coursier" %% "coursier" % "2.1.0-RC5"
)

ThisBuild / libraryDependencySchemes ++= Seq(
  "org.scala-lang.modules" %% "scala-xml" % VersionScheme.Always)
