# The Dice Game

A simple java CLI based game where n players queue in to roll a dice one by one. The die is 6 faced ie it can only yield values from 1 to 6. 

## Rules
Rules are simple
1. A  numerical target value is decided for the game.
2. Each player will roll a die
3 The face value is added to there score.
4. A player  will complete the game  if he clears the target value of the game and thus will not roll die again.
5. A player will get an extra roll if they draws a face value of 6
6. A player will have to forfeit his next turn if they draw 1 twice in a row.
7. The game concludes when all the players achieve the game target mark.
8. Players are ranked in accordance to their order of target acheievement, rest competing players are ranked by their totalScores.

## System set-up

Install Ecplipse IDE for Java from [official website](https://www.eclipse.org/downloads/) 

Download latest Java JDK from [official website](https://www.oracle.com/java/technologies/downloads/)

Download the zip or clone the repository to your desktop.
Open the project directory with Eclipse

## Running the application


 Browse over to DiceGame\src\
 Open Command Prompt/ Terminal

 `java -jar gameOfDice.jar`

 This should start the game in terminal itself.


 In case if the above command doesn't work please follow these alternate steps 

 `DiceGame\src >set path=%path%;C:\Program Files\Java\jdk-18\bin`
 set path for source directory


 For compiling the java source file using javac, you need to specify the files to compile explicitly

 `DiceGame\src> javac models/Player.java`
 
 `DiceGame\src> javac game/PlayGame.java`

 Now class files are compiled 
    run the following command to run the game
 `DiceGame\src>java game/PlayGame`


 ![Game Start](https://github.com/sahil-repos/DiceRoll/blob/main/screenshots/startGame.PNG)

 ![init](https://github.com/sahil-repos/DiceRoll/blob/main/screenshots/init.PNG)

 ![winner](https://github.com/sahil-repos/DiceRoll/blob/main/screenshots/winner.PNG)

![sixDouble](https://github.com/sahil-repos/DiceRoll/blob/main/screenshots/sixDouble.PNG)

 ![FinalScore](https://github.com/sahil-repos/DiceRoll/blob/main/screenshots/FinalScore.PNG)








## Live Demo

You can check the deployed repl [here](https://replit.com/@sahil-repl/Dice#PlayGame.java)
Visit this link and click on green play icon on top.



## Running the unit tests

open the project directory in the Eclipse
Go to src/testing/AllTests.java
Press the following shortcut to run all tests 
(For windows)
`ALT + SHIFT +X, T`

(For Mac)
`alt+cmd+XT`

![UT](https://github.com/sahil-repos/DiceRoll/blob/main/screenshots/UT.PNG)

You can run each test separately as well , select the test and run the same command.

![singleUT](https://github.com/sahil-repos/DiceRoll/blob/main/screenshots/singleUT.PNG)

## Folder Structure

-diceRoll :Repo

    -diceGame : Root Directory
    
        -bin : contains compiled files for the project
        
        -src : directory containing java packages that houses .java files
        
            -game : Package containing game class.
                -PlayGame.java : Class containing main method for entry point into our program
                
            -model :Package containing Player model class 
                -Player.java  : Player class 
                
            -testing : Package containing Unit test suite and test cases. 
                -AllTests.java : Unit Test Suite class
            






