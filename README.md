# Software Design 
This is the template for the team project of the Software Design course at the Vrije Universiteit Amsterdam. 

The first step of your team project is to **fork** this repository. All subsequent work will be on your newly forked repository.

Each assignment requires the creation of a dedicated branch and all the work must be done only on that branch (in your repository). The name of the branch must be `Assignment<NUMBER OF THE ASSIGNMENT (1, 2, or 3)>`

During the course you will be asked to add an additional contributor to your repository. The collaborator must be the TA that has been assigned to your team on [this spreadsheet](http://shorturl.at/fjtyQ).


## **Submission of an assignment**  

After finalizing your assignment, you can submit it by:
- creating a single **pull request** from the branch of your assignment to the master branch of your repository;
- creating a submission in Canvas where you will provide the unique URL of your pull request.

## **How to create a Pull Request**

1. Open your git repository

2. Click on Pull requests, then click on the green button that says “new pull request”.
You’ll come to a page that says “Compare changes”.

3. Choose branches.
To create a pull request, you want to set the base and compare branches to the following:  
base repository: S2-group/software-design-vu  
base: master  
head repository: "yourname"/software-design-vu  
compare: branch you want to merge from (ex. if you worked from master branch, then choose master)  

4. Once you’ve selected your branches, Github will ask you to write a title and a comment. Write your group number in the title.

You will see a list of commits that have been made by you.
If you have followed the steps correctly, Github will show you a page that says “Open a pull request”.
This is how you create a pull request.


## **Submission format**

Before making the pull request for your assignments 2 and 3, you shall push also a fat Jar in your repository.

How to build a Jar file with Intellij:
1. Go to File -> Project Structure and click Artifacts. 
2. Click the Add button (+), point to JAR, and select From modules with dependencies.
3. To the right of the Main Class field, click the Browse button, select Search By Name and search for your class in the dialog that opens (for example, if the name of your class is Main, then search for Main).
4. Apply the changes and close the dialog.

You can find your jar file in /out/artifacts/filename.jar.

If you are still having troubles, check out [this link](https://www.jetbrains.com/help/idea/packaging-a-module-into-a-jar-file.html).
