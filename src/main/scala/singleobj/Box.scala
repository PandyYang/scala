package singleobj

// 定义单例对象使用关键字objecct
object Box {
  def info(message: String): Unit = println(s"hello $message")
}
