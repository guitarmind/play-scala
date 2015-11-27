package markpeng.scala.learningscala

object Ch6Ex {
  def main(args: Array[String]) {
    // Ex 1.
    for (i <- 0L to 9L; j = i * 2 + 1) yield j
    0L to 20L filter (_ % 2 == 1)
    0L to 9L map (_ * 2 + 1)

    // Ex 2.
    def factors(x: Int) = { 2 to (x - 1) filter (x % _ == 0) }
    def uniqueFactors(l: Seq[Int]) = l flatMap factors
    println(uniqueFactors(List(9, 11, 13, 15)))

    // Ex 3.
    val chars = ('a' to 'f').toList
    // def first[A](items: List[A], count: Int): List[A] = items take count
    def first[A](items: List[A], count: Int): List[A] = {
      val l = for (i <- 0 until count) yield items(i)
      l.toList
    }
    println(first(chars, 3))

    // Ex 4. 
    val names = List("Harry", "Hermione", "Ron", "Snape")
    def greatest[A](l: List[A], max: (A, A) => A): A = {
      l reduce ((a, i) => max(a, i))
    }
    println(greatest[String](names, (x, y) => if (x.size > y.size) x else y))

    // Ex 5. 
    def reverse[A](src: List[A], dest: List[A] = Nil): List[A] = {
      if (src == Nil) dest else reverse(src.tail, src.head :: dest)
    }
    println(reverse(names))

    // Ex 7.
    var url = "http://api.openweathermap.org/data/2.5/forecast?mode=xml&lat=55&lon=0&APPID=4d19c8743a6df6bfacac0fc7fc4fcbf3"
    var l: List[String] = io.Source.fromURL(url).getLines.toList
    println(l(0))
  }
}