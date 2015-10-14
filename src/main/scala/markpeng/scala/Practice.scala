package markpeng.scala

object Practice {
  val breakException = new RuntimeException("break exception")

  def breakable(op: => Unit) {
    try {
      op
    } catch { case _: Exception => }
  }

  def break = throw breakException

  def install = {
    val env = System.getenv("SCALA_PATH")
    if (env == null) {
      println("Scala home not found!!!")
      break
    }
    println("found scala home!!!")
  }

  def main(args: Array[String]) {
    breakable(install)
  }
}

