// src/main/scala/bookwork/ch6-functionalprogramming/fold-reduce.sc

val list = List(1,2,3,4,5,6)

val reduce = list reduce (_ + _)

val fold1 = list.fold(10) (_ * _)

val fold2 = (list fold 10) (_ * _)

println(reduce)
println(fold1)
println(fold2)
