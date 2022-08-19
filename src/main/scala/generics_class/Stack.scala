package generics_class

// 定义一个范型类
class Stack[A] {
  private var elements: List[A] = Nil
  def push(x: A): Unit = elements = x::elements
  def peek: A = elements.head
  def pop(): A = {
    val currentTop = peek
    elements = elements.tail
    currentTop
  }
}

class Fruit
class Apple extends Fruit
class Banana extends Fruit

object StackTest{
  def main(args: Array[String]): Unit = {
    val stack = new Stack[Int]

    stack.push(1)
    stack.push(2)

    println(stack.pop())
    println(stack.pop())

    // 如果参数类型有子类型 子类型可以被传入
    val stack2 = new Stack[Fruit]
    val apple = new Apple
    val banana = new Banana
    stack2.push(apple)
    stack2.push(banana)
  }
}