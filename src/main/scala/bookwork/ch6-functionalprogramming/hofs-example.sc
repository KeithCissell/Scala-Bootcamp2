// src/main/scala/bookwork/ch6-functionalprogramming/hofs-example.sc

(1 to 10) filter (_ % 2 == 0) map (_ * 2) reduce (_ * _)
