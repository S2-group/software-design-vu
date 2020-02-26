# Assignment 1

## Introduction
Author(s): Beth, Sarah, Ben, Sam, Gemma

Our team will be designing and implementing a generic text adventure game which will be customized to create specific instances by modifying locations, items, objectives, actions, and more. We will use this abstract game to create Amsterdam, a navigation game in which players have to find coffee for energy boosters, use bikes or the metro to get around, move through locations like Albert Heijn and Rembrandtplein, and more to reach a secret final location and win the game.
The overall goal will be for the player to reach a specific location within the game within a certain time limit, thus accomplishing his objective and winning the game. To reach this final location, the player will need to move through obstacles using commands, as well as interact with items. In order to accomplish this, our generic game will have basic classes for Player, Action, Objective, Setting with subclasses for Locations, CommandParser, Item, TimeLimit, and Obstacle.
For the Player class, we want to include generic information such as the user’s name, as well as functionality which creates a user and specifies actions and commands the user can utilize.
The Action class will allow the player to interact with the CommandParser class so that when the user inputs a valid command, they can see the consequences in the terminal. An example of this would be entering a new room (the action) using the keyword “enter”, and then seeing their new location and what items are now available to them.
The Objective class will contain information about the end goal of the game, i.e. where the user wants to end up and in what amount of time.
The Setting class will include generic information about what items, obstacles, etc. are in the game, as well as locations and directions from place to place. The location subclasses will hold the information for each specific room or location.
The CommandParser class will handle the user’s commands, and determine whether an input is valid or not, given the item they are trying to use a command on. It will deal with any error handling that may be necessary.
The Item class will contain all of the relevant information for different items throughout the game, such as bikes, coffee, doors, etc. Each item will have a set of commands (from the Action class) that the user will be allowed to use on it.
The TimeLimit class will keep track of how much time a user has left in the game, since the goal of our game will be to reach a certain location in a given period of time.
The Obstacle class will contain information about certain obstacles the user will have to overcome to progress, and what actions they can use to get past it.
Using these abstract classes and subclasses, we will import specific information to create a real game using JSON and a JSON parsing library, Fastjson. Players need to accomplish their objective within a certain time limit using commands, items, and locations specified in a JSON file, which will be used to modify the abstract classes. We want to make it easy to use these abstract classes to make your own game, which will involve designing clear ways to input JSON files into a Main class.  We will also include a help command to specify what actions and items can be used at a certain time to prevent confusion or getting lost.
Other features we will implement if time permits are multiplayer and persistence. For multiplayer, we will take the game one step further by implementing a Java chat room using ServerSocket. Because text adventure games are basically semi-automated chat rooms between a player and the prewritten consequences of various actions and items in the game, we believe we can add other users to this “chat room” to create multiplayer functionality which will depend on the overall objective of the game. The persistence feature will be significantly easier. In order to accomplish this, we will include a specification of where the player currently is and which items they are holding in the JSON file that was initially inputted into the generic game. When the player closes the terminal, this information will save to this file, so if the same file is again inputted when the terminal is later opened, they can pick up where they left off.


## Features
Author(s): Beth, Sarah, Ben, Sam, Gemma

### Functional features

In order to make the game as generic as possible, we want to include Functional Features that will be used in the game such as Commands, Movements, etc. that the player will be able to use during the game. 

| ID  | Short name  | Description  |
|---|---|---|
| F1  | Command | Player can control the main character using command line commands with the following syntax: ‘[command] [item]’. The commands we will implement are: move, open, break, inspect, help   |
| F2  | Movements  | Player can move through the environment using command: ‘move to [location]’  |
| F3  | Help Messages  | After a certain amount of time, user will be given hints of what actions to perform or movements to make  |
| F4  | Items | User can use commands on items (e.g. bikes or metro in Amsterdam, coffee, doors) in order to progress. Some items will be used to perform actions and some will be used as an energy booster to get through the game.  |
| F5  | Chat Room  | Game will be two player by using websocket network communication between computers. Users can chat with each other in order to help each other and ask questions to reach the goal.   |
| F6  | Saving State  | User will be able to save their current state (location, item
s, energy, etc) in order to continue playing at any time.   |

### Quality requirements
Author(s): Beth, Sarah, Ben, Sam, Gemma

We want other people to be able to use our code base to make other games and we want players to not run into any problems while playing the game, so we chose Quality attributes that ensure the reliability, maintainability, etc. of our code.

| ID  | Short name  | Quality attribute | Description  |
|---|---|---|---|
| QR1  | Commands sanity checks | Reliability  | Any command given by the player will be verified against the list of commands specified in F1 |
| QR2  | Adaptable to new Content | Maintainability  | The video game shall be adaptable to different settings, stories, characters, etc. by writing new JSON files  |
| QR3  | Clear and easily understood design and code | Maintainability  | The game code shall be easily understood and changed for the sake of the authors or anyone writing new JSON files |
| QR4  | Fast updates to game state | Responsiveness | After a command is given by the player, the terminal shall print the new state of the game (i.e. the room, its contents etc) within 1 second |
| QR5  | Execution of commands | Usability  | When a player gives a command in the correct format, the command will be executed correctly |
| QR6  | Easy access to the game | Availability  | The game shall consist of easily downloaded content (including the chosen JSON) which shall run correctly in each instance of play |

### Java libraries
Author(s): Beth, Sarah, Ben, Sam, Gemma

| Name (with link) | Description  |
|---|---|
| [Hibernate](https://hibernate.org/)  | Java framework to store persistent data |
| [fastjson](https://github.com/alibaba/fastjson) | Used for reading and writing JSON configuration files that will have descriptions of each location of the game |
| [Java.net.Socket](https://docs.oracle.com/javase/7/docs/api/java/net/Socket.html), [Java.net.ServerSocket](https://docs.oracle.com/javase/8/docs/api/java/net/ServerSocket.html)  | Packages to facilitate websocket network communication between computers |