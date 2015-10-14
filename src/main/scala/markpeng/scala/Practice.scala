package markpeng.scala

object Practice {
  val breakException = new RuntimeException("break exception")

  def breakable(op: => Unit) {
    try {
      op
      // case _ equals to default !
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

  def printType(obj: AnyRef) = obj match {
    case s: String => println("This is a String")
    case l: List[_] => println("This is a List")
    case a: Array[_] => println("This is a Array")
    case d: java.util.Date => println("This is a date")
    case _ => println("Unsupported type!")
  }

  def rangeMatcher(num: Int) = num match {
    case within10 if within10 <= 10 => println("with in 0 to 10")
    case within100 if within100 <= 100 => println("with in 11 to 100")
    case beyond100 if beyond100 < Integer.MAX_VALUE => println("beyond 100")
  }

  val suffixes = List(
    "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th")

  def ordinal(number: Int) = number match {
    case tenTo20 if 10 to 20 contains tenTo20 => number + "th"
    case rest => {
      val out = rest + suffixes(number % 10)
      println(out)
      out
    }
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

    // for comprehension
    // imperative form
    val aList = List(1, 2, 3)
    val bList = List(4, 5, 6)

    for { a <- aList; b <- bList } println(a + b)

    // functional form
    val result = for { a <- aList; b <- bList } yield a + b
    for (r <- result) println(r)

    // print types
    printType(result)
    printType("Hello")
    printType(new java.util.Date())

    // guard clause
    rangeMatcher(123)

    // ordinal
    ordinal(999)
    ordinal(1)
    ordinal(2)
    ordinal(3)
  }
}

