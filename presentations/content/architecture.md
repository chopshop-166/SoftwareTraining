% The Architecture of FRC Robot Code
% Matt Soucy (<msoucy@csh.rit.edu>)

# Overview

```dot
Robot -> Components -> Subsystems -> Commands
```

- Components are a code representation of a hardware component
- Subsystems describe the logical parts of the physical robot
- Commands describe robot behavior in broad terms

---

# Component

A Component is the code version of a sensor, motor, etc.

Examples:

- `Joystick`
- `TalonSRX`
- `Victor`
- `RobotDrive`

*`Component` is a term specific to this presentation, and is not a WPILib term.*

# Custom Components

You can write your own Components to make things work the way you want.
For example, we have a `MultiSpeedController` that looks like a `SpeedController`, but actually controls several `SpeedController`s.
This is handy  for locking two `SpeedController`s to the same speed.

---

# Subsystem

**Subsystems** are made of Components (sensors, motors, servos, etc), and expose logic about what they do.
The purpose is to add a level of ***abstraction***.

# Subsystems and Abstraction

Let's say we have an arm on a robot.
This arm was designed to use a motor to raise and lower it.
So we write the outline of our subsystem:

```java
public class ClawArm extends Subsystem {
    Victor motor;

    public ClawArm()
    {
        motor = new Victor(RobotMap.Pwm.RollerVictor);
    }

}
```

# Writing actions

A subsystem is useless if we can't control it.
Let's start by writing methods to control the arm:

```java
public class ClawArm extends Subsystem {
    Victor motor;

    public ClawArm()
    {
        motor = new Victor(RobotMap.Pwm.RollerVictor);
    }

    public void moveForward()
    {
        motor.setSpeed(1);
    }

    public void moveBackward()
    {
        motor.setSpeed(-1);
    }
}
```

# Commanding a subsystem

Of course, now we need a command or two:

```java
public class RaiseArm extends Command {

    public RaiseArm() {
        requires(Robot.arm);
    }

    protected void initialize() {
        Robot.arm.moveForward();
    }

    protected void execute() { }

    protected boolean isFinished() {
        return true;
    }

    protected void end() { }

    protected void interrupted() { }
}
```

- What direction is "forward"?
- What if the subsystem changes?

# The design changes

After some deliberation, the design for the arm has been changed to use a solenoid instead.

What needs to change?

> - `RobotMap` (but this would happen no matter what)
> - The subsystem
> - The command

# The New Subsystem

```java
public class ClawArm extends Subsystem {
    DoubleSolenoid solenoid;

    public ClawArm()
    {
        solenoid = new Victor(RobotMap.Digital.ArmUp,
                              RobotMap.Digital.ArmDown);
    }

    public void moveForward()
    {
        solenoid.set(DoubleSolenoid.Value.kForward);
    }

    public void moveBackward()
    {
        solenoid.set(DoubleSolenoid.Value.kReverse);
    }
}
```

Not horrible, right?
The command doesn't have to change, but we still don't know what "forward" and "backward" are.

# The Abstract Subsystem

```java
public class ClawArm extends Subsystem {
    DoubleSolenoid solenoid;

    public ClawArm()
    {
        solenoid = new Victor(RobotMap.Digital.ArmUp,
                              RobotMap.Digital.ArmDown);
    }

    public void raise()
    {
        solenoid.set(DoubleSolenoid.Value.kForward);
    }

    public void lower()
    {
        solenoid.set(DoubleSolenoid.Value.kReverse);
    }
}
```

The only thing that changed was method names. Why is this important?

# The Abstract Command

```java
public class RaiseArm extends Command {

    public RaiseArm() {
        requires(Robot.arm);
    }

    protected void initialize() {
        Robot.arm.raise();
    }

    protected void execute() { }

    protected boolean isFinished() {
        return true;
    }

    protected void end() { }

    protected void interrupted() { }
}
```

The command itself is still only one line, but it's obvious what it's intended to do.

***This would never have had to change if the subsystem had called the method `.raise()` in the first place!***

# Lessons Learned for Subsystems

> - Abstraction is *GOOD*
> - Any code working with a subsystem should have no idea HOW the subsystem works
> - A subsystem can do one thing at a time
>     - To put it another way, ***if you want part of the robot to do two things at once, look to see if it should be two subsystems***

---

# Commands

. . .

A command is:

- Something that you can execute
- A single action that a subsystem performs
- Something the operator (or autonomous) can start
- A description of the robot's behavior

They can be simple, just calling one method of one subsystem:


- `RaiseArm`
- `DriveWithJoysticks`

Or they might be complex, with sequencing and tasks in parallel:

- `AimAndThenShoot`
- `CollectBall` (sequence of `StartCollector`, `LowerArm`, `WaitUntilBallCollected`, `RaiseArm`, and `StopCollector`)
- `Autonomous`

# Command Parts

When creating a command, you have to think carefully about its behavior:

```java
public class CustomCommand extends Command {

    public CustomCommand() {
		// Tell the command which subsystem it uses
        requires(Robot.mysubsystem);
    }

    protected void initialize() {
		// Happens once, when the command is first run
    }

    protected void execute() {
		// Happens on loop for as long as the command is active
	}

    protected boolean isFinished() {
		// Tells the command when to finish
        return true;
    }

    protected void end() {
		// Runs after the command is finished
	}

    protected void interrupted() {
		// Runs if another command wants to use its subsystem
	}
}
```

# Using Commands

In general, there are three kinds of command:

- Commands that trigger (such as "shoot ball")
- Commands that run continuously (such as "move arm to specific point")
- Commands that are made of other commands (doing several things, in sequence or parallel)

Depending on what kind of command you have, your command class can look very different.

# Trigger Commands

Has behavior that happens once, when the command first executes

```java
public class ShootBall extends Command {

    public ShootBall() {
        requires(Robot.shooter);
    }

    protected void initialize() {
        Robot.shooter.shoot();
    }

    protected void execute() { }

    protected boolean isFinished() {
        return true;
    }

    protected void end() { }

    protected void interrupted() { }
}
```

The relevant methods are `initialize()`, `isFinished()`, and the constructor!
The rest can be empty.
Returning true just runs initialize() and exits

# Continuous Command

Does one thing, until a condition is met

```java
public class RaiseElevatorToTop extends CommandGroup {

    public RaiseElevatorToTop() {
        requires(Robot.elevator);
    }

    protected void initialize() { }

    protected void execute() {
        Robot.elevator.raise();
	}

    protected boolean isFinished() {
        return Robot.elevator.isAtTop();
    }

    protected void end() { Robot.elevator.halt(); }

    protected void interrupted() { Robot.elevator.halt(); }
}
```

- Since this gets run continuously, `initialize()` doesn't need to do much.
- `execute()` sets the speed each cycle
- `end()` and `interrupted()` handle cleanup
- `isFinished()` is essential here

# Command Groups

Does multiple **related** things, at once or sequentially

```java
public class AutoScoreHigh extends CommandGroup {

    public AutoScoreHigh() {
        // No requires() call, the subcommands do that
		addParallel(new PrepareBallRollers());
		addSequential(new AlignRobotWithTarget());
		addSequential(new WaitForChildren()); // Wait half a second
		addSequential(new PrintCommand("Fire in the hole!"));
		addSequential(new LaunchBall());
		addSequential(new WaitCommand(0.5)); // Wait half a second
		addSequential(new StopBallRollers());
    }

}
```

- `addSequential()` waits until the command finishes before moving on
- `addParallel()` launches its command and then moves on
- `PrintCommand`, `WaitCommand`, `WaitForChildren` are built in to WPILib (along with others)
