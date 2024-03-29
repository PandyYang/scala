package org.example.tuple

// 元组是一个可以容纳不同类型元素的类 元组是不可变的
class Tuple {

}

object Tuple{
  def main(args: Array[String]): Unit = {
    val ingredient = ("Sugar", 25):Tuple2[String, Int]
    // 访问元组数据
    println(ingredient._1)
    println(ingredient._1)

    // 解构元组数据
    val (name, quantity) = ingredient
    println(name)
    println(quantity)

    // 模式匹配
    val planetDistanceFromSun = List(("Mercury", 57.9), ("Venus", 149.6), ("Earth", 149.6), ("Mars", 227.9), ("Jupiter", 778.3))
    planetDistanceFromSun.foreach(tuple => {
      tuple match {
        case ("Mercury", distance) => println(s"Mercury is $distance millions km far from Sun")

        case p if (p._1 == "Venus") => println(s"Venus is ${p._2} millions km far from Sun")

        case p if (p._1 == "Earth") => println(s"Blue planet is ${p._2} millions km far from Sun")

        case _ => println("Too far....")
      }
    })

    // for中提取处理
    val numPairs = List((2, 5), (3, 7), (20, 56))
    for((a, b) <- numPairs) {
      println(a * b)
    }
  }
}
