package pattern_match

/**
 * 密封类必须将所有类定义在一个文件里，
 * 意味着模式匹配的时候 不用考虑别的情况
 */
sealed abstract class Furniture

case class Couch() extends Furniture
case class Chair() extends Furniture

object Test{

  def main(args: Array[String]): Unit = {

  }

  def findPlaceToSit(piece: Furniture): String = piece match {
    case a: Couch => "Lie on the couch"
    case b: Chair => "Sit on the chair"
  }
}
