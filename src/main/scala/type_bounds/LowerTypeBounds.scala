package type_bounds

// 协变
//trait Node[+B] {
//  def prepend(elem: B): Node[B]
//}
//
//case class ListNode[+B](h: B, t: Node[B]) extends Node[B] {
//  def prepend(elem: B): ListNode[B] = ListNode(elem, this)
//  def head: B = h
//  def tail: Node[B] = t
//}
//
//case class Nil[+B]() extends Node[B] {
//  def prepend(elem: B): ListNode[B] = ListNode(elem, this)
//}

trait Node[+B] {
  def prepend[U >: B](element: U): Node[U]
}

case class ListNode[+B](h: B, t: Node[B]) extends Node[B] {
  def prepend[U >: B](elem: U): ListNode[U] = ListNode(elem, this)
  def head: B = h
  def tail: Node[B] = t
}

case class Nil[+B]() extends Node[B] {
  def prepend[U >: B](elem: U): ListNode[U] = ListNode(elem, this)
}

trait Bird

case class AfricanSwallow() extends Bird

case class EuropeanSwallow() extends Bird



object LowerTypeBounds {
  def main(args: Array[String]): Unit = {
    val africanSwallowList = ListNode[AfricanSwallow](AfricanSwallow(), Nil())
    val birdList: Node[Bird] = africanSwallowList
    birdList.prepend(EuropeanSwallow)
  }
}
