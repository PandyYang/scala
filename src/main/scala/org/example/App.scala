package org.example

import org.example.`class`.Point

/**
 * @author ${user.name}
 */
object App {
  
  def foo(x : Array[String]) = x.foldLeft("")((a,b) => a + b)
  
  def main(args : Array[String]) {
    println( "Hello World!" )
    println("concat arguments = " + foo(args))

    val point1 = new Point(2, 3)
    point1.x
    println(point1)
  }

}
