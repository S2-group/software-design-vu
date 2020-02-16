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
| F1 | API to Create/Read/Update/Delete snippets | Users should be able to easily access edit, create and delete snippets by calling the tool from the CLI using arguments. |
| F2 | Snippet editor | Users should be able to edit and save snippets via a basic Vim-like CLI editor with visual/insert/replace modes. |
| F3 | Tags | Users should be able to add tags to snippets by which will make finding snippets easier. This should include language and whether the snippet is "starred". |
| F5 | Search/Filter | Users can search for their snippets by content, tags, description, title, language. Like snippo -s "language:java tags:tag1,tag2 searchterm". |
| F6 | Configurable syntax highlighting | Users should have their code for a specific language with highlighting of syntax that is configurable via a file (that they create or that has been provided) that maps keywords to colors. |
| F7 | Readme/help for the tool | Users should be able to view a manual explaining the basic commands and how to use the tool. |
| F8 (optional) | Authentication | Users should be able to create and use accounts where their personal protected snippets are stored. |
| F9 | Snippet metadata | Users should be able to view snippet metadata such as creation and last modification date, count of times edited or opened. |
| F10 (optional) | Import/Export snippets | Users should be able to import and export via a json file to reuse on a different machine using Snippo. |
| F11 (optional) | Integrated with Github Gist API | Users should be able to use Snippo in conjunction with Github Gists: [https://developer.github.com/v3/gists/](https://developer.github.com/v3/gists/) |
| F12 | Basic interactive UI in shell | On launch the program should display available commands (e.g. edit, create, delete) and execute the chosen ones until closed.  |

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
