object HelloWorld {

  def main(args: Array[String]): Unit = {
    println("Hello World")

    val nums = List(1,2,3)
    val newNumbers = nums.map(_ * 2)
    newNumbers.foreach(println)

    val newNum2 = nums.filter(_ > 1)
    newNum2.foreach(println)

    println(List.range(1, 3))
    println(List.range(start = 1, end = 10, step = 2))
    println(List.fill(3)("foo"))
    println(List.tabulate(3)(n => n * n))
    println(List.tabulate(4)(n => n * n))

    val a = List(10, 20, 30, 40, 10)
    println(a.distinct)
    println(a.drop(2))
    println(a.dropRight(2))
    println(a.init)
    println(a.intersect(List(19, 20, 21)))
    println(a.take(3))

    var fruits = List("apple", "pear")
    println(fruits.map(_.toUpperCase()))
    println(fruits.flatMap(_.toUpperCase()))
  }
}
