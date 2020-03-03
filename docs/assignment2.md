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

This chapter contains the specification of the UML class diagram of your system, together with a textual description of all its elements.

`Figure representing the UML class diagram`

The **Player** class represents the user, i.e. the person moving through the game. Their name is a string object that contains whatever name the user chooses. Their inventory is a list of Item objects, containing any objects that were picked up but not yet put down. This way, we keep a list of all items the player can use at a given time. The currentLocation is a Room object that indicates which room the player is in at a given time. The getObjects method returns a list of the player's current inventory, the getCurrentRoom method returns the player's current location, and the setCurrentRoom method changes the player's location to the given room. The player class is associated with the Room class because it needs to be able to access the player's current location. It is also associated with the Objective class because the Player needs to know what their time limit is for the game. It is also associated with the Item class, because it needs to keep track of the player's inventory. The association with the Action class is because a Player needs to be able to perform actions in order to change their location or inventory. 

The **Objective** class represents the goal of the current game, and will hold information about whether or not the player has completed/won the game. The goal field contains the time in which the user needs to finish the game in order to win. The result field represents whether or not a player has won, either true or false. The winStatement is a String that is presented to the player when they win. The loseStatement is a String that is presented to the player when they lose. The win method returns true or false based on whether the user has finished the game in the allotted time frame. The Objective class is associated with the Setting class because each setting will have a different goal. It is also associated with the TimeLimit class because the user wins or loses based on the time limit given for the game. 

The **Action** class represents all of the actions and movements a user can perform in the game. The commandName field is a string that the user inputs in order to perform an action. The item is the Item object that the action is being used on. The room is the Room object that the item is located in. The doAction method performs the action specified by CommandName, such as picking up, putting down, moving, and using an item. The printInventory method simply prints the player's current inventory, to see what items they can perform actions on. The Action class is connected to the Item class because each action needs to be performed on a specific item. The same holds for the Obstacle class; each obstacle will have actions that can be used on them. It is also connected to the CommandParser class because the CommandParser will determine whether a command is valid or not.  

The **Item** class represents the items in the game that can be used by the player. The name field holds the name of the item as a string, the location field holds the Room that the item is in, and usage holds a string that explains what the item is used for. The held field represents whether or not the item is currently in the user's inventory. The used field represents whether or not the user has already used the item. The getNameFromItem method returns the name of the item and the Usage method returns the item's purpose, i.e. how the player can use it. HoldItem changes the item's state to held, and the useItem method similarly changes the used state to used. It is connected to the Room class because each room can have an unlimited number of items, and the Room class needs to access that information.

The **Obstacle** class represents any obstacles in a room, such as something blocking a door. The itemNeeded field contains what item the user needs to use in order to overcome the obstacle. The open field contains whether or not the player has overcome the obstacle. The Obstacle class, like the Item class, is associated with the Room class because each Room can have unlimited obstacles, and it needs to keep an inventory of those.

The **CommandParser** class exists to recognize valid commands from the user and catch any invalid ones. The command field is just a list of strings that contains the command names. The parse method is what does all of the work; it goes through the commands and performs them if they are valid or throws an error if they are not. 

The **Setting** class represents the place the user is in, and contains all of the locations a player can go. The rooms field is a list of Room objects that holds every room that exists in the current game. The Setting class is composed with the Room class, because each setting can have unlimited rooms, and a room cannot exist without a setting. 

The **Room** class represents an individual room within the setting of the game. The name field is a string stating the name of the room. The items hashmap holds each Item object that is in the given room. The same holds for obstacles, except it contains Obstacle objects. NextRooms is a hashmap of rooms to which you can get to from the current room. The script is the string that the user will read when they enter the given room. The getItemFromName method returns the item object based on the name, and the getNextRoomFromName does the same, just for room objects. The getNextRooms method returns a hashmap containing all of the possible rooms you can get to from the current room. 

The **TimeLimit** class represents the time a user has left in the game. It will keep track of the player's time since starting the game, and assist the Objective class in assessing whether the player has won the game. The time field contains the current time, and the maxTime contains the maximum time the player has to complete the game. 

The **Main** class

For each class (and data type) in the class diagram you have to provide a paragraph providing the following information:
- Brief description about what it represents
- Brief description of the meaning of each attribute
- Brief description of the meaning of each operation
- Brief description of the meaning of each association involving it (each association can be described only once in this deliverable)

Also, you can briefly discuss fragments of previous versions of the class diagram (with figures) in order to show how you evolved from initial versions of the class diagram to the final one.

In this document you have to adhere to the following formatting conventions:
- the name of each **class** is in bold
- the *attributes*, *operations*, *associations*, and *objects* are in italic.

Maximum number of words for this section: 2500

## Object diagrams								
Author(s):  Sam

This chapter contains the description of a "snapshot" of the status of your system during its execution. 
This chapter is composed of a UML object diagram of your system, together with a textual description of its key elements.

`Figure representing the UML class diagram`
  
`Textual description`

Maximum number of words for this section: 500

## State machine diagrams									
Author(s): Beth, Gemma

This chapter contains the specification of at least 2 UML state machines of your system, together with a textual description of all their elements. Also, remember that classes the describe only data structures (e.g., Coordinate, Position) do not need to have an associated state machine since they can be seen as simple "data containers" without behaviour (they have only stateless objects).

For each state machine you have to provide:
- the name of the class for which you are representing the internal behavior;
- a figure representing the part of state machine;
- a textual description of all its states, transitions, activities, etc. in a narrative manner (you do not need to structure your description into tables in this case). We expect 3-4 lines of text for describing trivial or very simple state machines (e.g., those with one to three states), whereas you will provide longer descriptions (e.g., ~500 words) when describing more complex state machines.

The goal of your state machine diagrams is both descriptive and prescriptive, so put the needed level of detail here, finding the right trade-off between understandability of the models and their precision.

Maximum number of words for this section: 2500

## Sequence diagrams									
Author(s): Ben

This chapter contains the specification of at least 2 UML sequence diagrams of your system, together with a textual description of all its elements. Here you have to focus on specific situations you want to describe. For example, you can describe the interaction of player when performing a key part of the videogame, during a typical execution scenario, in a special case that may happen (e.g., an error situation), when finalizing a fantasy soccer game, etc.

For each sequence diagram you have to provide:
- a title representing the specific situation you want to describe;
- a figure representing the sequence diagram;
- a textual description of all its elements in a narrative manner (you do not need to structure your description into tables in this case). We expect a detailed description of all the interaction partners, their exchanged messages, and the fragments of interaction where they are involved. For each sequence diagram we expect a description of about 300-500 words.

The goal of your sequence diagrams is both descriptive and prescriptive, so put the needed level of detail here, finding the right trade-off between understandability of the models and their precision.

Maximum number of words for this section: 2500

## Implementation									
Author(s): Ben, Beth, Gemma, Sam, Sarah

In this chapter you will describe the following aspects of your project:
- the strategy that you followed when moving from the UML models to the implementation code;
- the key solutions that you applied when implementing your system (for example, how you implemented the syntax highlighting feature of your code snippet manager, how you manage fantasy soccer matches, etc.);
- the location of the main Java class needed for executing your system in your source code;
- the location of the Jar file for directly executing your system;
- the 30-seconds video showing the execution of your system (you can embed the video directly in your md file on GitHub).

IMPORTANT: remember that your implementation must be consistent with your UML models. Also, your implementation must run without the need from any other external software or tool. Failing to meet this requirement means 0 points for the implementation part of your project.

Maximum number of words for this section: 1000

## References

References, if needed.
