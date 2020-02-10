# Assignment 1
Maximum number of words for this document: 2500


## Introduction
Author(s): Sofia Konovalova

Ever since Pong was released in 1958, the video game scene has been steadily growing. Over time, technologies improved and the popularity and general interest in games have boomed, especially in the early 2000's.
Video games are an opportunity to escape the world, and train your brain in various different activities. Games have a wide variety of genres, ranging from full on simulations of physics to simple interactive novels with branching stories.
[*Zork*](https://en.wikipedia.org/wiki/Zork) is one of the first interactive computer games, released in 1980. It is a text adventure game, where the protagonist interacts with the virtual
world and other players. These games have evolved from simple text-based games to more complex artistic games of today. Going back to the classics, this project will be a minimal version of Zork, which takes place in a post-apocalyptic world.
Our protagonist wakes up in the middle of the day, realizing that he had slept through  a missile attack that has flattened his city, but somehow completely missed him.
He goes on a mission to find his family, encountering violent looters, proud doomsday preppers and others while trying to survive and come to terms with
his new world.

The minimal game of Zork consists of a protagonist, a virtual world, and objects and virtual characters. We took inspiration from the Black Isle Studios
game [Fallout 2](https://store.steampowered.com/app/38410/Fallout_2_A_Post_Nuclear_Role_Playing_Game/) with the post-apocalyptic world using simple objects as currency. In the *Fallout* game series, bottle caps are used as currency. In our game,
sporks are used as the currency (the word rhymes with Zork). Post-apocalyptic genre games became incredibly popular in the mid-2000s to the early 2010s, so it is difficult to
point to a specific game that inspired that world in our game.

The project track specifies that our game be loyal to the original Zork, which will run completely in the terminal. The termainal with have color-coded text, in order
to indicate to the player whether text describes a player, a situation, or the protagonists' health, etc. As an extension, we can create an alternative version
of the game that runs with a GUI, to mimic the second-generation text-based games. With games such as Zork and various other text-based adventure games, the
target audience is teenagers and young adults, but as this game will not include anything incredibly explicit and violent like the *Fallout* game series,
this game may be played at an age.

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
Author(s): `name of the team member(s) responsible for this section`

As a preamble to the table, you can discuss the main line of reasoning you followed for coming up with the quality requirements listed below.

| ID  | Short name  | Quality attribute | Description  |
|---|---|---|---|
| QR1  | Commands sanity checks | Reliability  | When the player issues a command, the syntax of the command shall always get validated against the format specified in F2 |
| QR2  | Extensible world | Maintainability  | The video game shall be easilty extendable in terms of levels, worlds, interaction points  |
| QR3  | Instantaneous results | Responsiveness  | Once the scores of all soccer players are provided by the user, the results of the virtual matches shall be available within 1 second |
| QR4  | ... | ... | ... |

Each quality requirement must be tagged with the corresponding quality attribute (see corresponding slides of the first lecture for knowing them).

Maximum number of words for this section: 1000

### Java libraries
Author(s): `name of the team member(s) responsible for this section`

| Name (with link) | Description  |
|---|---|
| [JFoenix](http://www.jfoenix.com/)  | Used for styling the user interface of the system. We chose it among others because ... |
| [fastjson](https://github.com/alibaba/fastjson) | We will use it for reading and writing JSON configuration files containing the description of the levels of the videogame. We chose it because it is easy to configure and use from Java code and preliminary experiments makes us confident about its correct functioning... |
| ...  | ... |

Maximum number of words for this section: 500
