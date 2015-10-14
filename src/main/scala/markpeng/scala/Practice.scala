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
    // break simulation
    //    breakable(install)

    //    val array = new Array[String](3)
    //    array(0) = "This"
    //    array(1) = "is"
    //    array(2) = "markpeng"
    //    array.foreach(println)

    val oldList = List(1, 2)
    // add to front
    val newList = 3 :: oldList
    println(newList)

    // add to end
    val newList2 = oldList :+ 3
    println(newList2)

    // create List through Nil
    val myList = "This" :: "is" :: "immutable" :: Nil
    println(myList)

    //    var afterDelete = newList.filterNot { x => x == 3 }
    val afterDelete = newList.filterNot(_ == 3)
    println(afterDelete)
  }
}

