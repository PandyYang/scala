package singleobj

class Email(val username: String, val domainName: String)

/**
 * 伴生对象也可以包含工厂方法
 * 例如下面的fromString
 */


object Email {
  def fromString(emailString: String): Option[Email] = {
    emailString.split("@") match {
      case Array(a, b) => Some(new Email(a, b))
      case _ => None
    }
  }

  def main(args: Array[String]): Unit = {
    val scalaCenterEmail = Email.fromString("scala.center@epfl.ch")
    scalaCenterEmail match {
      case Some(email) => println(
        s"""
           |Registered an email
           |Username: ${email.username}
           |Doamin namae: ${email.domainName}
           |""".stripMargin
      )

      case None => println("Error: could not parse email")
    }
  }
}

