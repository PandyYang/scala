
case class User(name: String, age: Int)

object ForTest {
  def main(args: Array[String]): Unit = {
    val userBase = List(
      User("Travis", 28),
      User("Kelly", 33),
      User("Pandy", 18)
    )

    // 序列推导
    // 形式为：推导使用形式为 for (enumerators) yield e 的 for 表达式，
    //此处 enumerators 指一组以分号分隔的枚举器。一个 enumerator 要么是一个产生新变量的生成器，
    //要么是一个过滤器。for 表达式在枚举器产生的每一次绑定中都会计算 e 值，并在循环结束后返回这些值组成的序列。

    // user <- userBase 生成器，我觉得叫提取器更好
    // (user.age >= 20 && user.age < 30) 过滤器
    val twentySomethings = for (user <- userBase if (user.age >= 20 && user.age < 30))

      // for循环后会创建一个List
      // yield user.name 其实等价于 List[String]
      yield user.name

    twentySomethings.foreach(name => println(name))

    foo(10, 10) foreach{
      case(i, j) => {
        println(s"$i, $j")
      }
    }
  }


  def foo(n: Int, v: Int) =
    for (i <- 0 until n; j <- i until n if i + j == v)
      yield (i, j)


}
