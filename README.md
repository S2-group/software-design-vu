# Software Design 
This is the template for the team project of the Software Design course at the Vrije Universiteit Amsterdam. 

The first steps of your team project are to:
- create your own private repository
- invite all team members ase collaborators
- download all contents of this repository (`software-design-vu`) and copy them into the root folder of your repository

All subsequent work will be on your repository.

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
base: `master` 
compare: the branch where you are currently working (e.g., `Assignment1`)  

4. Once you have selected your branches, GitHub will ask you to write a title and a comment for the Pull Request. The title of the Pull Request should follow the following pattern: `<Team name>-Assignment<Number of assignment>`. You will see a list of commits that have been made by you. If you have followed the steps correctly, GitHub will show a summary of your Pull Request.

5. Do a submission in Canvas and provide the unique URL of your Pull Request. It has this structure: `https://github.com/<username>/<repo name>/pull/<digit>`. 

## **Submission format**

Before making the pull request for your assignments 2 and 3, you shall push also a fat Jar in your repository.

How to build a Jar file with Intellij:
1. Go to File -> Project Structure and click Artifacts. 
2. Click the Add button (+), point to JAR, and select From modules with dependencies.
3. To the right of the Main Class field, click the Browse button, select Search By Name and search for your class in the dialog that opens (for example, if the name of your class is Main, then search for Main).
4. Apply the changes and close the dialog.

You can find your jar file in /out/artifacts/filename.jar.

If you are still having troubles, check out [this link](https://www.jetbrains.com/help/idea/packaging-a-module-into-a-jar-file.html).
