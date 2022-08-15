package val_type

object ValType {
  def main(args: Array[String]): Unit = {

    val b: Byte = 1
    val i: Int = 1
    val l: Long = 1
    val s: Short = 1
    val d: Double = 2.0
    val f: Float = 3.0f

    val x = 1_000L   // val x: Long = 1000
    val y = 2.2D     // val y: Double = 2.2
    val z = 3.3F     // val z: Float = 3.3

    var a = BigInt(1_234_567_890_987_654_321L)
    var b2 = BigDecimal(123_456.789)

    val name = "Bill"   // String
    val c = 'a'         // Char

    // scala string支持插值表达式
    val firstName = "John"
    val mi = 'C'
    val lastName = "Doe"

    println(s"Name: $firstName $mi $lastName")   // "Name: John C Doe"

    // 支持多行
    val quote = """The essence of Scala:
               Fusion of functional and object-oriented
               programming in a typed setting."""
  }
}
