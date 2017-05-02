# Iteration2
Iteration2 of the scala learning modules.

## Book Work
Working along with O'Reilly's Programming Scala 2nd Edition.

### Chapter 4 - Pattern Matching
- Sequence - Iterable list that can hold multiple types. `Seq(int, string, val)`
  - Parent type of iterable List and Vectors
  - `+:` constructor operator, binds to the right
  - `:+` constructor operator, binds to the left
  - Index - `seq.zipWithIndex` gives index values to a sequence
      - returns a tuple of the form `(seqItem, index)`
- `Nil` - represents an empty List of any type parameter
- Match
  - `val str = match x { ... }` declare str to be given a value within {} that will match to the input value of x
  - `case: _: Type  => "Found Type"` this case matches any x that is of Type
  - `case: 15 => "Fifteen"` this case matches to the int, 15
  - `case: 'v' => "var/val match"` use ticks to match to var/val v
  - `case: _: Int | _: Double => "Found number"` or statements can be worked into cases
  - For pattern matching on a variable argument list `@ _*`
- Extraction (unapply)
  - Lists, Vectors, Sequences
    - head +: tail
    - head1 +: head2 +: tail
  - Classes
    - Person(name, age, Address( _ , state, _ ))
- Regular Expressions
  - Turn a string into an RE with .r method `"""String with RE=(.+)""".r`
  - Manipulation methods such as finding and replacing `scala.util.matching.Regex`
- Adding a reference to content attempting to match: `case p @ Person(name, age, a @ Address(street, city, state))`
  - p is set to Person instance. Allows access by p.age etc.
  - Same thing with a and the instance of Address
- Note: Avoid Enumerations when pattern matching. The compiler can't tell if the matches are exhaustive
