// src/main/scala/bookwork/ch6-functionalprogramming/curried-func.sc

def cat2(s1: String) = (s2: String) => s1 + s2
val cat2hello = cat2("Hello ")


def cat3(s1: String, s2: String) = s1 + s2
val cat3Curried = (cat3 _).curried
