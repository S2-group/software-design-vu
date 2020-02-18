# Assignment 1
### Group 14 - CodeSnippetManager - “Coniunx”
<br>Dimitar Georgiev - dgv500
<br>Klimis Tsakiridis - kts480
<br>Iva Dimitrova - ida460
<br>Stoyan Tsinov - stv500


## Introduction									
Author(s): `Dimtiar Georgiev, Klimis Tsakiridis, Iva Dimitrova, Stoyan Tsinov`

### Project track
As a team, we decided to go with the CodeSnippetsManager track. Our code snippet organizer will be called Coniunx (meaning friend/mate in Latin). Coniunx will be the right hand of every developer. 
### The main type of users
The software will be intended to help every developer/person who uses the same code/text repeatedly. The basic idea is to have a centralized space where you can keep code, phrases, sentences, et cetera accessible within a single click, in order to be reused. Many tools provide features such as notes, but if you are a developer there are limited solutions to support a syntax highlight. 
### How will the system work?
After starting our system the user will end up in the Dashboard (instead of menu) screen where he will be able to navigate through the system. Several options will be provided on this screen (screens):
1. Go to settings
2. Go to Snippets
3. Create new snippet
4. Recently added

Every screen will provide the user with different options.
### 1. Settings Screen
Will provide the user with options to change the system color and/or default programing language. Once the settings are changed the data will be parsed and sent to a JSON file which will notify the system that the settings are changed and will update the current settings accordingly. 

The user will be provided the option to categorize the snippets. He/she can provide the categories in a text area separated by comma. This implementation gives the user the opportunity to categorize its snippets. Our idea is that upon creation we would like to enable the user to better organize his snippets. Therefore being able to create categories seemed like a helpful feature. Some examples could be categories such as functions, math formulas, and small projects.
### 2. Snippets screen
The main view of this screen will be the list with all snippets on the left side of the screen and the overview of the snippets on the right. In the overview, the user will see his/her snippets grouped by the different programming languages used to create them. Every item in the list will have option buttons for editing, deleting and copying the snippet content.

Once a snippet from the left is selected an edit window will appear instead of the overview window. This will allow the user to edit the desired snippet. When the user “Saves” the changes the change will be updated in the JSON file containing all of the snippets.	

A dedicated “Add button” will be located on the screen all of the time. When the user is adding a snipped, he/she can select from multiple programming languages or leave it as plain text as well as setting the category. If a programming language is selected the text aria will automatically highlight any syntax that is relevant to this programing language. Any snippet can be added to a group for easy access.

For every snippet, a dedicated “Copy” button will be present. This button will help the user copy the content of the snippet without him/her having to do it manually. Moreover, a “Delete” button will remove the snipped from the list. Last but not least “Edit” button will be there so the user can access the edit window faster. If the user really needs the whole snipped he/she can download it on their device. The download will have the same file extension as the standard file extension of the language selected. Eg: if you have snipped named “hello_world” with selected Java language when downloading the file a suggested name will be hello_world.java.
### 3. Create new snippet screen
Once this option is chosen the user will be prompted with the option to add a new snipped to the system as mentioned in point 2. The user can set the category that will distinct the snippet from the others or simply add it to a list with other snippets sharing the same characteristics.
### 4. Recently added
This part of the Dashboard will display a list of the items that were added most recently to the list (regarding the group or language of the item). This option will be provided as we assume it will be a lot easier to access the lastly added snippet since in the “Snippet screen” the user will see the snippets ordered by name, not date. There will be the option for filtering the items but it will cost extra clicks to the user in order to see the most recently added items.


### How will the data be handled?
When the user opens the application the snippets.json and settings.json files will be parsed. Once the data is parsed it will be available to the user to add/edit/delete from it. In particular case as the settings, the user will be provided with a settings screen where he can change the settings variable. At the moment the user saves the data the variables will be updated in the settings.json file. Almost the same flow goes for the snippets. When the user loads the system, the snippets will be read from the snippets.json file and will be loaded in a list. From now on all of the snippet manipulations such as adding, removing, editing will take place locally in this list. When the user closes the application the JSON parser will parse this list and replace the data in the snippets.json file. Doing so the system has to parse the snippet.json only once. This will make the system faster instead of parsing and editing data every time a snippet is requested.


## Features
Author(s): `Dimtiar Georgiev, Klimis Tsakiridis, Iva Dimitrova, Stoyan Tsinov`

Most of the functional features will be implemented in order to make “life easier” for the user while using the application. 

### Functional features
Please find the list with our functional feature that we will implement.

| ID  | Short name  | Description  |
|-----|-------------|--------------|
| F1  | Add snippet  | Provide the user with the option to add snippets. When a snipets is added the option to set categories and programing language will be availabe.  |
| F2  | Update snippet  | Update an existing snippet |
| F3  | Delete snippet  | Delete an existing snippet |
| F4  | Save as file | Provide the option to download the snippet as file |
| F5  | Order snippets |For ease of use an ordering functionality will be introduced. This will help the user to easily locate the desired snipped faster <br>1.  By name - order the snippets per name <br> 2. By date - order the snippets per date|
| F6  | Change settigns  | This feature will provide the user with the opportunity to:<br>- Change the colors of the system <br>- Add categories<br>- Set default programing language  |
| F7  | Syntax highlight | When user in iserting text in the snippet the text area will highlight the code |
| F8  | Programing language support | The software will provide the following programing languages syntax recognition. Depending on the user choice of the language all reserved commands will be highlighted.|
| F9  | Search snippets | The user will be able to search in the list with snippets. The search will search only in the name of a snippet |
| F10 | Single-click copy | Single click functionality will provide a dedicated button where with single click you can copy the whole snippet |
| F11 | Filter sippets | Filtering snippets has the aim to keep the working environment more organize when showing only snippets from desired programing language or category or both:<br>- By programing language - This feature will provide the option of filtering the snippets on programing language <br>- By category - This feature will provide the option of filtering the snippets on category|

### Quality requirements
Author(s): `Dimtiar Georgiev, Klimis Tsakiridis, Iva Dimitrova, Stoyan Tsinov`


| ID  | Short name  | Quality attribute | Description  |
|---|---|---|---|
| QR1  | Dashboard | USABILITY  | Where the user can navigate through the whole system. Different menu options will have separated buttons to navigate to:<br>- Snippets<br>- Settings<br>- Create new snippet<br>- Recently added snippets (4-5 items) <br> Having a dashboard will make the navigation of the tool easier since we can control what is shown on the screen depending on which state we are currently on. For example we are in state DASHBOARD when the user clicks some of the options, lets say, settings the state will change to SETTINGS and other frames will be hidden except the settings screen. Easy access to F1 and F6|
| QR2  | Snippets JSON parser | PERFORMANCE  | parsing JSON file will be faster and easier than Database. The Functional features: F1, F2, F3 will reflect/depend directly on JSON parsing. <br><br>Initially the parser will read the “snippets.json” file which will create a list with all of the snippets. This list will be used through the session where the user will add, edit or delete any snippets. <br>When the user decides to close the application the list with all of the changes will be parsed back to json and will replace the existing records.<br>This process will make sure that the JSON file will be read only once and not every time we want to edit a snippet to read the file again.|
| QR3  | Single-click copy | USABILITY  | Dedicated copy button shall make copying of the snippet easier. Instead of selecting the whole text and copying it a single click button will be provided. This requrement will make sure that F10 is implemented.|
| QR4  | MVC like Design | MAINTAINABILITY |  This design pattern shall help the developer to easily maintain the code and add new features to it. The code will have three logical parts: <br><br>1. Model<br> In this part of the code the data will be provided. The data parsing will happen here and the data will be available for the controller to handle. <br><br>2. View<br> In this part of the code all of the views(JFrames) will be implemented. Furthermore, every different state of the application will have their custom made frames and components <br><br>3. Controller <br> The controller part will manipulate the data provided from the model. Every change that is made by the user will be registered by the controller and sent to the model.|
| QR5  | Local storage access | SUSTAINABILITY | The system will not be dependent on a state that the user needs to save before it closes the application. Or of a database connection that will fail. <br> Because of the fact that the system uses JSON files to provide and manipulate data, there is no need for the system to make snapshots and keep its current state.  |



### Java libraries
Author(s): `Dimtiar Georgiev, Klimis Tsakiridis, Iva Dimitrova, Stoyan Tsinov`

`NB: The presented list with libraries is not final since we are not exactly sure if we will encounter problems that will be easily solved by using a library. In the later state of the project those can change.`

Here is the list of the Java Libs that will be used:


| Name (with link) | Purpose | Description  |
|---|---|---|
| [RSyntaxTextArea](http://bobbylight.github.io/RSyntaxTextArea/)  |A Syntax Highlighting Text Component| This library will help us create a custom text area where the syntax highlight will be enabled. The library provides fully functional text with more than 40 supported languages. There are possibilities such as:<br>- autocomplete<br>- different themes support<br>- Multiple Font Support<br>- Find and replace<br>- These options will be considered to “make editing/adding a snippet easier” for the user.| 
| [Swing](https://en.wikipedia.org/wiki/Swing_%28Java%29) |Design| Swing  will be used to create the visual part of the application. It is a JAVA library existing in javax package. It is already integrated in Intellij which will be our IDE for implementing the project. Intellij already provides the designer tool that will allow us to position the desired element on the screen. All custom elements will be created from swing components using pure code. Implementing custom elements will give us the flexibility to create more beautiful and creative designs.|
| [Gson](https://github.com/google/gson) |JSON Parsing| JSON parser developed by Google will help us to create and parse JSON files. The library gives the opportunity to serialize and deserialize objects which will be the main problem in our application. <br><br>Using it we might be able to read all of the objects in the JSON file at once and not having the trouble of looping through the whole file and read the different properties one by one. We believe serializing will make our tool faster.<br><br>When the user closes the application we will implement a deserializing function that will fetch the current records of the snippets and converting them to a JSON file that will be available to read next time the application is opened.|

