---
name: Turtle
practices: input, classes
...

- Create a class called Turtle
- Create three Turtles
- Print info for each one
- Each Turtle needs to have:
    - Name (a `String`)
    - Color (a `String`)
    - Weight (a `double`)
    - Age (an `int`)
- Print each one as:

> [name] is a [color] turtle that weighs [weight] pounds and is [age] years old

Example:

> Frank is a blue turtle that weighs 50 pounds and is 15 years old

Hint:

- Turtle should have a constructor that takes all four values

Bonus:

- Make a function `toString` that returns that output as a String
- In `main`, call `System.out.println(turtle1);`
- Create a function to make a Turtle older (years older and pounds heavier)
- Give `Turtle` a function called `speed`, which returns its speed
- Speed is equal to `(age * 10) - (weight * 2)`
