package org.example.default_param

class DefaultParam {

  // 可以为参数提供默认值 但是只要调用方忽略一个参数 其他的参数就必须带名传入
  // 但是如果从Java中进行调用 默认参数是必填的
  def log(message: String, level: String = "INFO") = println(s"($level: $message)")

  // log("System starting")  // prints INFO: System starting
  // log("User not found", "WARNING")  // prints WARNING: User not found

//  class Point(val x: Double = 0, val y: Double = 0)
//  val point1 = new Point(y = 1)


}
