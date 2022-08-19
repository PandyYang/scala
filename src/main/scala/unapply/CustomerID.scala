package unapply

import scala.util.Random

/**
 * 提取器对象是一个包含有 unapply 方法的单例对象。apply 方法就像一个构造器，
 * 接受参数然后创建一个实例对象，反之 unapply 方法接受一个实例对象然后返回最初创建它所用的参数。
 * 提取器常用在模式匹配和偏函数中。
 */
object CustomerID {

  def apply(name: String) = s"$name -- ${Random.nextLong}"

  /**
   * 如果只是用来判断真假，可以返回一个 Boolean 类型的值。例如 case even()。
   * 如果只是用来提取单个 T 类型的值，可以返回 Option[T]。
   * 如果你想要提取多个值，类型分别为 T1,...,Tn，可以把它们放在一个可选的元组中 Option[(T1,...,Tn)]。
   * @param customerID
   * @return
   */
  def unapply(customerID: String): Option[String] = {
    val stringArray: Array[String] = customerID.split("--")
    if (stringArray.tail.nonEmpty) Some(stringArray.head) else None
  }

  def main(args: Array[String]): Unit = {
    // 等价于 val name = CustomerID.unapply(customer2ID).get
    val customerID = CustomerID("Sukyong")
    customerID match {
      // 如果没有匹配会 抛出scala.MatchError
      case CustomerID(name) => println(name)
      case _ => println("Could not extract a CustomerID")
    }
  }
}
