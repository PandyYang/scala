package org.example.named_param

class NamedParam {
  def printName(first: String, last: String): Unit = {
    println(first + " " + last)
  }

  // printName("John", "Smith")  // Prints "John Smith"
  // printName(first = "John", last = "Smith")  // Prints "John Smith"
  // printName(last = "Smith", first = "John")  // Prints "John Smith"

}
