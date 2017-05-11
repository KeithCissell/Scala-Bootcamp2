// src/main/scala/bookwork/ch6-functionalprogramming/fold-map.sc

println(
    (List(1,2,3,4,5,6) foldRight List.empty[String]) {
      (x, list) => ("[" + x + "]") :: list
    }
)
