package markpeng.scala.learningscala

object Ch4Ex {
  def main(args: Array[String]) {
    // 3. tail-recursion
    @annotation.tailrec
    def fives(cur: Int, max: Int): Unit = {
      if (cur <= max) {
        println(cur)
        fives(cur + 5, max)
      }
    }
    fives(5, 50)

    // 4.
    def descTime(epochMs: Long) = {
      val secs = epochMs / 1000

      val days = secs / 86400
      val hours = (secs % 86400) / 3600
      val minutes = (secs % 3600) / 60
      val seconds = secs % 60
      s"$days days, $hours hours, $minutes minutes, $seconds seconds"
    }
    println(descTime(123456789000L))

    // 6. 
    def offset(src: (Int, Int), dest: (Int, Int)) = {
      (dest._1 - src._1, dest._2 - src._2)
    }
    println(offset((4, 9), (122, 27)))

    // 7.
    def intFirst[A, B](t: (A, B)): (Any, Any) = {
      def isInt(x: Any) = x.isInstanceOf[Int]
      (isInt(t._1), isInt(t._2)) match {
        case (false, true) => (t._2, t._1)
        case _ => t
      }
    }
    println(intFirst(('a', 2)))
    println(intFirst((1, false)))
    println(intFirst((1, 4)))

    // 8.
    def stringify[A, B, C](t: (A, B, C)): (A, String, B, String, C, String) = {
      (t._1, t._1.toString(), t._2, t._2.toString(), t._3, t._3.toString())
    }
    val t: (Int, String, Char, String, Boolean, String) = stringify((1, 'c', true))
    println(t)

  }
}