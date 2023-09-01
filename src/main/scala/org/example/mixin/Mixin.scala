package org.example.mixin

class Mixin {

}

abstract class A {
  val message: String
}

class B extends A {
  override val message: String = "I'm an instance to class B"
}

trait C extends A {
  def louadMessage = message.toUpperCase()
}

// 类D有一个父类B和一个混入C 一个类只能又一个父类 但是可以有多个混入
class D extends B with C

// ==================================================
abstract class AbsIterator {
  type T
  def hashNext: Boolean
  def next(): T
}

class StringIterator(s: String) extends AbsIterator {
  type T = Char
  private var i = 0

  override def hashNext: Boolean = i < s.length

  override def next(): Char = {
    val ch = s charAt i
    i += 1
    ch
  }
}

// 特质不必实现其中的抽象成员
trait RichIterator extends AbsIterator {
  def foreach(f: T => Unit): Unit = while (hashNext) f(next())
}

// 组合StringIterator 和 RichIterator
// 新的类有一个父类和一个混入
object StringIteratorTest extends App {
  class RichStringIter extends StringIterator("Scala") with RichIterator
  val richStringIter = new RichStringIter
  richStringIter foreach println
}

object Mixin {
  def main(args: Array[String]): Unit = {
    val d = new D
    println(d.message)
    println(d.louadMessage)
  }
}