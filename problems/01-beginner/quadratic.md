---
name: Quadratic Solver
practices: variables, functions
...

- Make a file and class called Quadratic.
- Read three numbers `a`, `b`, `c` from the user
- Print all roots of `ax^2 + bx + c = 0`

Hint:

- Use `Math.sqrt` to get the square root of a number
- The Quadratic Formula is `(-b +- sqrt(b^2 - 4ac)) / 2a`, but this needs to be translated into code
- `+-` means that there can be two results

Bonus:

- Ask the user if they want to enter more numbers (hint: use `scanner.nextBoolean()` to get `true` or `false`)
- Make a function `quadratic` that takes the three numbers and prints the roots
- Calculate `d = b^2 - 4ac`. If `d` is 0, then there is only one root, so print it once.
- Print an error message if the user enters bad numbers (like if `a` is 0, or `d` is negative)

