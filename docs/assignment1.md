# Assignment 1
Maximum number of words for this document: 2500

Word Count: 1553

## Introduction
Author(s): Sofia Konovalova & Bogdan-Petre Cercel

Ever since Pong was released in 1958, the video game scene has been steadily growing. Over time, technologies improved and the popularity and general interest in games have boomed, especially in the early 2000's.
Video games are an opportunity to escape the world, and train your brain in various different activities. Games have a wide variety of genres, ranging from full on simulations of physics to simple interactive novels with branching stories.
[*Zork*](https://en.wikipedia.org/wiki/Zork) is one of the first interactive computer games, released in 1980. It is a text adventure game, where the protagonist interacts with the virtual
world and other players. These games have evolved from simple text-based games to more complex artistic games of today. Going back to the classics, this project will be a minimal version of Zork, which takes place in a post-apocalyptic world.
Our protagonist wakes up in the middle of the day, seeing an emergency alert on his phone of an imminent missile strike. They go on a mission to find their
family or risks dying in the nuclear strike.

The minimal game of Zork consists of a protagonist, a virtual world, and objects and virtual characters. We took inspiration from the Black Isle Studios
game [Fallout 2](https://store.steampowered.com/app/38410/Fallout_2_A_Post_Nuclear_Role_Playing_Game/) with the post-apocalyptic world using simple objects as currency. In the *Fallout* game series, bottle caps are used as currency. In our game,
sporks are used as the currency (the word rhymes with Zork). Post-apocalyptic genre games became incredibly popular in the mid-2000s to the early 2010s, so it is difficult to
point to a specific game that inspired that world in our game.

The project track specifies that our game be loyal to the original Zork, which will run completely in the terminal. The termainal with have color-coded text, in order
to indicate to the player whether text describes a player, a situation, or the protagonists' health, etc. As an extension, we can create an alternative version
of the game that runs with a GUI, to mimic the second-generation text-based games. A "GUI" can even be included within the console that is used to play the game, by using Java libraries such as Text-IO.
With games such as Zork and various other text-based adventure games, the target audience is teenagers and young adults, but as this game will not
include anything incredibly explicit and violent like the *Fallout* game series, this game may be played at an age.

This gameplay will be achieved by creating models of the two important factors of the game: the scenes in which the character is in at a given moment,
and the characters that the player encounters in the scenes. Each of the scenes will be based on the same template, but with different objects, characters
and places to explore. Since we are working with object-oriented programming, a separate Scenes model will be created, with a different scene being created
at points in the game with specific parameters, with some possibly randomized. Each scene will have different options but falling under one of the three
umbrellas of movement, exploration or interaction. The interaction can be with characters, objects. Interactions can also be of different types, like picking
up an object or walking in a certain direction. These interactions help the player to reach the goal or to fail and lose the game.

Word Count: 552

## Features
Author(s): Koen van den Burg

### Functional features

These functional features are imperative in order to make the game work the way is necessary. Many of these features are inherently linked with each other, therefore if one feature is not met in the final product, then the entire game falls apart. These features are inspired by what we know of adventure games, as well as certain features that are present in text-based games only, such as written commands and a turn-based time mechanic.

<table>
<tr>
<th>ID</th>
<th>Short Name</th>
<th>Description</th>
</tr>
<tr>
<td>F1</td>
<td>Commands</td>
<td>Game shall have a <b>text-based option system</b>, where the player can type different commands in a command prompt which will result in different
actions(F3).</td>
</tr>
<tr>
<td>F2</td>
<td>Interface</td>
<td>The game shall be played inside a command prompt. Everything is text. Some scenarios should have ASCII art.</td>
</tr>
<tr>
<td>F3</td>
<td>Actions</td>
<td>Typing different commands shal result in different actions in the game world, examples of such are:
<ul>
<li>Movement</li>
<li>Attacking</li>
<li>Conversation</li>
<li>Interacting with items (doors, keys, picking up items)</li>
<li>Dying (restarts the game)</li>
<li>Healing</li>
<li>Examining items and surrounding</li>
<li>Sleeping</li>
</ul>
</td>
</tr>
<tr>
<td>F4</td>
<td>Items</td>
<td>There shall be a multitude of different items which can be added to the inventory of the player (F8):
<ul>
<li>Weapons</li>
<li>Keys</li>
<li>Healing items</li>
<li>Ammunition</li>
</ul>
</td>
</tr>
<tr>
<td>F5</td>
<td>Characters</td>
<td>The game shall have characters, each with different statistics(F6) defining what they are (enemies, friendlies, etc).</td>
</tr>
<tr>
<td>F6</td>
<td>Statistics</td>
<td>The gameshall have <b>statistics</b> for the player and other characters in the game. Statistics will be:
<ul>
<li>Health Points</li>
<li>Debuffs (hangover, wounds, bleeding)</li>
<li>Aggressiveness</li>
</ul>
</td>
</tr>
<tr>
<td>F7</td>
<td>Combat</td>
<td>The game shall have a simple <b>combat system.</b> If the player is able to attack a target, depending on the aggressiveness of the target, it can
attack the player back. If the attack hits there is 50/50 chance of damage. The combat system should have a modifier mechanic on which the chance
of hitting or damage depends on. "Stronger" enemies have higher modifiers thus will give more damage to the player. </td>
</tr>
<tr>
<td>F8</td>
<td>Inventory</td>
<td>The game shall have a simple <b>inventory system</b> using slots for weapons, currency and other items. Simple means there is no weight and volume system.
Weapons are not stackable, while currency and other items are.</td>
</tr>
<tr>
<td>F9</td>
<td>Time Mechanic</td>
<td>The game shall have a <b>time system</b> for story-telling purposes. Time will be implemented with a turn-based system, for example: every <i>x</i> turns
<i>y</i> amount of time passes. Some actions will pass time immediately, such as sleeping.</td>
</tr>
</table>

### Quality requirements
Author(s): Claudia Grigoras

| ID  | Short name  | Quality attribute | Description  |
|---|---|---|---|
| QR1  | Commands sanity checks | Reliability | When the player issues a command, the syntax of the command shall always get validated against the format specified in F3 |
| QR2  | Adaptable system | Maintainability & Responsiveness | The video game shall be easily adaptable to new stories and worlds. The system should not be dependent to one story only (when changing the story or the world, only variables and actions should change) |
| QR3  | Loading game state | Responsiveness | Once the player types in a command, loading the game state shall be executed in less than 5 seconds regardless of the computer capabilities |
| QR4  | Accessing the commands | Usability & Availability | The players shall at any point within the game be able to access the available commands at that particular level in game (through the command specified at F3 – examine\) |
| QR5  | Secured connections | Security | When playing in a multiplayer mode, the system should provide a safe network connection to both user  |
| QR6  | Real-time commands multiplayer mode | Responsiveness & Reliability | The system shall have a maximum latency of 2 seconds for providing commands and loading game state between 2 players in multiplayer mode |
| QR7  | Un-biased game | Reliability & Responsiveness | The system shall ensure that the statistics provided at F6 are correct and un-biased and that the combat mentioned at F7 is unbiased and always gives a 50/50 chance roll. |
| QR8  | Reliable data  | Reliability & usability | The system shall provide correct inventory responses and storing (F7) and correct timing within the game (F8) |

Word Count: 715

### Java libraries
Author(s): Wilkin van Roosmalen

The following table contains a list of Java libraries that will be used for this project.

| Name (with link) | Description  |
|---|---|
| [TextIO](https://text-io.beryx.org/releases/latest/) | Text-IO is a Java library that is used in making console applications that read interactive input from the user. It by default uses text terminals that are backed by Java's default java.io.Console library. This is perfect for this project as  we are required to use the terminal as the game screen, but using this library we can make the terminal more interactive than the default console. |
| [Gson](https://github.com/google/gson) | Gson is a Java serialization and deserialization library maintained by Google. It is used to convert Java objects to JSON files and back on the go.  In this project we can use this library to read configuration files hold attributes of game objects. We can also save game states and player information if we decide to add this feature. |
| [Apache Commons RNG](https://commons.apache.org/proper/commons-rng/) | Apache Commons RNG provides different implementation of pseud-random number generation algorithms and utility methods related to RNG. This library will prove useful when implementing features that depend on randomness, such as the combat system. |
| [KryoNet](https://github.com/EsotericSoftware/kryonet) | KryoNet provides a simple API for communicating between clients. Using a its own serialization library (Kryo), it sends objects through the TCP and/or UDP protocol(s). If we get to implementing multiplayer features KryoNet will simplify networking immensely. |
| [Tinylog](https://tinylog.org/v2/) | Tinylog is a lightweight, configurable, logging framework. It is easy to use as it provides a static logger that can be utilized in a lot of situations. When working on a project it is always useful to log what exactly is happening. Because we use the command line interface `System.out` is not a great option. With Tinylog we can easily change where logs are send and/or saved. |

Word Count: 286
