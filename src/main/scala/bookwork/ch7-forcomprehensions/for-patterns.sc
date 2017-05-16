// src/main/scala/bookwork/ch7-forcomprehensions/for-patterns.sc

val ignoreRegex = """^\s*(#.*|\s*)$""".r
val kvRegex = """^\s*([^=]+)\s*=\s*([^#]+)\s*.*$""".r

val properties = """
  # Book properties

  book.name = Programming Scala, Second Edition # a comment
  book.authors = Dean Wampler and Alex Payne
  book.publisher = O'Reilly
  book.publication-year = 2014
  """.stripMargin

val kvPairs = for {
  prop <- properties.split("\n")
  if ignoreRegex.findFirstIn(prop) == None
  kvRegex(key, value) = prop
} yield (key.trim, value.trim)

kvPairs foreach println
