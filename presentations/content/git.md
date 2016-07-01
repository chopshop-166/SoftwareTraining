% Git for FIRST teams
% Matt Soucy (<msoucy@csh.rit.edu>)

# The Importance Of Version Control

- Most developers start off not using any
- Tolerable for small projects on one's own
- What happens when you make a mistake?
	- Delete a file
	- Accidentally break compatability with other code
	- Remove comments explaining what something does
	- Introduce a bug amongst your features

---

# Old Ways Of Tracking Changes

- Undo/Redo
	- This is silly, but usable, for fixing small mistakes that you make
	- Only works within one work session
	- Close a file, and your change history vanishes
- Zip files/separate folders
	- When you're done making changes, or have a version you like, copy the folder
	- Store in `.zip` "to save space"...
	- This does NOT SCALE WELL. At all. Seriously, it's awful.
	- Our team did this until 2008

---

# Older Version Control Systems We Used

- Subversion
	- Centralizes the code
	- One person at a time can "reserve" a file (`checkout`)
	- Only the person who has a file checked out can `checkin`
	- All users can `svn update` to get the changes from the central server
	- Named branches to have alternate build choices
	- We did this in 2008 (on Google Code)
- Mercurial
	- What if the team can't access the server?
		- This happens ALL THE TIME at competitions
	- Multiple people can make changes at once
	- Only one `head` can be on the server per branch
		- Users merge them together
	- Named branches actually usable
	- We used 2009 - 2014 (on Google Code)

---

# Git

- More powerful and widely used than Mercurial
- Doesn't restrict you to using one development pattern
	- But the mentors will
- Branches aren't just common, but *essential*
- We have used Git since 2015 (on [GitHub][])

---

# Using git

- Most commonly, people use the command line for this
	- In the past, we tried using the GitHub GUI, but it seemed to get in the way
- We don't have time to fully teach command line git properly
	- We'll briefly cover the important commands
- If you're feeling daring, ask a mentor later
<!--	- According to Mark, you must call me "Oh Captain My Captain" if you exercise this option-->

---

# Branches

- A branch is just a name for a group of changesets
- All repositories have a branch called `master`
	- This branch is similar to the `default` branch from `hg`
- Depending on your workflow, there may be more
	- They let you jump back and forth, marking points in time

---

# Forks & Pull Requests

- A copy of the repository with some changes
- Owned by someone else
- For the team, each person will maintain their own fork
	- This means that you're responsible for keeping your fork up to date
- The repository you fork from is called "`upstream`"
	- Because changes can "flow" down
	- By nature, this means that you're a "`downstream`"
- When you want to add your changes to `upstream`, you do it via "pull request"
	- Literally means "I would like you to take my changes"

---

# The Team's Workflow

- Use the Git Shell for most actions
	- The GitHub GUI can be useful for viewing the change tree
- The [ChopShop repository][] is the "canonical" repository
	- `master` branch: *Working* code that builds
	- `release` branch: *Stable* code that we trust on the robot
- Your fork contains your work
	- Develop your code in your own copy
	- You're responsible for keeping it up to date
	- You can commit and push whenever it feels appropriate
- When your code is ready to be merged in with the team's code:
	1. Go to your fork on GitHub
	2. Click the big green button
	3. **MAKE SURE THAT THE CHANGES BUILD AND LOOK CORRECT**
	4. Submit the pull request

---

# The Useful Commands

`git clone https://github.com/chopshop-166/frc-2017`
: Make a local copy of the `chopshop-166/frc-2017` repository

`git add filename filename ...`
: Mark changes as ready for commit

`git commit`
: Take all changes you've marked as ready (`staged`) and turn them into a commit

`git pull upstream master`
: Pull commits from the [ChopShop repository][], into your local repository

`git push`
: Push local commits to your fork (or another repository you have access to)

---

# The Useful Commands

`git checkout branchname`
: Start looking at another branch

`git branch newbranchname`
: Create a branch named `newbranchname` at the current commit

`git status`
: Show the status of the repository (changed/staged files)

`git log`
: Show the history of the commit you're on

`git reset HEAD filename`
: Unstage changes

*There are many other useful commands, if there's one you use often then ask about aliases*

---

# Pull Request Image

![The GitHub web interface, showing the Pull Request button](pull-request.png)

---


# Conclusion

- Version control is very good for keeping code organized
- Git lets people work in their own branches
- The workflow gives us control over what code is considered "stable"
<!--- Version control is as easy as *fork*, *spoon*, and *knife*-->

---

# Further Reading

Not all of these are required reading, but at least know where more information can be found

- [Git Tutorial](http://git-scm.com/docs/gittutorial)
- [Git Book](https://git-scm.com/book/en/v2)
- [Atlassian Tutorials](https://www.atlassian.com/git/tutorials/)
- [Ryan Brown's presentation](http://rsb.io/talks/git/)
- [git ready](http://gitready.com)
- [gitref](http://gitref.org)
- [Pro Git](http://progit.org)
- [Git Cheat Sheet](http://cheat.errtheblog.com/s/git)
<!-- - [BitBucket tutorial](https://bitbucket.org/spooning/) -->

# Practice and Training Exercises

- [Try Git](http://try.github.io)
- [Git Immersion](http://gitimmersion.com/)
- [GitHug](https://github.com/Gazler/githug) (Requires a lot of setup)
- [git-game](https://github.com/git-game/git-game) (More of a test of your knowledge than a tutorial)

---

# Questions?

[GitHub]: http://github.com/
[ChopShop repository]: http://github.com/ChopShop-166/frc-2016
