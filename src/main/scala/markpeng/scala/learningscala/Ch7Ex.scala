package markpeng.scala.learningscala

object Ch7Ex {
  def main(args: Array[String]) {
    // Ex 1.
    def fibAdd(l: List[Int], count: Int): List[Int] = {
      if (count < 1) l
      else {
        val k = l :+ l.takeRight(2).sum
        fibAdd(k, count - 1)
      }
    }
    val more = fibAdd(List(1, 1, 2, 3), 10)
    println(more)

    // Ex 4. 
    def toDouble(a: String) = util.Try(a.toDouble).toOption
    val x = toDouble("a")
    println(x)

    // Ex
  }
}