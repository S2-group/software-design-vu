# Assignment 1
Maximum number of words for this document: 2500

Word Count: 618

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
and places to explore. Since we are working with object-oriented programming, a separate Scenes class will be created, with a different scene being created
at points in the game with specific parameters, with some possibly randomized. Each scene will have different options but falling under one of the three
umbrellas of movement, exploration or interaction. The interaction can be with characters, objects. Interactions can also be of different types, like picking
up an object or walking in a certain direction. These interactions help the player to reach the goal or to fail and lose the game.

Word Count: 552

## Features
Author(s): Koen van den Burg

<When defining both functional features and quality requirements, remember that you will need to come back to them in Assignments 2 and 3 and explicitly state how specific parts of models/implementation satisfy them.>

### Functional features

As a preamble to the table, you can discuss the main line of reasoning you applied for defining the functional features provided in the table.

| ID  | Short name  | Description  |
|---|---|---|
| F1  | ... | ...  |
| F2  | ...  | ... |
| F3  | ... | ... |
| F4  | ... | ... |

### Quality requirements
Author(s): Koen vand den Burg

As a preamble to the table, you can discuss the main line of reasoning you followed for coming up with the quality requirements listed below.

| ID  | Short name  | Quality attribute | Description  |
|---|---|---|---|
| QR1  | ... | ... | ... |
| QR2  | ... | ... | ... |
| QR3  | ... | ... | ... |
| QR4  | ... | ... | ... |

Each quality requirement must be tagged with the corresponding quality attribute (see corresponding slides of the first lecture for knowing them).

Maximum number of words for this section: 1000

### Java libraries
Author(s): Wilkin van Roosmalen

| Name (with link) | Description  |
|---|---|
| [TextIO](https://text-io.beryx.org/releases/latest/) | Text-IO is a Java library that is used in making console applications that read interactive input from the user. It by default uses text terminals that are backed by Java's default java.io.Console library. This is perfect for this project as  we are required to use the terminal as the game screen, but using this library we can make the terminal more interactive than the default console. |
| ... | ... |
| ... | ... |

Maximum number of words for this section: 500
Word Count: 66
