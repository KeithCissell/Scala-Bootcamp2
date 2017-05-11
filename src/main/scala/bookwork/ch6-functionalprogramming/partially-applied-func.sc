// src/main/scala/bookwork/ch6-functionalprogramming/partially-applied-func.sc

def cat1(s1: String)(s2: String) = s1 + s2

val hello = cat1("Hello ") _

println(hello("World!"))
println(cat1("Hello ")("World!"))
