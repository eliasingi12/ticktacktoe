# Development manual

## The Project

#### Source control
We used Github as the source control client. But you have to have [Git](http://git-scm.com), if you don't have it already. Then you can to [GitHub](https://github.com/Hubar/ticktacktoe) and download the project as .zip/.tar.gz, or you can **fork** and **clone** the project by copying the link and do: 

	$ git clone https://github.com/Hubar/ticktacktoe.git 
-
####  Build environment

##### Java 8
You need to have Java runtime enviroment on your computer. 

###### On Windows
Go to [Oracle](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) and follow the install instructions. 

###### On Unix/Linux 
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
- hvað þarf hann að run-a til að vá inná Travis

	Go to [Travis](https://travis-ci.org/Hubar/ticktacktoe) to see ??? (Continuous Integration)

##### Heroku
-ef við ætlum að hafa það

##### Code Coverage
- Hvað gerir hann til að skoða það? 

-
#### Compile and run

- hvert fer hann til að compile og run-a? (gradle run, eitthvað ??)?
- þarf hann ekki að vera búinn að ná í Java 8 (ef hann er ekki með það)?
- þarf hann að vera búinn að ná í gradle og git?

-
#### .Jar
- Þarf hann að búa til .jar file til að build-a kóðan í runnable .jar file?

-
