What I used:
Created Maven project for Rest Assured.
Installed all dependencies to POM.xml.
Use the HOST info from env.properties.
Create Reusable methods for the GET request.
Create resources by using Nasa Documentation. 
Used log4j to see the logs.
Created tests with the name GetNasaSearch.java.
Used TestNG to trigger my tests.

How to run:

1st way (by Eclipse)
1-Download the repository to local
2-Open Eclipse (IDE) and choose "Open Project from File System"
3-Right click to the RestAssuredTest project and choose RunAs "TestNG Test"
4-get the logs by "logs" folder
5-get the report by "test-output" folder / index.html

2nd way (by Jenkins)
1-Go to Jenkins account
2-Click on execute windows batch command and I write my test command to run (trigger) my jobs (mvn test)
3-Click on “Manage Jenkins” and then click on “Global Tool Configuration”. 
4-Go to main page and click on New Item to create a job
5-Enter name of the job such as “API Test”, then I click on “Freestyle Project” and click.
6-Go to main page again and click on my job
7-Click on “Configure” to be able to address the code place 
8-Click on “Build Now”, and then Click on Console Output to see result 
