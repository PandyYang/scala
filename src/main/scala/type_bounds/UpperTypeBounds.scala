package type_bounds

abstract class Animal {
  def name: String
}

abstract class Pet extends Animal {}

class Cat extends Pet {
  override def name: String = "Cat"
}

class Dog extends Pet {
  override def name: String = "Dog"
}

class Lion extends Animal {
  override def name: String = "Lion"
}

// 类型变量P应该是Pet的子类
class PetContainer[P <: Pet](p: P) {
  def pet: P = p
}

object UpperTypeBounds extends App {
  val dogContainer = new PetContainer[Dog](new Dog)
  val catContainer = new PetContainer[Cat](new Cat)

  // lion不是Pet的子类
  // val lionContainer = new PetContainer[Lion](new Lion)
}


