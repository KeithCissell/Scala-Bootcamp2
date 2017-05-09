// src/main/scala/bookwork/ch6-functionalprogramming/lifted-func.sc

val finicky: PartialFunction[String,String] = {
  case "finicky" => "FINICKY"
}

finicky("finicky")
finicky("other")  // MatchError

val finickyOption = finicky.lift

finickyOption("finicky")
finickyOption("other")  // Option[String] = None

val finicky2 = Function.unlift(finickyOption)

finicky2("finicky")
finicky2("other")  // MatchError
