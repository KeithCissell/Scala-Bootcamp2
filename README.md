# Iteration2
Iteration2 of the scala learning modules.

## Book Work
Working along with O'Reilly's Programming Scala 2nd Edition.

### Chapter 7 - for Comprehensions in Depth
- Under the Hood of For Comprehensions
  - Syntactic Sugar - calls:
    - foreach
    - map
    - flatMap
    - withFilter
- withFilter
  - operates like 'filter' but it doesn't construct a new collection
- foreach
  - works like a for comp with 1 generator and a method
- map
  - works like a for comp with 1 generator and a yield
- flatMap
  - works like a for comp with multiple generators and a yield
  - each generator except the last invokes flatMap
  - last generator invokes map
- guards
  - in a for comp it invokes a withFilter
- @
  - assigns a variable to the whole expression it matches to `x @ expr`
