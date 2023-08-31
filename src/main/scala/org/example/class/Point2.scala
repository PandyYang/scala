package org.example.`class`

class Point2 {
  // var 和 val是共有的 但是val不能赋值 不带var及val是私有的
  private var _x = 0
  private var _y = 0
  private val bound = 100

  def x = _x

  def x_= (newValue: Int): Unit = {
    if (newValue < bound) _x = newValue else printWarning
  }

  def y = _y

  def y_= (newValue: Int): Unit = {
    if (newValue < bound) _y = newValue else printWarning
  }

  private def printWarning = println("WARNING: Out of bounds")
}

object Point2{
  def main(args: Array[String]): Unit = {
    val point2 = new Point2
    point2.x = 99
    point2.y = 101
  }
}
