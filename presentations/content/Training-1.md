---
title: 1st Training
...

# Chop Shop 166

# Agenda

1. Introduction
2. Installing Requisite Software
3. Your first program

# Introduction

Welcome to the Software sub-team of ChopShop.

# Introduction

We take the robot that the mechanical team builds:

![Maverick before competitions](content/images/robot.JPG "Robot during build")

# Introduction

Write code in Java that uses input from the driver and sensors to control the robot:

```java
public Command joystickArcadeTwoStick(final Joystick left, final Joystick right) {
    return new Command("Joystick Arcade with two sticks", this) {
        @Override
        protected void execute() {
            driveTrain.arcadeDrive(-left.getY() * 0.8, right.getX());
        }

        @Override
        protected boolean isFinished() {
            return false;
        }
    };
};
```

# Introduction

So that we can compete in competitions:

![Maverick at Competition](content/images/robot_competition.JPG "Robot at Competition")

# Introduction

Who are you?

1. What's your name?
2. What grade are you in?
3. Have you done any programming before?

# Installing Software

Before we can start programming we have to install some software.

**Everyone:**

* Java JDK
* Visual Studio Code
    * Java Plugins
* Git Kraken

**New Members Only:**

* FIRST Team Update 2018.1
* Radio Reprogramming tool

We will pass around flash drives with the required software on them. Please copy the files onto your desktop then pass the flash drive along.

# Visual Studio Code

Visual Studio Code is a free editor being written primarily by Microsoft. It supports numerous languages through the usage of various plugins.
We will be using a few plugins to help program the robot

![Visual Studio Code Extension tab and search](content/images/Extensions.png "Extension tab in Visual Studio Code")

# Visual Studio Code Extensions

Extensions we will be using

* [Java Extension Pack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
* [WPILib VS Code Extension](https://github.com/wpilibsuite/vscode-wpilib/releases)

# Your First Program

Create a new file and name it `HelloWorld.java`

. . .

Type the following into the file:

```java
public class HelloWorld {
  public static void main (String[] args) {
      System.out.println("Hello World");
  }
}
```

. . .

* We create a class with the same name as the file.

. . .

* `main` is a function that is run automatically when your program starts

. . .

* Finally we call `println` with `"Hello World"`

# Your First Program

Now modify this program to print the following information about yourself:

* Name
* Grade (Freshman, Sophomore, etc)
* Favorite video game

```
Ben
Graduated
Minecraft
```

# Homework!

<!-- Figure out homework -->
