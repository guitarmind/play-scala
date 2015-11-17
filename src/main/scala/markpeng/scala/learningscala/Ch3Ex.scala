package markpeng.scala.learningscala

object Ch3Ex {
  def main(args: Array[String]) {
    // 1.
    //    val s = "Test123"
    val s = ""
    val result = if (s == "") "n/a" else s
    println(result)

    val result2 = s match {
      case "" => "n/a"
      case s => s
      case _ => "null"
    }
    println(result2)

    // 2.
    val amount = 123.0
    val result3 = amount match {
      case v if v > 0 => "greater"
      case v if v == 0 => "same"
      case v if v < 0 => "less"
    }
    println(result3)

    // 3.
    for (i <- 1 to 100 by 5) {
      for (j <- i to (i + 4)) {
        print(s"$j, ")
      }
      println()
    }

    // 4. 
    for (i <- 1 to 100) {
      i match {
        case x if x % 15 == 0 => println("typesafe")
        case x if x % 5 == 0 => println("safe")
        case x if x % 3 == 0 => println("type")
        case _ => println(i)
      }

    }
  }
}