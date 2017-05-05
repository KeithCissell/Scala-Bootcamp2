# Iteration2
Iteration2 of the scala learning modules.

## Book Work
Working along with O'Reilly's Programming Scala 2nd Edition.

### Chapter 5 - Implicits
- Implicit
  - Can provide a constraint on parameters for a function
  - Can infer type from input parameter
  - Can provide a default parameter when none is provided
  - Allow multiple definitions of a method
  - Allow the creation of custom interpolated strings
- Context Bound type parameter `[B : Ordering]` - (see implicitly-args.sc)
- DSL (Domain-Specific Language)
  - Implicits are good to put in DSLs to provide:
    - intuitive programming for clients
    - ease of use with user related programs / databases
    - integrating between languages (Java, SQL -> Scala)
    - keeping code separate and clean
- Implicit Conversion
  - `Type => NewType` `(Type1,Type2) => Type3`
  - constrains the input type to a supertype
  - implicitly defines the output type to a subtype or the input type
- Implicit Evidence
  - doesn't require input to conform to the same supertype
  - Only needs a constraint to use as "evidence" that a type meets the required parameter's
  - Can be written as: `A <:< (T, U)` or infix notation `<:<[A, (T, U)]`
- NOTE: don't use implicit statements for common types such as Int or String
  - this can lead to complications as these implicits can be defined in multiple places
- Phantom Types
  - used as markers to define a type that has no instances
  - useful for defining work flows that must proceed in a particular order
- Pipeline Operator: `|>` used to reorder tokens
  - Changes this: `pay1 |> Payroll.minus401k`
  - Into this: `Payroll.minus401k(pay1)`
- Rules for Implicit Arguments
  - all implicit arguments must be in the same argument list
  - the 'implicit' term is only used once at the beginning of the list
  - this implicit argument list must be the final list in the definition
  - Example: `def good(i: Int)(implicit s: String, d: Double) = {...}`
- Type Classes
  - Allow the creation of classes that add method extentions to a superclass
  - Useful when you only need the behavior on a few clients vs the majority of them
- Zip Method
  - `list1 zip list2`
  - creates a new list of pairs (Tuple2's) matching items in the two lists based on index
  - if one list is longer than the other, the extra elements are lost
- List of (most) Built-In implicits: pg. 161
  - lots of conversion methods
  - to/from Java
  - OS processes analogous to running UNIX shell commands
- Making Implicit usage more readable/understandable
  - name the package for them `implicit`
  - put them in an object named `Implicit`
