---
name: Guessing Game
practices: classes, input, methods
...

- Create a class called `RandomNumber`
- `RandomNumber` should take a number representing the level, and choose a random number:
    - 1-10 for level 1
    - 1-100 for level 2
    - 1-1000 for level 3
- Have the user guess the number, and the class will print "Too low" or "Too high"
- Print the user's score at the end of the game
    - Score is the maximum number to guess, minus the number of guesses
- End the game if the user guesses 0

Hints:

- Look up the `java.util.Random` class for getting random numbers

Bonus

- Prompt the user for a level
- Implement arbitrary levels for numbers greater than 3
- Change the score so that it is the optimal number of guesses minus the actual number of guesses
