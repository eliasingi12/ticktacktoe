# Design report


#### Environment

-The game was coded in Sublime Text and cmd/Terminal. To store and share the code, we used Github as our source control. We used Gradle to compile the code and to run the unit test. Then we used Travis for automated continues integration server. In the end we used the Advania Qstack to run the project on a clean computer. 


#### Coding principles

-We coded the Tic Tac Toe game in Java using Test-driven development (TDD). We used branches for every feature, where we reviewed change before accepting the pull-request. 


#### Code coverage

-We are using Jacoco plugin which provides code coverage metrics for Java code via integration with JaCoCo.


#### Code inspection

-We are using some of the Maven-checkstyle-plugin to go over the code to check if it follows the Sun coding conventions.


#### Coding rules:

**Use functions with descriptive names**

**Use tab indents**

**Declarations** are one per line, it encourages commenting:	 
	
	int temp1;
	int _temp2;


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


**Use camelCasing** see example below:

	public boolean checkIfWinning(){
	        if(checkDiagonal()){
	            return true;
	        }

**Constants declared in capital letters** see example below:

	public static final int SIZE = 3;
