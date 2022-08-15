package for_loop

object ForLoop {

  def main(args: Array[String]): Unit = {
    val ints = List(1,2,3,4,5)

    // scala3
    // for i <- ints do println(i)

    for(i <- ints) println(i)

    // for do
//    for
//      i <- ints
//      if i > 2
//    do
//      println(i)

    // for expressions
    // val double = for i <- ints yield i * 2
     var double = for (i <- ints) yield i * 2
     println(double)

    double = for (i <- ints) yield i * 2
    double = for (i <- ints) yield (i * 2)
    double = for { i <- ints } yield (i * 2)

    println(double)

    val fruits = List
  }

}
