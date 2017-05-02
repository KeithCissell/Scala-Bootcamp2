// src/main/scala/bookwork/ch4-patternmatching/match-tuple.sc

val langs = Seq(
  ("Scala", "Martin", "Odersky"),
  ("Clojure", "Rich", "Hickey"),
  ("Lisp", "John", "McCarthy")
)

for (tuple <- langs) {
  tuple match {
    case ("Scala", _, _) => println("Found Scala")
    case (lang, first, last) => println(s"Found other language: $lang ($first, $last))")
  }
}
