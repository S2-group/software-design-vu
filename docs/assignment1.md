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
| F2  | Error Reporting  | In the event user input cannot be processed, present an error detailing the issue to the user.|
| F3  | Team formation  | Allow the user to form a team of 11 players from the players provided, with no duplicates.|
| F4  | Multiple teams | System will support the creation of multiple teams. In the case the user only creates one team, random teams are created by the system to reach the minimal number of teams in a league.|
| F5 | Deletion | System will support the deletion of an existing player or team. |
| F6  | League formation | Allow the user to set up a league with its own schedule. The first round can have at most 16 matches. Matches will be played according to this schedule and the system will output the winner of each individual game. |
| F7 | Team score | The final score of a team is computed by summing the points scored by each of the players according to the user provided data. |
| F8 | Soccer match | A soccer match within a league can be simulated between two teams. The winner is chosen based on each team’s final score as described in F5 - the highest scoring team wins. |
| F9 | Equal scores | In the event two teams have equal scores, the winner is chosen at random. |
| F10 | Leaderboard | System will show a leaderboard of the top-performing teams based on the number of wins.|
| F11 | GUI | System will have a GUI comprising of a main menu, a league simulator (where the user creates and plays a league), a team editor (for team creation and deletion), a player editor(for adding player data as per F1) and a leaderboard (as per F10)|

### Quality requirements
Author(s): `Patricia Santana Vasquez`

The following quality requirements were chosen in order to improve ease of use from the user’s standpoint. They were also chosen in order to detail essentials for the team to adhere to for the maintenance of a properly and efficiently functioning system.

| ID  | Short name  | Quality attribute | Description  |
|---|---|---|---|
| QR1  | Intuitive UI | Usability  | The options to launch the league simulator, edit your team, and edit your players shall be available to the user within 1 second of running the program. All feature should be accessible in less than 4 clicks. |
| QR2  | Prompt results| Responsiveness  | Once a league starts, the results of the virtual matches shall be available within 1 second. |
| QR3  | Extensible Scale | Maintainability  | The fantasy soccer game shall be easily expandable in terms of scale in future iterations e.g. adding new player data multiple times |
| QR4  | System Service | Availability | When users enter the player data, the service of starting a match shall be available within 1 second. |
| QR5 | Reliable Output  | Reliability | Scores computed by the system are accurate and precise. |
| QR6 | Error messaging | Security | Verbose backend errors are not reported back to the user, only simple messages on how to fix an issue, e.g. "Not all teams of the league are selected".

### Java libraries
Author(s): `Torstein Thomassen`

| Name (with link) | Description  |
|---|---|
| [JFoenix](http://www.jfoenix.com/)  | Used for styling the user interface of the system. We chose it among others because as some of us have previously worked with JavaFX. It should also be helpful in achieving QR1. | 
| [Apache Commons CSV](https://github.com/alibaba/fastjson) | We will use it for uploading and reading CSV files, as per F1.|
| [jsoup](https://jsoup.org/) | If we have time to extend out project to use real-life data. |
