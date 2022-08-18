package pattern_match

import scala.util.Random

object pattern_match {
  def main(args: Array[String]): Unit = {
    val x = Random.nextInt(10)

    x match {
      case 0 => "zero"
      case 1 => "one"
      case 2 => "two"
      case _ => "other"
    }

    println(x)

    println(matchTest(x))
  }

  def matchTest(x: Int): String = x match {
    case 1 => "one"
    case 2 => "two"
    case 3 => "three"
    case _ => "other"
  }
}
