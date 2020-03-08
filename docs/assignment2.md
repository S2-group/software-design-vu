# Assignment 2

## Implemented Feature

|ID|Short Name|Description|
|-|-|-|
|F2|Input Box|The text input box which will be the place for the user to interact with the game.|
|F3|Commands|Commands will be the user’s way of interacting with the game environment.|
|F4|Text Display Box|The text display box will display information about locations, characters and dialog.|

### Used Modeling Tool

StarUML

## Class Diagram

Author: `Donal Shortt`

GREEN = Public Class
RED = Private Class
YELLOW = Library Class

![Class_Diagram_4](https://i.imgur.com/WmlXEhS.jpg](https://i.imgur.com/WmlXEhS.jpg)

### Main

- Represents the entry point of the program and runs the game loop

#### Attributes
* None
#### Operations

* **main**
-- The entry point of the program. Initialises the perquisite objects and runs the game loop.

#### Associations

* **UserInterface**
-- UserInterface is the class that represents the front end of the game. Main needs to interact with this in order to display information to the player and to take information from the player to give to GameState.
* **GameState**
-- GameState is the class that represents the back end of the game. Main needs to interact with this in order to to play the game and pass information about the state of the game to the UserInterface.
* **Loader**
-- Loader fulfills the role of a utility class. It loads information from JSON files to send to both the UserInterface and the Gamestate

### UserInterface

- Represents the front end of the game. Displays information to the user through text and text based images via the text display and image display boxes. Takes information from the user via the input box. 

#### Attributes

* **terminal**
-- Terminal is a class provided by the lanterna library.  It is at the bottom of the stack that lanterna provides to display information on the terminal. Our project does not interact with the Terminal class directly, rather it uses Screen. However to utilise Screen, it must be initialised on top of the Terminal class.
* **screen**
-- Screen is a class provided by the lanterna library. It is a step above terminal in the stack provided by lanterna and it is this class that our project uses to provide information to the player. Information is displayed to the player by writing to the screen's back buffer and then flushing these changes to the front buffer.
* **tg**
-- TextGraphics is a class provided by the lanterna library. It is a utility class that provides several functions to assist with drawing graphics to the screen's back buffer. In particular. we use this class to draw the boxes of the input and display boxes. 
	It also makes it much easier to display strings on the screen. With it we can push entire strings onto the screen, without we would need to write to the screen character by character.
player: Player
#### Operations

* **UserInterface**
-- Constructor method
* **initGame**
-- Initialises the game by displaying the game name and then prompting the player for their character's name.
* **displayGame**
-- Displays the actual game UI in it's default configuration. Displays the display boxes and input box in an empty state.
* **getInstance**
-- Returns a reference to the singleton UserInterface object.
* **displayImage**
-- Takes in a list of strings and then displays each string on a new line within the image display box.player: Player
* **displayText**
-- This is an overloaded method. Can take in either a single string to display in the text display box, or it can take in a list of strings to display on the text display box. Each string will be display on a new line.
* **takeInput**
-- Used to take input from the input box and pass the result as a string to the calling method or function. This function basically just wraps the readUserInput function and supplies it with the correct coordinates to take input from the input box. This is a blocking method, meaning that execution will pause until input is taken.
* **centreText**
-- This is a utility function used to centre a string horizontally within the screen. It is used for centering the text that is displayed when the game is being initialised.
* **readUserInput**
-- This is a utility function which reads userInput at the TerminalPosition supplied in the arguments. This is a blocking method.
* **stringSplit**
-- This function takes a string that is too long to fit in the text display box and attempts to split it into a List of smaller strings.

#### Associations

* **Main**
-- Already described
* **GameState**
-- GameState is the class that represents the current state of the game. GameState needs to access the UserInterface class in order to display certain information about the state of the game to the player.
* **Player**
-- Player is the class that represents the player. Player needs to access userInterface hen it wants to display the results of some action the player has taken.
* **DisplayError**
-- DisplayError is an error handling class that extends the Java Exception class. It is used to handle errors thrown by UserInterface when the text trying to be displayed won't fit within the boxes provided.

### Loader

- Loader is a utility class used by main to load data from the game's JSON files into the game state.

#### Attributes
* None

#### Operations

* **parseLocationObject**
-- Parses the JSON object from the JSON file and returns a Location object.
* **parseLocationByName**
-- Searches the JSON file for the location with the specified name and returns it. Basically just wraps the parseLocationObject().
* **parseImageObject**
-- Parses the JSON object from the JSON file and returns a list of strings which represents a text-based image.

#### Associations

* **Main**
-- Already described

### GameState

- Represents the current state of the game, or in other words, the game's current configuration

#### Attributes
* **player** 
-- Holds a reference to the instance of the Player class.
* **location**
-- Holds a reference to the instance of the current location.
* **locationList**
-- Holds a reference to the list of locations that have been loaded in by the Loader class.
* **isFinished**
-- A boolean value that evaluates to true when the winning conditions for the game have been met.
* **numRedo**
-- Holds the number of times a player can go a step back or "rewind" the game

#### Operations
* **updateGameState**
-- This method is called every time the player interacts with the game in such a so that a game state change is required. An example would be when the player decides to change location.
* **GameState**
-- Constructor method
* **printHelpMessage**
-- Displays a list of commands available to the player via the text display box on the userInterface
* **getLocation**
-- Gets the current location in use by the game
* **getLocationList**
-- Gets the current list of locations that have been loaded in by the loader class
* **getPlayer**
-- Gets the player instance in use by the gameState instance
* **getIsFinished**
-- Returns a Boolean value as to whether or not the winning conditions for the game have been met
* **setFinished**
-- Sets the finished state depending on whether the game winning conditions have been met.
* **setLocation**
-- Sets the current location to the new location supplied in the arguments

#### Associations
* **Main**
-- Already described
* **UserInterface**
-- Already Described
* **simple.JSONArray**
-- JSONArray is a way to store a number of JSON objects within an array-like data structure. Gamestate uses it to store the list of loaded Locations.
* **Player**
-- Player is the class that represents The class is a singleton.the player in the game. Gamestate needs to access Player in order to know how it should update it's own state.
* **Location**
-- Location is the class that represents the Location that the player is in. GameState needs to access it in order to get certain information when a gameStateUpdate is required. Such information could be the neighboring Locations or the NPCs located in that Location

### Player

- The player class represents the player within the game. It contains all the methods used when the player interacts with the game in any way, with the exception of printHelpMessage().

#### Attributes
* **name**
-- The name of the player's character.
* **inventory**
-- A list of strings representing the inventory of the player, each string representing an item.
* **ui**
-- Holds a reference to the UserInterface instance so that the Player class can display information to the Player.

#### Operations
* **Player**
-- Constructor method.
* **hasItem**
-- Returns a boolean value as to whether the Player has a certain item in their inventory or not.
* **move**
-- Moves the player to a new location via a GameState update.
* **talk**
-- Initiates a conversation with an NPC.
* **say**
-- Answers an NPC's riddle.
* **printInv**
-- Prints a list of items in the player's inventory via the UserInterface.
* **getInventory**
-- Returns a list of Strings representing the player's inventory.
* **getPlayerName**
-- Returns the player's name.

#### Associations
* **GameState**
-- Already described
* **UserInterface**
-- The Player class needs to interact with the UserInterface class when it needs to convey information the the player. Such as printing the player's inventory or looking at NPCs.

### Location

- The Location class represents the current Location that the player is inhabiting. It contains the NPCs found in that particular location, along with the items that can be obtained from the location.

#### Attributes
* **npc**
-- A reference to the NPC private nested class.
* **items**
-- A list of items contained in the location.
* **neighbours**
-- An array of strings of neighboring locations to the current location.
* **description**
-- A string describing the location.
* **items**
* An array of strings of items contained within the location.

#### Operations
* **Location**
-- Constructor method
* **NPC**
-- Private nested NPC class. Used by the Location class to represent NPCs within locations.
* **getName**
-- Gets the name of the location.
* **getRiddle**
-- Gets the riddle of the NPC within that location. 
* **getDescription**
-- Gets the description of that location.
* **getNPC**
-- Returns the name of the NPC
* **getNpcAbout**
* -- Returns a description of the NPC
* **getReturnDialog**
* -- Returns the dialog the player sees when they talk to an NPC 
* **getAnswer**
	-- Returns the answer to the riddle
* **getItem**
	-- Returns the item the NPC has.
* **getItems**
	-- Returns the list of items available in that location.
* **getNeighbours**
	-- Returns the neighboring locations to the current location.

#### Associations
* **GameState**
-- Already described.
* **NPC**
-- Location uses the private nested class of NPC to represent the information about the npc located in that location.

### NPC
-- NPC is a nested class located within the Location class. It does not provide any other functionality other than to group the data about the NPC together.

#### Attributes
* **name**
-- The name of the NPC.
* **about**
-- A description of the NPC.
* **item**
-- The item the NPC will give the player after the player has solved their riddle.
* **riddle**
-- The riddle the NPC offers to the player
* **answer**
-- The answer to the riddle offered by the NPC
* **returnDialog**
-- The dialog the NPC displays when the player talks to the NPC

#### Operations
* **NPC**
-- Constructor method.

#### Associations
* **Location**
-- Already described.

### DisplayError
-- Display error is a custom exception class created to handle exceptions thrown by the UserInterface class. The exception is thrown if the text to be displayed in either the text display box or image display box does not fit within the box.

#### Attributes
-- None.

#### Operations
* **DisplayError**
-- Constructor Method.

#### Associations 
* **UserInterface**
-- Already described.

### External Classes

#### simple.JSONArray
-- This class is used to hold an array of JSON objects. We use JSON files to represent all the data associated with the game.
#### lanterna.terminal.Terminal
-- Terminal is a class used by the userInterface to display game output to the user.
#### lanterna.screen.Screen 
-- Screen is an extension of Terminal and i used to display output to the user in more advanced formats.
#### lanterna.graphics.TextGraphics
-- TextGraphics is a library that allows us to display simple text-based graphics to the user.

### Previous Class Diagrams

#### Version 1
![Class_Diagram_1](https://imgs.su/upload/271/3179159392.jpg)

The first version of the class diagram was made just to get a sense of what the system would look like. The UML syntax is not correct in this version as the purpose was to establish a rough draft of the system.

#### Version 2
![Class_Diagram_2](https://imgs.su/upload/271/2758094369.jpg)

In the second version GameState was split up into game and state. We did this because we thought it would make sense to have the game logic handled in one class and the state of the game stored in another. The UserInterface class does still not exist in this diagram as we were still unsure on how to use Lanterna.

#### Version 3
![Class_Diagram_3](https://imgs.su/upload/271/603796206.jpg)

The third version is the closest to the current version of the class diagram. Game and State had been put back into the same class and UserInterface had been modeled. The external libraries are still missing from this version however. LocationLoader, which will become Loader has also been moved to exist within the main class as it will be needed to set up the game, which is the responsibility of Main.

# Object Diagrams

Author(s): *Nariman Gasimov*
![object diagram](https://imgs.su/upload/271/2805021462.png)
The figure shows the 5 main objects during the execution of the game. When a player enters a command *“go Restaurant”* the **InputParser** object divides that input into command(go) and argument(Restaurant) parts. Then the **GameState** object using the switch statements picks up the corresponding method to call from the **Player** object. In this case the *Player.move()* method is called with the user argument and if the checks go well the gamestate object is updated with the new Location that is set according to the user’s argument. In this case, the user asked to go to the Restaurant and therefore the respective piece of data from the list of locations is loaded into the **Location** object. Setting the name to Restaurant, adding the description, adding the possible items that can be acquired in that particular location, as well as the neighbors that are surrounding the given location. This by itself also sets the **NPC** object inside the Location object to the respective object given in the JSON file. All the information about the npc, such as the *name, about, the item that it holds, the dialogues and the answers expected* are loaded into that object.

# State Machine Diagrams
Author(s): *Daniel McHugh*
## Main behaviour

![state machine diagram](https://i.imgur.com/CkHXR6x.png)Above is a simple state machine diagram of the stages which the Main class of our system shall perform. A more developed look at the main loop of the game is described in the GameState behaviour.

The initial first three states of Main deal with setting up everything before actually running the game. Firstly, the initialisation of classes for the user interface, json parsing and location loading is required as these systems are used outside of the actual GameState. Secondly, using the tools initialised, Main will retrieve the information about the game (such as the map) stored within the json files along with other information (such as the player’s name) through the user interface. Lastly, the game is finally initialised using this information.

In the state in which the game runs, Main will remain within a loop of receiving information by the user, passing it to GameState and updating GameState. This should carry on until the player chooses to quit the game or has reached the winning condition. At this point, the GameState object shall be saved and Main reaches its finished state.

## GameState behaviour
![state machine diagram](https://i.imgur.com/34vOm4p.png)
The GameState class is initialised when the game is started, requiring information about the players name, the starting location of the player and a map of the whole game. Currently, this is done by receiving the player’s name from the user and loading the rest by parsing the given json file. However, for later instalments of our system, we wish to add the option to save and load the current GameState to be able to play the same instance of a game in multiple sittings.

After initialisation is done, the game enters into its main game loop. The GameState object is initially (and for the majority of its lifespan) in a “not finished” state. This will eventually change to a “finished” state based on the actions taken by the player. If the object does reach the finished state, it should take steps into saving the current gamestate (for future feature mentioned above) before exiting the game.

In its unfinished state, the object will wait for a command/argument given by the user and transition with updateGameState. The next pseudo-state is based on what the command from the user is set as, with the currently available commands being: GO/MOVE, LOOK, TALK, SAY/ANSWER, ERROR, HELP and QUIT. Each of these commands will either update the game state in some way or convey information to the user:

-   Update Game Location: updates the location object in the game state based on players movement
    
-   Get Npc Description: retrieves the description of the npc found in the states current location (only when given correct argument)
    
-   Get Npc Riddle: retrieves the riddle from the npc found in the states current location (only when given correct argument)
    
-   Get Npc Item: retrieves an item from the npc found in the states current location (only when given correct argument)
    
-   Input Error: output to the user that the command just passed was not recognised
    
-   Help: output to the user a list of recognised commands and format
    
-   Quit: update the game state to finished
    

The GO/MOVE and SAY/ANSWER commands will also perform the same tasks. This is to be less restrictive on users input and to accommodate players with different intuitions on how to communicate with the game. The current game state is then replaced with the new updates game state and the loop is repeated.

## InputParser behaviour

![state machine diagram](https://i.imgur.com/9SH67k6.png)The input parser class is initiated when user input is received from the UserInterface object. For our design of the system, user input is split into two parts: commands and arguments. It is therefore useful to create a class which can store the required information and return an instance of that class. Furthermore, parsing user input and correcting it to a set format would result in a more robust system for comparing values given by the user with the stored json files. Further parsing shall be present in the next iteration of our system.

This initialisation shall occur within the updateGameState argument and be used immediately for updating the GameState. After its initial state, the InputParser object input is tokenized into a command and argument. The Parse Command state shall then parse the command and set to a given predefined enum value of: GO, MOVE, LOOK, TALK, SAY, ANSWER, HELP, QUIT or ERROR. This will be done with a try/catch statement which assigns the command to ERROR if it is not recognised.

Finally, the object enters the Parse Argument state if the length of input tokenised is not one. This is because if the length matches one, no argument must have been given which is expected for commands such as QUIT and HELP. Moreover, if the length is less than one, then no command was given and therefore assigned as ERROR. After, the parsed input object is ready to be returned.

﻿
## Sequence diagram

Author: `Sofia Šišić`

![Sequence Diagram 1](https://imgs.su/upload/271/1941739226.jpg)

In our game, the player obtains items at different locations through talking to an NPC at that location. When the action of talking takes place, a riddle is presented to the player. Then, for the player to successfully obtain an item, they should give input in the form: say + argument. The first sequence diagram represents what happens when the player uses the command SAY.  The argument, in this case, is the answer to the riddle. State within the GameState contains the correct answer and the argument(answer) is compared with what it is supposed to be. Then come the two nested if statements. If the condition of equality is satisfied, the next if statement is considered. The first situation is if the player already has that particular item that is supposed to be given to him in their inventory. In that case, the message is outputted saying “You already have ” + item + “ in your inventory”. On the other hand, if the item is not present in the player’s inventory it is being added to it after the check. 

![Sequence Diagram 2](https://imgs.su/upload/271/759079439.jpg)

When a player wants to explore one of the neighbouring locations in the game, they have to give an input in the form: move + location name. The second sequence diagram represents what happens when the player uses the command MOVE. After that the check is being done on wether the given location is a neighbouring location to the one player was when inputting the command. If it is, the location is being loaded and the Player class receives the message. Then the details of the location, such as it's description, present NPCs and available items, as well as the next possible locations (neighbour locations), are being displayed to the player and they decide what to do next. However, if the location can not be reached from the player's position, a message is outputted, saying "Cannot find that place".

#  Implementation

Author(s): *Nariman Gasimov*

UML model was helpful with structuring the code. As it represents the skeleton of the system, it was easier to put in code the classes and objects. Starting from the main class and moving to GameState class and then the Player and Location classes. The strategy we had was to start with bigger classes and write slowly the methods and variables inside. The methods at first would be written in just pseudo code as comments. Later as we proceeded and had a clearer vision of how the actual methods would work, we started to write the actual code.

The key solution for our implementation was to do the commands given by the user in the Player class. The problem at first was that some of the commands needed to be in the GameState class, such as “move” command. As it needed to load a parsed json data to the Location object, this could only be done inside the GameState class. Our solution for this was to pass the current game state to the methods inside player class for them to access the methods inside the gamestate, thus changing the game state. Now the commands entered by the user are being categorized in GameState class but handled in Player class. We did this because it made more sense for the “Player” to do the actions such as “move” or “talk” or “look” instead of being done in an object that is called after the state of the game. We also implemented alternative action commands such as go (for move) and answer (go) for user friendliness of the game.

One of the other issues that we had to tackle was the way to put the switch cases as it was not possible to do string comparison in our version of java. After doing and trying several methods we decided to use enums as the values for commands entered by the user. Another issue that appeared during implementation of this was that when a user would enter an unknown command, the compiler would crash before reaching the default case because there did not exist the enum that the user entered. We ued try and catch block to tackle and solve this issue.

Main class only parses the json files, sets the starting location as the first location in the json file (index 0) and starts an instance of a GameState, later it only asks for user input and keeps updating the GameState object with the arguments that user put. The whole game’s state is dictated by the GameState class. It represents the state of the game and holds all the necessary objects inside, privately. The objects inside the GameState are player, location, locationList and isFinished.

LocationList object is of type JSONArray and holds the parsed json’s elements inside as a json array. This array is used later in the game to set the current location of the player as they move along the map. LocationList is not changed throughout the game.

Location object holds the current location of the player. The value is loaded as the player changes location inside the game and moves along the map. For example when a user goes from point a to point b, the program looks for point b inside the locationList and loads that piece of data with the name point b onto the current Location object. Location class holds the necessary data that is needed for the display of given location. The location name, description, npcs that are in that location, list of items available and the list of neighboring locations.

Player object holds the name and the inventory of the current playing player. When an item is acquired the game adds the gotten item to the inventory list. When a player moves or does some kind of action inside the game, they are handled in the Player class’ methods. Player.move() first checks if the commanded move is legal, e.g. if the new location is in the neighboring list of the current location, and calls the GameState to set the location to the new one. Player.look() checks if the asked npc is available in that location and displays information about that npc, otherwise it states that the npc is not available. Player.talk() checks if the asked npc is available, and also checks if the user has already obtained the given item, and then shows the riddle of the given npc in order to obtain the item. Then Player.say() is for the user to answer to the given riddle. If the answer is correct the player gets to add the chosen item to their inventory list.

isFinished is the indicator of whether the gameplay is finished or not. This is used for the main loop of the game as well as for the possible future feature of pausing the game and continuing it later. Player may choose to manually stop the game by entering the command to quit the game, or in the other case if the game has come to an end.

Out of other classes the InputParser class is used to parse the user input into commands and arguments and return the corresponding measure. LocationLoader class is used to take the map json file and parse into the corresponding Location and NPC objects.

#### Video
<iframe src="https://drive.google.com/file/d/1qtQUgQXwtoLn_vkOCNBmn4mlueFabEQk/preview" width="640" height="480"></iframe>
<!--stackedit_data:
eyJoaXN0b3J5IjpbMTQ1Mzc0NDk4MCwtNjEzMjcxNjA3LC02MD
A0OTc0NTcsOTk4MzkzMTExLC05MDA2Mjk0NzcsMTEwMDM2Mjk1
OCwtMjA0Mjk5MTQ1OSw0MTMwNzc0MzcsMTI0NTk5NjE0NywtMT
I3MDI1NjQ4OSwtMTE2MzEyMDMyNCwtNjU0MTA2NjM5LDUxMDI3
NjcxMywxNjY0NjA3MDA3LDE4MjI4ODAwNzMsNjg2ODE1NDA5LD
M5MDA4OTQ2NywxODM3MTgzNzIsLTE2MTEwMjM0NDcsMTI2MjYx
NjA2MF19
-->