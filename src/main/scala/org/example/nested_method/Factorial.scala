package org.example.nested_method

class Factorial {
  def factorial(x: Int): Int = {
    def fact(x: Int, accumulator: Int): Int = {
      if(x <= 1) accumulator
      else fact(x - 1, x * accumulator)
    }
    fact(x, 1)
  }
}
