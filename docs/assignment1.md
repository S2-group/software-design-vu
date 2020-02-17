# Assignment 1

## Introduction									
Author(s): Eduardo Lira

Inspiration: [Original Zork game](https://textadventures.co.uk/games/play/5zyoqrsugeopel3ffhz_vq)

For our software project, we have decided to recreate the game Zork. Zork is one of the first Command Line Interface (CLI), role playing games (RPG). In Zork, a user assumes the role of a protagonist stuck in a post-apocalyptic world. To win the game, the protagonist must find all 20 treasures, and place them in the trophy case. Our recreation of Zork will remodel the game play with: a new setting, a new goal, new commands etcetera. 

After a plethora of discourse with the team, we have decided that our game, titled: **VUORK: Saving Thilo from the Chamber of Secrets**, will take place at the Vrije Universiteit Amsterdam. The user assumes the role of a newly enrolled student (user may choose the name) on his way to a 9AM lecture of Computer Programming. Albeit new, when the user arrives at the main campus of the VU, he notices something is wrong… This is where the game begins. 

After a brief introduction into the game, the user will discover he is alone at the VU, and his lecturer, Thilo, is lost in the Chamber of Secrets. He will then have to gather the puzzle pieces, each with a clue indicating where the next piece of the puzzle is, to find the chamber of secrets; where Thilo is held captive. 

To interact with the VUORK world, the user will use text commands in the CLI to give instructions. The instruction will be in the form “<action> <items…*>”. We will create a parser which will transform that instruction into something our system can understand: If the user types in a command, describing what he is doing/what he wants to do, he/she will get a response from the computer what she/he is now able to see, what has changed or if the move is not valid. Furthermore, instead of having a boring CLI as the realm, we want to add a few Graphical elements into the game. Examples include the players inventory, the current areas explored etc...

With the game briefly explained, we must now consider how to develop this idea in a way that is easily extendable, maintainable and comprehensible. By using the Object-Oriented programming paradigm, we aim to create a system that is easily modifiable, expandable and intuitive for programmers to understand. To help achieve this goal, we will be making use of UML diagrams. 

   				   Figure 1: A use case diagram of VUORK

![VuORK use case diagram](https://lh3.googleusercontent.com/ePg0EoRTAvMiKXEP_VNm-gGz7HN0pBql_kOfZ-RUjralgX5VEYfBDSGg7DdKa8HeYwpv4C79SSpxdnjOcfLk6GLn7E-IDENFk6257sC3hyDslfFupreykPBXSfHrvP1NY3T5XnxJ)

The remainder of this paper will cover detailed features and quality requirements to help us structure this project (This should be self explanatory). 

## Features
Author(s): Marta Jansone, Theresa Schantz

### Functional features

As a preamble to the table, you can discuss the main line of reasoning you applied for defining the functional features provided in the table.

| ID   | Short name |                         Description                          |
| ---- | ---------- | :----------------------------------------------------------: |
| F1   | Commands   | The player can move the character using the following commands: *"move, take, put, drop, look, attack"*. The structure of this command will be <action> <items or objects>. This will help easily parse the input and help keep the commands easily comprehensible for the user. The command may include such articles as “the”, “a” or “an” and such prepositions as, for example, “in“ or “at”. |
|      |            |                                                              |
| F2   | Movements  | The player can move around in the game environment and get from one room to another by using the following commands: *"go/move followed by north, south, west, east, down, up, left and right"* |
|      |            |                                                              |
| F3   | Narrator   | Computer responding to user; describing what is happening, what the user is able to see |
|      |            |                                                              |
| F4   | Game-info  | The player can get the statistics of the game by entering the following commands… info, quit, inventory, time, diagnose |
| F5   | Map        |    A list that keeps track of the places already visited     |
| F6   | Backpack   | A list that keeps track of the items that have been picked up already |
| F7   | Score      | An integer that shows the number of already obtained points; It will be updated after every action |
| F8   | Moves      | An integer that shows the number of moves. Always updated after an action |
| F9   | Timer      | A clock that shows the time that has already been passed since the start of the game |
| F10  | Rooms      | There is a specific number of rooms that the player can enter, each resembling a room at the VU. |
|      |            |                                                              |

### Quality requirements

Author(s): Irene Garcia-Fortea Garcia, Florent Brunet de Rochebrune 

As a preamble to the table, you can discuss the main line of reasoning you followed for coming up with the quality requirements listed below.

| ID  | Short name  | Quality attribute | Description  |
|---|---|---|---|
| QR1  | Check for valid moves and valid input | Correctness | Check if the move the user wants to do is possible at that time of the game and check whether the input was given in the correct syntax. If the command does not meet the requirement: an error message must be printed and/or the user must be asked to give a new input. |
| QR2  | Quick     responses to user input     | Responsiveness | The system should give a fast response (and always give a response) to the user so that the game flow will not be interrupted. If the user obtained a point, the score should be updated within 1 second. |
| QR3  | Extensible world | Maintainability | The code should be well structured and organized; and the universe should not be closed. It should be an open story plot so more levels can be added later. Readable code will make it easier to implement such. |
| QR4  | User friendly | Usability | An introduction must explain how to play the game and how to give commands. A well organized structure will make it easier for the player to keep an overview of the game. |
| QR5 | Always respond to user inputs | Reliability | Whether the user input was a valid command or not, the system must always return a response, so the user knows what next step to take. |
| QR6 | Available actions | Availability | When an action is possible, it must be able to be executed when requested by the user |
|  |  |  |  |
| QR7 | User privacy & System security | Security | Not collecting any personal userdata. GDPR compliant. Software does not cause any harm to user’s machine. |
|  |  |  |  |

### Java libraries
Author(s): Marta Anna Jansone, Irene Garcia-Fortea Garcia

| Name (with link) | Description  |
|---|:-:|
| [JFoenix](http://www.jfoenix.com/)  | Graphical interface. Used for styling and creating the user interface window. We are choosing it as it supports material design and is easy to customize. It includes such features as input fields, buttons and text fields, all of which are required in our game implementation. |
| [StringUtils](https://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/StringUtils.html) | Comparing strings. We will use this library to process user input and compare the input commands to the allowed commands stored in our game database (JSON). We choose to use this library as the strings can easily be compared using the ”==” sign. ... |
| [fastjson ](https://github.com/alibaba/fastjson) | We will use it for reading JSON files that will contain the room descriptions in the game and the allowed commands, which the player can make. We chose this library as it provides functions to parse JSON objects to string for further string comparisons. The library also provides good documentation on GitHub. |
| [Scanner](https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html) | We will use this library for acquiring user input. User input is required for the player to make moves and pick up objects when traversing the game. |
| [JUnit ](https://junit.org/junit5/) | This library will be used to perform testing on our game. We choose this library as it is possible to easily set-up unit tests to test the performance of small parts of the game, for example, acquiring and comparing user input. |
