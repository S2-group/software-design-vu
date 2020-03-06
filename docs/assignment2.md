# Assignment 2

Maximum number of words for this document: 9000

**IMPORTANT**: In this assignment you will model the whole system. Within each of your models, you will have a *prescriptive intent* when representing the elements related to the feature you are implementing in this assignment, whereas the rest of the elements are used with a *descriptive intent*. In all your diagrams it is strongly suggested to used different colors for the prescriptive and descriptive parts of your models (this helps you in better reasoning on the level of detail needed in each part of the models and the instructors in knowing how to assess your models).   

**Format**: establish formatting conventions when describing your models in this document. For example, you style the name of each class in bold, whereas the attributes, operations, and associations as underlined text, objects are in italic, etc.

### Implemented feature

| ID  | Short name  | Description  |
|---|---|---|
| F1  | Command | Player can control the main character using command line commands with the following syntax: ‘[command] [item]’. The commands we will implement are: move, open, break, inspect, help   |
| F2| Movements | Player can move through the environment using command: ‘move to [location]’ | 

### Used modeling tool
Draw.io

## Class diagram									
Author(s): Sarah

![Class Diagram](https://github.com/sarahpazik/software-design-vu/blob/Assignment2/classdiagram.png)

The **Player** class represents the user, i.e. the person moving through the game. Their *name* is a string object that contains whatever name the user chooses. Their *inventory* is a list of Item objects, containing any objects that were picked up but not yet put down. This way, we keep a list of all items the player can use at a given time. The *currentLocation* is a Room object that indicates which room the player is in at a given time. The *getObjects* method returns a list of the player's current inventory, the *getCurrentRoom* method returns the player's current location, and the *setCurrentRoom* method changes the player's location to the given room. The *getInventory* method returns the player's current inventory, i.e. what items they are currently holding, while *addToInventory* adds an item to this list. The player class is associated with the Room class because it needs to be able to access the player's current location. It is also associated with the Item class, because it needs to keep track of the player's inventory. The association with the Action class is because a Player needs to be able to perform actions in order to change their location or inventory. 

The **Action** class represents all of the actions and movements a user can perform in the game. The *commandName* field is a string that the user inputs in order to perform an action. The *item* is the Item object that the action is being used on. The *room* is the Room object that the item is located in. The *doAction* method performs the action specified by CommandName, such as picking up, putting down, moving, and using an item. The *printInventory* method simply prints the player's current inventory, to see what items they can perform actions on. The Action class is connected to the Item class because each action needs to be performed on a specific item. The same holds for the Obstacle class; each obstacle will have actions that can be used on them. 

The **Item** class represents the items in the game that can be used by the player. The *name* field holds the name of the item as a string, the *location* field holds the Room that the item is in, and *usage* holds a string that explains what the item is used for. The *held* field represents whether or not the item is currently in the user's inventory. The *used* field represents whether or not the user has already used the item. The *getNameFromItem* method returns the name of the item and the Usage method returns the item's purpose, i.e. how the player can use it. *HoldItem* changes the item's state to held, and the *useItem* method similarly changes the used state to used. It is connected to the Room class because each room can have an unlimited number of items, and the Room class needs to access that information.

The **Obstacle** class represents any obstacles in a room, such as something blocking a door. The *itemNeeded* field contains what item the user needs to use in order to overcome the obstacle. The *open* field contains whether or not the player has overcome the obstacle. The Obstacle class, like the Item class, is associated with the Room class because each Room can have unlimited obstacles, and it needs to keep an inventory of those.

The **Setting** class represents the place the user is in, and contains all of the locations a player can go. The *rooms* field is a list of Room objects that holds every room that exists in the current game. The Setting class is composed with the Room class, because each setting can have unlimited rooms, and a room cannot exist without a setting. 

The **Room** class represents an individual room within the setting of the game. The *name* field is a string stating the name of the room. The *items* hashmap holds each Item object that is in the given room. The same holds for *obstacles*, except it contains Obstacle objects. *NextRooms* is a hashmap of rooms to which you can get to from the current room. The *script* is the string that the user will read when they enter the given room. The *getItemFromName* method returns the item object based on the name, and the *getNextRoomFromName* does the same, just for room objects. The *getNextRooms* method returns a hashmap containing all of the possible rooms you can get to from the current room. The *getRoomName* method returns the name of the room, and *getScript* returns the script. *RemoveItemsFromRoom* allows you to take an item out of a room based on the item name. *GetItems* returns a list of all of the items in the room. 

The **TimeLimit** class represents the time a user has left in the game. It will keep track of the player's time since starting the game, and assist the Main class in assessing whether the player has won the game. The *currentTime* field contains the user's current time since starting, and the *timeLimit* contains the maximum time the player has to complete the game. 

The **Main** class is where the execution of the game happens. It prompts the user to input a JSON file and then reads in the JSON file to execute the game from the file. The *startRoom* variable is a JSONObject indicating the room that the game starts in, and *endRoom* indicates the room that the game ends in. *RoomMap* and *itemMap* are hashmaps indicating which rooms contain which items, based on the information in the JSON file. *PlayerName* is simply a string containing the player's name, which comes from the user when the game prompts them to input their name. The Main class is able to access the Room class and TimeLimit because the Main class needs to know where the player is and whether they have won yet or not. 

Our class diagram started out with an Objective class as well, but as we started implementing, we realized that all of the functions of the Objective class could be more easily executed in the Main class. Now, we've instead decided to just have the Main class connect to TimeLimit instead of having Objective in between. 

## Object diagrams								
Author(s):  Sam

![Object Diagram](https://github.com/sarahpazik/software-design-vu/blob/Assignment2/object%20diagram%20(1).png)
  
Each of the objects represented in the object diagram match their descriptions as given in the explanation of the class 
diagram. Notably, any object indicated by a box in blue represents an object that has yet to be fully implemented (as it
 is not a part of Assignment 2), but that is planned for the completion of Assignment 3.

At a given state in the game, there is always a **Player** object representing the current player of the game. It
connects to an **Item** object, a **Room** object, an **Action** object, and a **Setting** object. The associated
**Item** object - in this case, "coffee" - represents an item that is in the player's current inventory. The **Action**
object indicates an action currently being taken by the player - in this case, "use coffee" - through a specific command
that represents a snapshot of a moment in the game. Notably, this **Action** is also associated to the **Item** because
it constitutes "using" the item. The **Room** object indicates the room the player is currently located in - in this
case, Station Zuid. Finally, the **Setting** object - Amsterdam - is a collection and description of all of the rooms.

In turn, the **Room** object connects to an **Item** object and an **Obstacle** object. The Item object, an
ov-Chipkaart, is connected because it represents an item found in that particular room. The **Obstacle** object - in
this case, a stop at the metro - will (once implemented) represent a barrier to continued movement by the player that
can be removed by using the correct item.

Finally, the **Setting** object - Amsterdam - connects to a **TimeLimit** object and back to the **Room** of
StationZuid. The room is one of many in the setting, while the **TimeLimit** will indicate how much time is left for the
player to reach the goal.

## State machine diagrams									
Author(s): Elizabeth, Gemma

#### Player State Machine

The player state machine represents the Player class, and how the Player class interacts with the Action class to complete the prompts from the command line. The diagram, entitled “Player State Machine”, describes the possible actions that a player can execute in order to change their state. For the scope of this assignment, this includes interacting with items and locations. 
 
 ![Player State Machine](https://github.com/sarahpazik/software-design-vu/blob/Assignment2/Player%20State%20Machine.png)
 
It is important to note that all of the features in blue on the state machine diagram are currently prescriptive and not yet implemented. 
	
The state machine in the diagram describes the possible states a player can adopt as they play the game. The game begins with no player. The user is prompted to provide the player with a name, and then this player is initialized using the corresponding name and JSON file. This is represented by the first arrow in the diagram, labeled with initPlayer(name), and then the following state. Upon entry into this state, the “Initial Player” begins in the “start room” specified in the JSON file, with no objects in their inventory. The player then has two options for the next commands they want to execute, i.e. the next states they can adopt: moving to a new location (“move”), or picking up an item (“pickUp”). 

If the player chooses to enter a new location, they move to the “Player in New Location” state in the diagram. Their current location is changed to the new one, and then displayed while they are in that state. If they choose to pick up an item in whichever location they are currently located, they move to the “Player with Item” state. That item is added to the player’s inventory, and stored there while they are in this state. The player can then choose if they want to move rooms again, or put down the item. The player can only put down an item if they are holding it (a feature which is currently only prescriptive). If they choose to put down this item, they exit the state in which they have that item, moving back to a state in which they are located in their current location but without the item in their inventory.

This continues in a cyclical way, with the player being able to move and pick up or put down items as they please. This cycle terminates when they enter the “end room” specified in the JSON file. Once they enter this room, their end time will be displayed (currently a prescriptive feature), as well as a win or lose message depending on whether or not they completed their objective within the bounds of the time limit. Entering the final state means that either the player has won or lost the game, which is why the diagram displays two alternate transitions following the end room, i.e. the two possible final states for the player. 

#### Item State Machine

The item state machine represents the internal behavior of the **Item** class.

![Item State Machine Diagram](https://github.com/sarahpazik/software-design-vu/blob/Assignment2/Item%20State%20Machine%20Diagram.png)

Similar to the Player State Machine, the feature in blue on the diagram are prescriptive and not yet implemented.

The state machine diagram describes the possible states an item may have over the course of the game. The game begins with no items. The user is prompted to provide the name of a JSON file, which contains the information needed to initialize the items. An item being initialized is represented by the first arrow in the diagram, labeled initialize Item(), and then the following state. Upon entry into this state, the "Initial Item" is located in the room specified in the JSON file, and the boolean attributes *held* and *used* are set to false.

If an item is picked up by the player, the item changes state to "Item in player inventory". Upon entry to this state, the attribute *held* is set to true, and now the item is in the player's inventory and no longer in the room. Now, every time the player moves location, the item's *location* is updated as well.

From the "Item in player inventory" state, the Item can either be put down or used. If an item is put down, *held* changes to false, the *location* is the room it was put down in, and the item is no longer in the player's inventory. From this state the item can be picked up again to return to the "Item in player inventory" state.

If the item is used from the "item in player inventory" state, the attribute *used* is set to true and the item is no longer needed, thus terminating the item.


## Sequence diagrams									
Author(s): Ben

 ![Change Room Sequence Diagram](https://github.com/sarahpazik/software-design-vu/blob/Assignment2/Change%20Rooms%20Sequence%20Diagram.png)

This diagram describes the interaction a user undertakes when moving their virtual character to another room in the game. First, the user types the command "move to \<room name\>" into the terminal. At this stage in program execution, control flow lies within a while loop in the main method. When this entry happens, the main class parses the input from the command line and sends it to the action class via the doAction() function. This function call involves passing two parameters, the player object and a tokenized version of the command string the user typed stored as a string array. Once here, the doAction() function processes the meaning of the command and executes it accordingly. First, it passes through a switch statement to begin to analyze the command. If it is an invalid command, the user will be informed of this, encouraged to use the “help” command, and control flow will return to the main method. Otherwise, as in this example, the user has typed a correct “move to” command. The function will first request the current room from the player object. Next it isolates the \<room name\> part of the user's command from the previously passed function parameter. It sends this string to the getNextRoomFromName() method of the original room object to access the next room. This method will return the proper room object from the room name string. However, if this new room name does not exist or is not accessible from the current room, it will return null. After this, if the room exists, it updates the current room field of the player object to this next room object by calling the player object’s setCurrentRoom() method with the new room object. Finally, the doAction() function prints out the contents of the new room object's 'script' field by accessing the new room object and calling the getScript() method on it. If the room is invalid, the doAction() function will print out a message to the user that this room is an invalid selection. Then, control flow returns to the main method. Now, the user will either see the script text stored in the new room that they have moved to that describes the room or the error message about the room being invalid. From here, the user can continue playing the game.

 ![Initial Setup Sequence Diagram](https://github.com/sarahpazik/software-design-vu/blob/Assignment2/Initial%20Setup%20Sequence%20Diagram.png)

This diagram describes the interaction a user undertakes when selecting the story file to use and how the program initializes all of the necessary objects from the json data. This step occurs after the program has initially been run and the user is prompted to input the name of the story file they intend to use. First, the user will type the absolute file path to this json. Here, the main method of the main class will begin to attempt parsing. It will check if the file exists, can be open, and can be read. If there is a file error, an exception will be thrown, the user will be informed that they supplied an invalid file, and program execution will terminate. Otherwise, as can be seen in the diagram, the user enters a valid file and parsing begins. A correctly formatted file will describe the start room and the end room by their names. It will also have a full description of each room in the game, including its name, a list of rooms it connects to, a list of items inside of it, and a string script that is associated with the room’s role in the story. Items will have a name field and a usage description field. The main method will process and save the start room name, end room name, and list of room descriptions. Next, it will traverse this list of rooms in a loop. Inside of this loop, it will traverse the items in the room. Here, all of the items in a room will be initialized, passing their name and usage data from the json to the item constructor. They are stored in a map from their name to the item object. After all the items in the room are traversed and mapped, the process of initializing the room object begins. All of the data from the json about the room’s name, connections, and script is parsed and, in conjunction with the previously created map of items, passed to the room constructor. Now that the base world is built, the user is prompted for his or her name.

## Implementation									
Author(s): Sam, Gemma

Our strategy for moving from our UML models to the implementation code was fairly simple. We started by setting up a 
minimally-implemented class for each of the classes that we planned to include through our diagrams. To be specific,
this involved adding our constructors, fields, and simple methods - mainly accessors and mutators - to each class as an
easy first step. Then we began more in-depth work on some of the more central classes, particularly those that are
relevant to our first two features as planned in Assignment 1. For us, this meant our **Main** class, **Room**, 
**Item**, **Setting**, **Action**, and **Player**. This notably left out **TimeLimit** and **Obstacle** as classes that
we plan on implementing as part of Assignment 3. In addition, we began work on the first iterations of JSON files used
for the implementation of many different types of games. As we continued developing our **Main** class and the JSON
files it would interact with, we realized we had modeled more complexity than necessary to describe (and later
implement) our planned features. In line with this realization, we chose to eliminate the **Objective** class (thus now
notably absent from all of our diagrams) as it was entirely redundant and unnecessary. In general, we continued with
this strategy of following our diagrammed plan and eliminating redundancies or unnecessary complexity until we had
implemented all of our features planned for Assignment 2. Furthermore, after getting as far as having a working game, we
tested the implementation of each significant new piece of code to ensure that we could catch any bugs and solve them
before they became too obscure or difficult to find.

There were several key solutions we applied when implementing our system. First and foremost, we decided that the best
way to make our game configurable or adaptable for new stories was to have it read and interpret JSON files that
included all of the setting-specific information, such as room, item, or obstacle names. Next, we established that the
simplest and most efficient method of continually reading the player's commands was to use a while loop within the
**Main** class during runtime - any sort of command parser class seemed to be unnecessarily complex as well as involve
more code being executed during runtime, likely making the game run slightly slower. Other key solutions were largely
GUI-related: while our game does take place entirely within the terminal as specified by the assignment, we use ANSI
colors to make the output shown to the player during the game more clearly readable and easily understood.

The main Java class needed for executing the system in the source code can be found at the directory location:
software-design-vu/src/main/java/Main.java

The Jar file can be found at the directory location:
software-design-vu/out/artifacts/software_design_vu_2020_jar/software-design-vu-2020-jar.jar

![30-Second Demo](https://github.com/sarahpazik/software-design-vu/blob/Assignment2/softwareDemo.mov)
This demo shows loading a JSON file and using the implemented commands of *help*, *look around*, *move to*, *inspect*, 
*pick up*, and *quit*.

## References

No references (as of yet).
