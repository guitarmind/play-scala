package markpeng.scala.learningscala

object Ch5Ex {
  // placeholder syntax
  def tripleOp[A, B](a: A, b: A, c: A, f: (A, A, A) => B) = f(a, b, c)

  /**
   * (Int, Int) => Boolean
   */
  def factorOf(x: Int, y: Int) = y % x == 0
  /**
   * Int => Int => Boolean
   */
  def factorOf2(x: Int)(y: Int) = y % x == 0

  /**
   * Invoking higher order function with function literal blocks
   */
  def safeStringOp(s: String)(f: String => String) = {
    if (s != null) f(s) else s
  }

  def main(args: Array[String]) {
    // shortcut using wildcard operator
    val f = factorOf _
    println(f)
    // partially apply
    val f2 = factorOf(3, _: Int)
    println(f2)
    println(f2(78))
    // currying
    val f3 = factorOf2(3) _
    println(f3)
    println(f3(78))

    val intCase = tripleOp[Int, Int](23, 92, 14, _ * _ + _)
    println(intCase)

    val doubleCase = tripleOp[Int, Double](23, 92, 14, 1.0 * _ / _ / _)
    println(doubleCase)

    val boolCase = tripleOp[Int, Boolean](23, 92, 14, _ > _ + _)
    println(boolCase)

    // function literal block
    val uuid = java.util.UUID.randomUUID().toString
    val timedUUID = safeStringOp(uuid) {
      s =>
        val now = System.currentTimeMillis
        val timed = s.take(24) + now
        timed.toUpperCase
    }
    println(timedUUID)

    // Ex 1.
    // function literal
    val highestNum = (x: Int, y: Int) => if (x > y) x else y
    // higher-order function
    def highestNumWrapper(x: (Int, Int, Int), f: (Int, Int) => Int) = f(x._1, f(x._2, x._3))
    println(highestNumWrapper((14, 7, 9), highestNum))

    // Ex 3.
    def ex3Func(a: Int) = (b: Int) => a * b
    val tripler = ex3Func(3)
    println(tripler(10))

  }
}