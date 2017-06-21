name := "scala-dummy-lib"

version := "2017.6.21"

scalaVersion := "2.12.2"

scalacOptions ++= Seq("-unchecked", "-deprecation" , "-feature", "-language:implicitConversions")

libraryDependencies ++= Seq(
  "org.slf4j"      %  "slf4j-api"   % "1.7.25",
  "org.scalatest"  %% "scalatest"   % "3.0.3" % "test"
)

initialCommands in console := """
   |import dummy._
   |""".stripMargin


sourceGenerators in Compile +=  Def.task {
  val dir = (sourceManaged in Compile).value
  val projectVersion = version.value
  val projectName = name.value
  val file = dir / "dummy" / "MetaInfo.scala"
  val sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
  val buildate = sdf.format(new java.util.Date())
  IO.write(file,
  """package dummy 
    |object MetaInfo {
    |  val version="%s"
    |  val project="%s"
    |  val buildate="%s"
    |  val appcode="sdl"
    |}
    |""".stripMargin.format(projectVersion, projectName, buildate) )
  Seq(file)
}.taskValue

