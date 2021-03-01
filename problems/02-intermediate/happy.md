---
name: Happy Numbers
practices: input, loops, conditionals
...

- Create a program called Happy
- Create a function that returns `true` if a number is perfect, `false` otherwise
- Loop for all numbers from 1 to 1,000 and print each happy number

Hints:

- A number is happy if the sum of the squares of its digits reach 1
- Example:

> 19:
  1^2 + 9^2 = 82
  8^2 + 2^2 = 68
  6^2 + 8^2 = 100
  1^2 + 0^2 + 0^2 = 1
  19 is happy

- Calculate the square of a number `n` with either `n * n` or `Math.pow(n, 2)`
- Convert a string to an integer with `Integer.parseInt(myString)`
- Convert an integer to a string with `Integer.toString(myInt)`
- Get a character of a string with `Character.toString(text.charAt(x))`

Bonus:

- Create a function that returns `true` if a number is prime, `false` otherwise
- A "happy prime" is a number that is both happy and prime
- Print all happy primes from 1 to 500
