package org.example.advance_function

class AF {

}

val salaries = Seq(2000, 7000, 40000)

val doubleSalary = (x: Int) => x * 2

val newSalaries = salaries.map(doubleSalary)

val newSaries2 = salaries.map(x => x*2)
val newSaries3 = salaries.map(_ * 2)

case class WeeklyWeatherForecast(temperatures: Seq[Double]) {
  private def convertCtoF(temp: Double) = temp * 1.8 + 32
  // 传入对象方法 作为高阶函数的参数
  def forecastInFahrenheit: Seq[Double] = temperatures.map(convertCtoF)
}

object SalaryRaiser {
  def smallPromotion(salaries: List[Double]): List[Double] = salaries.map(salary => salary * 1.1)
  def greatPromotion(salaries: List[Double]): List[Double] = salaries.map(salary => salary * math.log(salary))

  def hugePromotion(salaries: List[Double]): List[Double] = salaries.map(salary => salary * salary)
}

object SalaryRaiser2 {
  private def promotion(salaries: List[Double], promotionFunction: Double => Double): List[Double] =
    salaries.map(promotionFunction)

  def smallPromotion(salaries: List[Double]): List[Double] = promotion(salaries, salary => salary * 1.1)
}

def urlBuilder(ssl: Boolean, domainName: String): (String, String) => String = {
  val schema = if(ssl) "https://" else "http://"
  (endpoint: String, query: String) => s"$schema$domainName/$endpoint?$query"
}

val domainName = "didablog"
def getURL = urlBuilder(ssl=true, domainName)
val endpoint = "users"
val query = "id=1"
val url = getURL(endpoint, query)