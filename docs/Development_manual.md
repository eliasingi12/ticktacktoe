# Development manual

## The Project

#### Source control
We used Github as the source control client. But you have to have [Git](http://git-scm.com), if you don't have it already. Then you can to [GitHub](https://github.com/Hubar/ticktacktoe) and download the project as .zip/.tar.gz, or you can **fork** and **clone** the project by copying the link and do: 

	$ git clone https://github.com/Hubar/ticktacktoe.git 
-
####  Build environment

##### Java JDK
You need to have Java runtime enviroment on your computer. 

###### On Windows
Go to [Oracle](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) and follow the install instructions. 

###### On Mac/Linux 
Go to [Homebrew](http://brew.sh) and copy the Url and run in the Terminal. Do the following in the Terminal:

 - brew tap caskroom/cask
 - brew install brew-cask
 - brew cask install java

##### Gradle

###### On Windows
Download, unzip and setup Gradle [Instructions]( https://docs.gradle.org/current/userguide/installation.html "Follow these instructions"). 
   
- Remember to:
    - Add GRADLE_HOME/bin to your PATH environment variable
    - Add a valid JDK to the environment variable JAVA_HOME.

###### On Mac/Linux 
Go to [Homebrew](http://brew.sh) and copy the Url and run in the Terminal. Do the following in the Terminal:

- brew install gradle

##### Travis
If you are not signed in on Travis, you have to go to [Travis] (https://travis-ci.org) and sign in with GitHub and sync your repositories and find our - Hubar/ticktacktoe.

	Go to [Travis](https://travis-ci.org/Hubar/ticktacktoe) to see our continuous integration. 

-
#### Compile and run
Open cmd/terminal and navigate the folder location. Write the following, to run the game:

	./bin/deploy

If you don't want to build the project and run all unit tests in one, you can run tests ```gradle test``` and if you want to build, ```gradle build```

-
