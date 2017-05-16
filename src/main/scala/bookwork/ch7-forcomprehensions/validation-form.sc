// src/main/scala/bookwork/ch7-forcomprehensions/validation-form.sc
import scalaz._, std.AllInstances._

/** Validate a user's name; nonempty and alphabetic characters, only. */
def validName(key:String, name: String): Validation[List[String], List[(String, Any)]] = {
  val n = name.trim // remove whitespace
  if (n.length > 0 && n.matches("""^\p{Alpha}$""")) Success(List(key -> n))
  else Failure(List(s"Invalid $key <$n>"))
}

/** Validate that the string is an integer and greater than zero. */
def positive(key: String, n: String): Validation[List[String], List[(String, Any)]] = {
  try {
    val i = n.toInt
    if (i > 0) Success(List(key -> i))
    else Failure(List(s"Invalid $key $i"))
  } catch {
    case _: java.lang.NumberFormatException =>
      Failure(List(s"$n is not an integer"))
  }
}

def validateForm(firstName: String, lastName: String, age: String):
    Validation[List[String], List[(String, Any)]] = {
  validName("first-name", firstName) +++ validName("last-name", lastName) +++
    positive("age", age)
}


println(validateForm("Dean", "Wapler", "29"))
println(validateForm("", "Wapler", "29"))
println(validateForm("D e a n", "Wapler", "29"))
println(validateForm("D1e2a3n_", "Wapler", "29"))
println(validateForm("Dean", "", "29"))
println(validateForm("Dean", "Wapler", "0"))
println(validateForm("Dean", "Wapler", "xx"))
println(validateForm("", "Wapler", "0"))
println(validateForm("Dean", "Wapler", "0"))
println(validateForm("Dean", "", "29"))
println(validateForm("D e a n", "", "29"))
