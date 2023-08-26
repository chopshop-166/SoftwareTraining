# Basic training Schedule

## First Week:
 - [ ] Install software
  - [WPI VS Code](https://github.com/wpilibsuite/allwpilib/releases)
  - FRC Update (Driver Station)
  - [GitKraken](https://www.gitkraken.com/)
  - [Git](https://git-scm.com/)
  - [Radio programming tool](https://docs.wpilib.org/en/latest/docs/software/getting-started/radio-programming.html) (Advanced Students)
 - [ ] Demo of basic driving robot code
  - Start with OI and subsystem created, including default command defined
  - Talk through what is required as input to drive a robot
  - Let students drive the robot

### Projects
- Hello World!
   - Explore printing other things

## Second Week:
 - [ ] Comments
  - Explain comments
  - Add single line comment inside drive command
  - Add multi-line function comment for drive command
 - Basic input (Project)
 - [ ] Variables
  - `int`
    - Whole numbers, integars are passed to create motor controllers
  - `float`/`double`
    - Floating-point numbers
    - Store joystick inputs in variables
  - `boolean`
    - Stores true/false, button inputs
  - `string`
    - Stores text, We use these to name commands
  - Arrays
    - Store multiple values of the same type
    - We'll explore their usage later
 - [ ] Conditionals
  - `if`
    - Implement deadband in drive command
    - Reduce turning speed at higher forward speed
  ### Projects
   - Basic input
     - Ask for users name, greet them
     - Ask users age, print "You can drive" / "You can't drive" as appropriate
       - Accept floating point age, print "You can drive with supervision" if they're older than 15.5
     - Write program that prints the square of a number
## Third Week:
 - Write a functional calculator (Project)
 - [ ] Arrays
  - Review syntax
 - [ ] Loops
  - `for` loop syntax (comparison, iterator syntax)
    - Fill array by asking for numbers in for loop, print numbers in a separate loop
    - Print average of numbers gathered above
  - `while` loop syntax
    - Simple guessing game, ask user for number until it matches
    - Explain infinite loop as basis of robot control
 - [ ] Averaging Robot exercise
  - Add averaging to driver input
  - This is a Low Pass Filter
  - Explore how increasing the window size (# of samples) slows response
 ### Projects
- [ ] Create console programs / Review
  - Write a 2 function calculator
  - Write a 4 function calculator (Advanced)
## Fourth Week:
 - [ ] Functions
  - Way of encapsulating code that is re-used
    - 3 Components
      - Type
      - Name
      - Parameters
  - Explore existing functions in subsystem
    - Command function (returns a command)
    - Ask students to identify other functions
  - Robot Examples
    - Move deadband code into a function
    - Create function that finds average of an array (replace averaging code from previous session)
  - Console Examples
    - Square function
    - Min function
    - Max function
 - [ ] Cover git if there's time remaining


## Fifth Week:
 - [ ] Classes
  - Hold information (Member variables) and functionality (methods) that are related
  - We've already seen classes
    - Subsystem is a class
    - Commands are a class
  - Cover syntax
    - `public class Name {}`
    - Constructor, has the same name as the class
    - Member variables go at the top of the class
    - Methods go at the end, after member variables
    - Motor Class
      - What do we control about motors?
      - Values [-1,1]
      - Getters / Setters
      - Stop convenience feature
 - [ ] Inheritance
  - Classes `extend` other classes
  - Used to consolidate shared information/functionality
  - Extensions can add new functionality
  - Replace existing functionality
  - MotorGroup class
      - Has 2+ motors
      - Implement same functions as Motor
      - Add `getAverageSpeed()`
      - Arrays!
      - Variadic arguments
      - For loops!
  - `Drivetrain` class
      - Left and Right `Motor`
      - Following WPILib model
      - Show usage with different combinations of `Motor` and `MotorGroup`

## Sixth Week:
 - Explore classes used so far
  - Subsystem
  - Drive
  - SpeedController
 - [ ] Interfaces
  - Defines what methods a class has
  - A class `implements` an interface or interfaces
  - Drive Subsystem interface in robot map
    - Add interface definition
    - Fill in behavior in custom robot map
    - Get value from robot map in Drive Subsystem

## Seventh Week:
## Eighth Week:
## Ninth Week:
## Tenth Week:

## Filler Material
For when the going gets tough and there isn't enough material to fill the tim
 - [ ] Cover GIT
  - If there's extra time, now is a good opportunity to cover GIT
  - [Software Roll Call](https://github.com/chopshop-166/SoftwareRollCall)
    1. Clone repository
    1. Create branch off of master
    1. Add name to YEAR.txt
    1. Commit change
    1. Push change
    1. Open PR
    1. Ask fellow student to review PR
    1. Ask mentor to merge PR

 - [ ] Enums
  - Creates a new variable type that has limited named values
  - Example Lift heights for elevator
  - Example State of arm (stowed, pickup, scoring)
 - [ ] Switch
  - Use instead of series of `if` when looking at single variable
 - [ ] Annotations
  - Used to add information about code inside the code
  - They can be extended with custom behavior
  - Explore the usage of the `RobotMapFor("MAC ADDRESS")` annotation in the robot map
 - [ ] [Collections](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Collections.html)
  - Provide a way of holding multiple objects with a standard API
  - Tie into for loop discussion (`Iterable`)
