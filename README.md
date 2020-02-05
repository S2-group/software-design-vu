# Software Design 
This is a project template for the Software Design course at the Vrije Universiteit Amsterdam. 

First step for this course is to fork our repository. All subsequent work would be on the newly forked repository.

Each assignment requires the creation of a branch and all work must be done only on that. The branch will be merged to the master via the pull request eventually. 
 
The name of the branch must be `assignment<NUMBER OF THE ASSIGNMENT (1, 2, or 3)>`

## **Submission guidelines:**  

After finalizing your project, a submission can be made by inviting a collaborator to your personal repository (make sure you have the privileges to do that). 

The collaborator should be the TA that has been assigned to your group on the following spreadsheet: 

http://shorturl.at/fjtyQ  

You’re expected to submit your project on Canvas as well by providing a URL of your git repository.


## **How to create a Pull request**

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

You'll see a list of commits that have been made by you.
If you've followed the steps correctly, Github will show you a page that says “Open a pull request”.
This is how you create a pull request.


## **Submission format**

Before making the pull request for your assignments 2 and 3, you shall push also a fat Jar in your repository.

How to build a Jar file with Intellij:
1. Go to File -> Project Structure and click Artifacts. 
2. Click the Add button (+), point to JAR, and select From modules with dependencies.
3. To the right of the Main Class field, click the Browse button, select Search By Name and search for your class in the dialog that opens (for example, if the name of your class is Main, then search for Main).
4. Apply the changes and close the dialog.

You can find your jar file in /out/artifacts/filename.jar.

If you're still having troubles, check out the following link: https://www.jetbrains.com/help/idea/packaging-a-module-into-a-jar-file.html.

## **Slip-days:**  
Each group has a total of 3 slip days for all the assignments.   
