# Design report

### About Tic Tac Toe

Tic Tac Toe are two players game, X and O, who takes turns making the spaces in a 3x3 grid. Player wins the game if he succeeds in placing three of their marks in a horizontal, vertical or diagonal row. 

-
#### Coding princeples
We coded the Tic Tac Toe game in Java using Test-driven development (TDD). We used branches for every feature, where we reviewed before accepting the pull-request. 

Eitthvað um code coverage
og það sem óskar var að gera...

-
#### Environment
The game was coded in Sublime Text and cmd/Terminal. To store and share the code, we used Github as our source control. We used Gradle to compile the code and to run the unit test. Then we used Travis for automated continues integration server. In the end we used the Advania Qstack to run the project on a clean computer. 

-
#### Code inspection/rules

**ConstantName**	Checks that constant names confirm to a format specified by the format property.

**Comments** ??

notuðum við tab fyrir indent

**Declaration** are one per line, it encourages commenting 
	
	int temp;
	int _temp;


**Curly braces (block)** opens at the end of the same line as the declaration statemens and closes in a new line (see below):

	void Method() {
		int n = 1;
		
		if (condition) {
			...
		} else {
			...
		}
	}

	for (int i = 0; i < SIZE; i++) {
		...
	}

**Eitthvað fleira?**
-
