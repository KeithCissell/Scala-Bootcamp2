# Iteration2
Iteration2 of the scala learning modules.

## Book Work
Working along with O'Reilly's Programming Scala 2nd Edition.

### Chapter 4 - Pattern Matching
- Match
  - `val str = match x { ... }` declare str to be given a value within {} that will match to the input value of x
  - `case: _: Type  => "Found Type"` this case matches any x that is of Type
  - `case: 15 => "Fifteen"` this case matches to the int, 15
  - `case: 'v' => "var/val match"` use ticks to match to var/val v
  - `case: _: Int | _: Double => "Found number"` or statements can be worked into cases
