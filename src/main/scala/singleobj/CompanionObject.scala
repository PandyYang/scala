package singleobj

import Math.PI
import Math.pow
// 当一个单例对象和某个类 共享一个名称时 这个单例对象称谓伴生对象

/**
 * 当一个单例对象和某个类共享一个名称时，这个单例对象称为 伴生对象。
 * 同理，这个类被称为是这个单例对象的伴生类。类和它的伴生对象可以互相访问其私有成员。
 * 使用伴生对象来定义那些在伴生类中不依赖于实例化对象而存在的成员变量或者方法。
 */
object CompanionObject {

  /**
   * 这里的 class CompanionObject 有一个成员 area 是和具体的实例化对象相关的，
   * 单例对象 object CompanionObject 包含一个方法 calculateArea ，它在每一个实例化对象中都是可见的。
   * @param radio
   * @return
   */

    // 默认为static 伴生对象的成员会被定义为伴生类中的static成员 这叫做静态转发
    private def calculateArea(radio: Double): Double = PI * pow(radio, 2.0)

  def main(args: Array[String]): Unit = {
    val circle = CompanionObject(5.0)
    println(circle.area)
  }
}

/**
 * 同理，这个类被称为是这个单例对象的伴生类。类和它的伴生对象可以互相访问其私有成员。
 * 使用伴生对象来定义那些在伴生类中不依赖于实例化对象而存在的成员变量或者方法。
 * @param radius
 */
case class CompanionObject(radius: Double) {
  import CompanionObject._
  // 此时calculateArea是一个转发过来的静态对象
  def area: Double = calculateArea(radius)
}
