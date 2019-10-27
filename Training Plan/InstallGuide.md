Installation Guide
==================

Computer Setup
--------------

- Download and install [git](https://git-scm.com)
- Download and install [GitKraken](https://www.gitkraken.com)
- Download and install [WPIlib and VS Code](https://github.com/wpilibsuite/allwpilib/releases)
- Download and install [FRC Update Suite](http://www.ni.com/download/first-robotics-software-2015/5112/en/)

Starting a New Repository
-------------------------

- Download [the latest GradleRIO release](https://github.com/wpilibsuite/GradleRIO/releases), java edition.
- Extract into a folder
- Open the same folder in git bash (right click > Open in Git Bash)
- Run `git init .`
- Run `git add . && git commit -m 'Import of GradleRIO'`
- Add jitpack and chopshoplib to the Gradle build
- Run `git add . && git commit -m 'Import chopshoplib'`
- Push to GitHub

Downloading from GitHub via GitKraken
-------------------------------------

- Clone the `frc-YEAR` directory into a location of your choosing
- Open "FRC Visual Studio" for the appropriate year
- Use the "File" menu to open the given folder

Downloading from GitHub via Git Bash
------------------------------------

- Open git-bash
- `cd` into the directory you want to store the code in
- Run `git clone git@github.com:chopshop-166/frc-YEAR`
- Open "FRC Visual Studio" for the appropriate year
- Use the "File" menu to open the given folder

