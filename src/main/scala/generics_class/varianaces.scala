package generics_class

/**
 * 型变
 * 型变是复杂类型的子类型关系与其组件类型的子类型关系的相关性。
 * Scala支持 泛型类 的类型参数的型变注释，允许它们是协变的，逆变的，
 * 或在没有使用注释的情况下是不变的。 在类型系统中使用型变允许我们在复杂类型之间建立直观的连接，
 * 而缺乏型变则会限制类抽象的重用性。
 */


// 有关逆变和协变的说明，请参考wikipedia
// https://zh.wikipedia.org/zh-cn/%E5%8D%8F%E5%8F%98%E4%B8%8E%E9%80%86%E5%8F%98

// 协变
class Foo[+A]
// 逆变
class Bar[-A]
// 不变
class Baz[A]

abstract class Animal {
  def name: String
}

case class Cat(name: String) extends Animal
case class Dog(name: String) extends Animal

// List[A+] 是scala标准库的一个通用不变类 它是协变的 意味着List[Cat]是List[Animal]
object ConvaarianceTest extends App {
  def printAnimalNames(animals: List[Animal]): Unit = {
    animals.foreach{
      animal => println(animal.name)
    }
  }

  val cats: List[Cat] = List(Cat("Whiskers"), Cat("Tom"))
  val dogs: List[Dog] = List(Dog("Fido"), Dog("Rex"))

  printAnimalNames(cats)

  printAnimalNames(dogs)


  // 逆变和协变完全相反 如果定义一个Writer[-A]
  // A是B的子类型 则Write[B]是Write[A]的子类型

  val myCat: Cat = Cat("boots")

  def printMyCat(printer: Printer[Cat]): Unit = {
    printer.print(myCat)
  }

  val catPrinter = new CatPrinter
  val animalPrinter = new AnimalPrinter

  printMyCat(catPrinter)
  printMyCat(animalPrinter)
}

/**
 * 如果 Printer[Cat] 知道如何在控制台打印出任意 Cat，并且 Printer[Animal]
 * 知道如何在控制台打印出任意 Animal，那么 Printer[Animal] 也应该知道如何打印出 Cat 就是合理的。
 * 反向关系不适用，因为 Printer[Cat] 并不知道如何在控制台打印出任意 Animal。
 * 因此，如果我们愿意，我们应该能够用 Printer[Animal] 替换 Printer[Cat]，
 * 而使 Printer[A] 逆变允许我们做到这一点。
 * @tparam A
 */
abstract class Printer[-A] {
  def print(value: A): Unit
}

class AnimalPrinter extends Printer[Animal] {
  override def print(value: Animal): Unit = println("the animal's nama is " + value.name)
}

class CatPrinter extends Printer[Cat] {
  override def print(value: Cat): Unit = println("the cat's name is " + value.name)
}

// 不变 scala中的泛型类默认是不变的
class Container[A](value: A) {
  private var _value: A = value
  def getValue: A = _value
  def setValue(value: A): Unit = {
    _value = value
  }
}

// 虽然cat 像是一只 animal，但是如果创建一只cat，再将其协变为animal，
// 之后调用animal的bak方法（即犬吠），那么将产生一个错误。

object Varianaces {
  def main(args: Array[String]): Unit = {
    val catContainer: Container[Cat] = new Container(Cat("Felix"))
    //val animalContainer: Container[Animal] = catContainer
    //animalContainer.setValue(Dog("Spot"))
    //val cat: Cat = catContainer.getValue // 糟糕，我们最终会将一只狗作为值分配给一只猫
  }
}

/**
 * 假设我们正在处理接受动物类型的函数，并返回他们的食物类型。 
 * 如果我们想要一个 Cat => SmallAnimal（因为猫吃小动物），
 * 但是给它一个 Animal => Mouse，我们的程序仍然可以工作。 
 * 直观地看，一个 Animal => Mouse 的函数仍然会接受一个 Cat 作为参数，
 * 因为 Cat 即是一个 Animal，并且这个函数返回一个 Mouse，也是一个 SmallAnimal。 
 * 既然我们可以安全地，隐式地用后者代替前者，我们可以说 Animal => Mouse 是 Cat => SmallAnimal 的子类型。
 */
abstract class SmallAnimal extends Animal
case class Mouse(name: String) extends SmallAnimal

