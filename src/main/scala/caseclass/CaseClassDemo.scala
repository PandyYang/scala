package caseclass

object CaseClassDemo {
  def main(args: Array[String]): Unit = {
    val p = Person("Pandy Yang")
    p match {
      case Person(name) => println(name)
      case _ => println("defalt condition")
    }
  }
}
