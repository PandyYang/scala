package org.example.traits

import scala.collection.mutable.ArrayBuffer

trait HairColor[A]{
  def hasNext: Boolean
  def next(): A
}

class IntIterator(to: Int) extends Iterator[Int] {
  private var current = 0

  override def hasNext: Boolean = current < to

  override def next(): Int = {
    if(hasNext) {
      val t = current
      current += 1
      t
    } else 0
  }
}

trait Pet {
  val name: String
}

class Cat(val name: String) extends  Pet
class Dog(val name: String) extends Pet

object Traits {
  def main(args: Array[String]): Unit = {
    val dog = new Dog("Harry")
    val cat = new Cat("sally")

    val animals = ArrayBuffer.empty[Pet]

    animals.append(dog)
    animals.append(cat)
    animals.foreach(pet => println(pet))
  }
}