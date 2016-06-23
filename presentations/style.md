% Style Guidelines
% Matt Soucy (<msoucy@csh.rit.edu>)
% February 8, 2014

# Illegible code

```java
public class Customer implements VendingMachine {
  
public int insertMoney(int money) {
		
					return money;}
	public int returnMoney(int money,
int price) {
		int returnMoney = money -
		price;
							return returnMoney;
	}
	public String purchaseItem
		(String name, int price){
		if(money >= price){
	return name;
	}
						else{
			return "You have insuffeicent funds"; 
			}
	}}	
```

What's wrong with this code?

---

# Style guidelines

Having a consistent style for all code in a project can be very helpful

- Indentation
    - Tabs vs Spaces
    - Positions
- Braces
- Comments
- Variable/Method names
	- Nouns
	- Verbs
	- Booleans

---

# Indentation

---

# Indentation (Tabs vs Spaces)

I personally prefer "tabs for indenting, space for formatting"

```java
public class Foo {
	// This has a tab before it
	public static int DATA = 5; // Comment
	                            // This is indented further with spaces
}
```

- Spaces
    - Code looks the same in every editor
- Tabs
    - Code looks the way each individual programmer prefers
- Tab Indent, Space Formatting
    - Logical indentation is the way the programmer likes, but formatting is consistent

It doesn't matter what you choose, as long as the project chooses only one

---

# Indentation (Spacing)

The typical rule is "each logical block is indented exactly one more time"

```java
public class Foo {
	public static void main() {
		// One more layer
		if(true) {
			// Keep going deeper
		} else
			System.err.println("Never reached");
	}
}
```

---

# Line lengths

Some places enforce line character lengths.
This is to help prevent programmers from scrolling around all the time.

Historically, the limit was 80 characters due to terminal sizes.
With wider and better screens nowadays, limits aren't AS important.

General rule: A line should fit entirely on a line without scrolling.

---

# Additional concerns

- Spaces inside of parenthesis
- Spaces between parenthesis and attached braces

---

# Braces

---

# Braces (Attachment)

Braces are typically considered "attached" or "detached" from a line

```java
if(something()) { // Attached
}
else
{
	// Detached
}
```

---

# Braces (Indentation)

Some styles involve indenting the parenthesis.

```
if(something)
	{
	something_else()
	}
```

Don't. Just...don't.

---

# Comments

---

# Comments

Comments are your friend.

```cpp
// C++ example for extra confusion
memfrob(some_ptr, 166); // What does this do?
```

When used properly, comments can help you recall code

```cpp
// Better, but talks about the function call itself
memfrob(some_ptr, 166); // Frobnicates 166 bytes of memory
```

The best comments aren't line-by-line but describe the intent

```cpp
// Much better comment
memfrob(some_ptr, 166); // "Encrypts" our values
```

---

# Block Comments

Block comments should be used in front of each method to explain the following:

- High-level overview
- Description of all arguments
- Explaination of return value, if any
- Exceptions thrown (if any)

Classes should also have a block comment explaining:

- High-level overview
- Basic intended usage

---

# Naming

---

# Variables

If you name a variable `kitten` then you make the compiler, and generations of programmers, cry. 
Variables should be named descriptively:

```java
// Obviously, the number of times the button was pressed
int timesPressed;
// Completely descriptive and self-explanatory
Victor leftFrontWheel;
```

Variables should NOT be named after what they're inside:

```java
// DO NOT DO THIS
// "Smurf Code"
public class Claw {
	Victor clawMotor;
	public void closeClaw()
	{
		clawMotor.set(1.0);
	}
}

Robot.claw.closeClaw(); // Redundant
```

---

# Formatting

A couple of different ways to capitalize and split words:

```java
int alloneword; // Bad, does not show word breaks
int camelCase; // Good, C/C++/Java convention - "Camel Case"
int ALLCAPS; // Good for constants and enums
int LeadingCamel; // Good for C/C++/Java Classes
```

---

# Nouns vs Verbs

Variables are nouns by nature. They are THINGS.

```java
int pressButton; // What?
int buttonValue; // Good
```

Methods are verbs. They are ACTIONS

```java
// Bad - What about the joystick is being used?
int joystick() {return 0;}
// Good
int getValue() {return 0;}
```

---

# Booleans

Boolean values are `true` or `false`. 99% of the time, you want to name them using `is` or `has`

```java
// Bad, programmer has to assume things about the function
public boolean closed() {return 0;}
// Good, looks almost like a question
public boolean isClosed() {return true;}
```

---

# Astyle

---

# Astyle Overview

Astyle is a convenient code formatter for C/C++/Java.

Others exist (such as clang-format) but astyle is the most well-known.

You may require a Unix/Linux/OSX machine to use it.

Comes with built-in styles for convenience.

---

# Allman Style

```cpp
int Foo(bool isBar)
{
	if (isBar)
	{
		bar();
		return 1;
	}
	else
		return 0;
}
```

---

# Java Style

```cpp
int Foo(bool isBar) {
	if (isBar) {
		bar();
		return 1;
	} else
		return 0;
}
```

---

# Whitesmith Style

```cpp
int Foo(bool isBar) 
	{
	if (isBar)
		{
		bar();
		return 1;
		}
	else
		return 0;
	}
```

---

# Banner Style

```cpp
int Foo(bool isBar) {
	if (isBar) {
		bar();
		return 1;
		}
	else
		return 0;
	}
```

---

# Horstmann Style

```cpp
int Foo(bool isBar)
{  if (isBar)
   {  bar();
	  return 1;
   } else
	  return 0;
}
```

---

# 1 True Brace Style

```cpp
int Foo(bool isBar)
{
	if (isFoo) {
		bar();
		return 1;
	} else {
		return 0;
	}
}
```

---

# That's all, folks
