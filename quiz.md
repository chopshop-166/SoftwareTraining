Software Literacy Assessment
============================

This quiz is designed to figure out roughly how familiar you are with basic programming concepts in Java.

1.  What's the primary difference between an `int` and a `double`?
2.  What is the result of `2 / 5`?
3.  What about `2.0 / 5.0`?
4.  What type would you use to store a message to the user? What would the code for one look like?
5.  How do you get a value out of a function? What if there is no value?
6.  What is special about a variable marked as `final`?
7.  How would you store dozens of the same type of value?
8.  How would your program make a single `true`/`false` decision?
9.  How do you create a new instance of the type `Victor` (ignore any arguments)?
10. What is the difference between a `while` loop and a `for` loop?
11. How do you tell the difference between a constructor and a function/method?
12. Describe what a `static` member is, namely how it differs from a non-`static` member.
13. Explain the difference between an interface (such as `SpeedController`) and a class (such as `CANJaguar`). Where would you be more likely to use one vs the other?
14. What is the mistake in the code fragment below? How might the code be changed to get the intended behavior?

```java
// Assume the variables named exist
public void setController(SpeedController c) {
	c = Robot.oi.someWheel;
}
SpeedController myWheel = null;
setController(myWheel);
myWheel.set(1.0);
```

*Extra:* Is there any software topic that you want to cover in more detail?
