# About the application #

scala-txtprocessor reads two input files, a list of users and followers and a list of tweets, parses them and outputs the tweets for each user. Users are listed alphabetically and tweets are in posted order. For example, given the following input files:

````
  users.txt
 ````
````
      Ward follows Alan

      Alan follows Martin

      Ward follows Martin, Alan

````
````
  tweet.txt
 ````
````
      Alan> If you have a procedure with 10 parameters, you probably missed some.
      Ward> There are only two hard things in Computer Science: cache invalidation, naming things and off-by-1 errors.
      Alan> Random numbers should not be generated with a method chosen at random.
````

Output to console as below
````
   Alan
       @Alan: If you have a procedure with 10 parameters, you probably missed some.
       @Alan: Random numbers should not be generated with a method chosen at random.

   Martin

   Ward

       @Alan: If you have a procedure with 10 parameters, you probably missed some.
       @Ward: There are only two hard things in Computer Science: cache invalidation, naming things and off-by-1 errors.
       @Alan: Random numbers should not be generated with a method chosen at random.​

````
### Technology used ###
````
Scala - primary language  
scalaTest - testing framework 
```` 
### Basic project structure ###
**scala-txtprocessor**
````
build.sbt - main build file  
src/main/resources - user.txt and tweet.txt input files  
src/main/scala - main source code  
src/test/resources - any test resources  
src/test/scala - test sources 
````

**Installation**
````
 The project can be imported into any IDE, eg IntelliJ provided a suitable JDK 1.8 and SBT 1.0 and above is installed
````

**Usage**
````
 To run application on command prompt with scala use 
 
    scala scala-txtprocessor_2.12-1.0.0-SNAPSHOT.jar /{DIRECTORY PATH}/user.txt /{DIRECTORY PATH}/tweet.txt
      

````
````
 To run application on command prompt with java use 
 
    java -jar scala-txtprocessor-assembly-1.0.0-SNAPSHOT.jar /{DIRECTORY PATH}/user.txt /{DIRECTORY PATH}/tweet.txt      
 
````
**Assumptions**
> * Only ascii characters can be used. Files are parsed line by line so a single entry cannot cross multiple lines. Linux style \n and Windows style \r\n or \r line endings are valid.
> * The tweets.txt file is parsed and each line is split at the first occurence of '>' and the space after on each line and assuming that all text before is a user's name and all text after is the tweet. Excess whitespace is stripped around both.
> * Fatal exceptions (e.g. invalid filenames) are reflected by an unhandled scala error. This is assumed to be informative enough to show the problem.
> * User and Tweet files supplied as program arguments must be supplied in the specified order as indicated under usage failure to do so will result in the display of invalid output to the console screen.
````

````
