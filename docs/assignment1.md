## Introduction									
Author(s): `Noé Rousset`

This document introduces the Fantasy Soccer Project, addressing the specifications and requirements of the system and the libraries to be used to complete the project.
 
This project closely follows the standard format of fantasy football games, in that a user assembles imaginary teams, whose performance is statistically evaluated. Unlike the original format, however, for this game, the data, as well as the schedule, are both provided by the player. 
With the players added by the user, they can form a team of 11 players consisting of 1 goalkeeper, 4 defenders, 4 midfielders and 2 forwards. The score of each player is also added by the user, and the score of a team is the cumulative score of all the players. 
After that team is formed, a schedule is set by the user and a tournament is played with other random teams. The teams play 1 on 1 matches in a single-elimination format[1], where the team with the highest total score wins. After a tournament is over, the user can form a new team, start a tournament again with the current team  or close the game.
Possible improvements to this would be to use data for the players found online instead of the user adding it manually, and changing the way matches are played. In this upgraded version, each player would have the probability of committing a certain action, or an event happening based on their stats. For example a player with a strong attack would have a higher probability of scoring a goal. The score of a team would thus change between each game depending on their performance, with different actions [2]  earning a certain amount of points. 

[1] https://en.wikipedia.org/wiki/Single-elimination_tournament

[2] https://en.wikipedia.org/wiki/Fantasy_football_(association)#Points_scoring

## Features

### Functional features
Author(s): `Teona Moga`

The functional requirements below represent our understanding of the technical problem to be solved. We defined the constraints that the system needs to adhere to as well as the expectations for its anticipated behaviour.

| ID  | Short name  | Description  |
|---|---|---|
| F1  | User-provided data | Allow the user to manually provide player data via the user interface in CSV format. Each row should only contain two values, i.e. name and score, e.g. `Ben Foster,51`. The file shouldn’t have a header row. |
| F2  | Erroneous data  | In the event user input cannot be processed, present an error detailing the issue to the user.|
| F3  | Team formation  | Allow the user to form a team of 11 players from the players provided, with no duplicates.|
| F4  | Multiple teams | System will support the creation of multiple teams. In the case the user only creates one team, random teams are created by the system to reach the minimal number of teams in a league.|
| F5  | League formation | Allow the user to set up a league with its own schedule. The first round can have at most 16 matches. Matches will be played according to this schedule and the system will output the winner of each individual game. |
| F6 | Team score | The final score of a team is computed by summing the points scored by each of the players according to the user provided data. |
| F7 | Soccer match | A soccer match can be simulated between two teams. The winner is chosen based on each team’s final score as described in F5 - the highest scoring team wins. |
| F8 | Equal scores | In the event two teams have equal scores, the winner is chosen at random. |

### Quality requirements
Author(s): `Patricia Santana Vasquez`

The following quality requirements were chosen in order to improve ease of use from the user’s standpoint. They were also chosen in order to detail essentials for the team to adhere to for the maintenance of a properly and efficiently functioning system.

| ID  | Short name  | Quality attribute | Description  |
|---|---|---|---|
| QR1  | Intuitive UI | Usability  | UI should be simple, intuitive to use and consistent throughout the system. Interface elements should be minimal and allow only the necessary operations the user requires. |
| QR2  | Instantaneous results| Responsiveness  | Once a league starts, the results of the virtual matches shall be available within 1 second. |
| QR3  | Documentation | Maintainability  | The code is readable and follows a logical structure. |
| QR4 | Reliable Output  | Correctness | Scores computed by the system are accurate and precise. |

### Java libraries
Author(s): `Torstein Thomassen`

| Name (with link) | Description  |
|---|---|
| [JFoenix](http://www.jfoenix.com/)  | Used for styling the user interface of the system. We chose it among others because as some of us have previously worked with JavaFX. It should also be helpful in achieving QR1. | 
| [Apache Commons CSV](https://github.com/alibaba/fastjson) | We will use it for uploading and reading CSV files, as per F1.|
| [jsoup](https://jsoup.org/) | If we have time to extend out project to use real-life data. |
