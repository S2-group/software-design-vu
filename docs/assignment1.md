# Assignment 1
## Introduction									

Authors: Serghei Mihailov, Bjorn Keyser, Yael Goede, Milos Delgorge

The name of the project is Snippo. The system we will be implementing will be an implementation based on the code snippets manager. The goal of the code snippets manager is to create a system to manage snippets of source code. The system will simplify the managing of snippets by providing formats and functionalities that will let the user search, edit, and create source code snippets. The system will be able to adapt to new languages introduced by the user, hereby increasing the potential user group to all programming language users. The snippets manager will be hosted locally on the machine. The user will be able to interact with the manager through the shell. Here the user can use a crud api to manage the available snippets. The system will also provide a search command that will make retrieving snippets easier. The search command will use other features, for example contents, tags and metadata to optimise the search speed. 

Existing snippet manager applications for inspiration:
1. Gisto: https://www.gistoapp.com/features
2. Github Gists: https://developer.github.com/v3/gists/.

## Features:

Author(s):Serghei Mihailov, Bjorn Keyser, Yael Goede, Milos Delgorge

| **ID** | **Short name** | **Description** |
| --- | --- | --- |
| F1 | API to Create/Read/Update/Delete snippets | Users should be able to easily access edit, create and delete snippets |
| F2 | Snippet editor | A basic Vim-like cli editor with visual/insert/replace modes |
| F3 | Tags | Users can add tags to snippets by which will make finding snippets easier |
| F4 | Choose language | The user can choose any supported programming language to make their snippet |
| F5 | Search/Filter | Users can search for their snippets by content, tags, description, title, language. Like snippo -s &quot;language:ja va tags:tag1,tag2 searchterm&quot; |
| F6 | Configurable syntax highlighting | highlighting of syntax that is configurable via a file that maps words to colors |
| F7 | Readme/help for the tool | Explaining the basic commands and how to use the tool |
| F8 | Shortcuts and shell parameters | In the style of: snippo -f &quot;assignment1&quot; returns files that contain &quot;assignment1&quot;; snippo -c &quot;new&quot; creates a snippet &quot;new&quot; |
| F9 (optional) | Authentication | Basic user account management system |
| F10 | Snippet metadata | (creation/modification date, etc) think of windows file data. |
| F11 (optional) | Import/Export snippets | Import/Export via a json file |
| F12 (optional) | Integrated with Github Gist API | [https://developer.github.com/v3/gists/](https://developer.github.com/v3/gists/) |
| F13 | Basic interactive UI in shell | On launch the program will display available commands (e.g. edit, create, delete) and execute the chosen ones until closed  |

## Quality Requirements:

Author(s): Serghei Mihailov, Bjorn Keyser, Yael Goede, Milos Delgorge

| **ID** | **Short name** | **Quality attribute** | **Description** |
| --- | --- | --- | --- |
| QR1 | Configurable language highlighting | Extensibility | It should be easy for the user to add a new code language. |
| QR2 | Fast search | Responsiveness | Fast search, scalable with the number and size of snippets |
| QR3 | Intuitive UI | Usability | A new user should be able to create/read/edit snippets within 5 minutes of using the tool |
| QR4 | Persistent snippet storage | Reliability | Snippets remain reliably stored in memory until deleted inside the manager or manually deleted from the filesystem |
| QR5 | Storing unsaved work | Reliability, Usability | In the case of unexpected shutdown of the process, unsaved work should be stored |

## Java libraries:

Authors: Serghei Mihailov, Bjorn Keyser, Yael Goede, Milos Delgorge

| Name | Description |
| --- | --- |
| [Picocli](https://picocli.info/quick-guide.html#_what_is_picocli) | Picocli is a Java library and mini-framework for creating command line applications with almost no code. |
| [Gists](https://developer.github.com/v3/gists/) | This api will be used as a bonus. Implementing the snippets manager with the gists api. |
| [java.net.HttpUrlConnection](http://download.oracle.com/javase/7/docs/api/java/net/HttpURLConnection.html) | For http requests. |
| [fastjson](https://github.com/alibaba/fastjson) | For managing json files |
| [Time4J](http://www.time4j.net/) | Managing datetime |
