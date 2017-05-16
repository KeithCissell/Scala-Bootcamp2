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
- Containers
  - Option
    - Some/None: handles cases of zero or one items
  - Either
    - handles cases of one item or another
    - Parameters `Either[+A, +B]`
    - subclasses: `Left[A]` and `Right[B]`
    - can be used for exception handling
  - Try/Catch
    - subclasses: `Success` and `Failure`
    - stops after error thrown
    - assertion
      - use in a try without needing a catch: `Try{assert(i > 0, "Assertion Error")}`
  - Validation
    - allows for all errors to be accumulated and then dealt with at the
    - 3rd party import from the Scalaz library
    - great for forms
    - Returns `Success` or `Failure` subclass (not the Try subclasses)
    - Can return lists of results or list of failures
