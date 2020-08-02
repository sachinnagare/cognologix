#Project
=================
https://www.themealdb.com/ An open, crowd-sourced database of Recipes from around the world. 
This assignment has 2 parts
1. UI Automation 
a) This is mainly used to choose  select item from Popular Ingredients and perform operation on it.
b) search Item from the list and verify it

2. API Automation 
a) Automate API as per the requirement.

Task Done - Test cases has been Automated based on the requirement with validation approach.
Pending - Data driven approach is pending from framework perspective. Will work on it based on time availability.


Created Data Driven Framework for this Module with Below details :
1. Properties File - Parameter saved into properties file (browser, chromeDriver url etc.)
2. Language Used - Java.
3. Model - page Object Model.
4. Maven - Dependency Management.
5. Testng - Controlling test execution. (Parameterised test cases to launch browser)

Need to work on more specific flow. Will work on it based on time constraints.
1. write more test cases at granular level based on the requirement.

#Setting Up
=================
Added dependencies into pom.xml so it will download and install automatically. 


#Deploying
=================
Import the project into IDE such as Eclipse 

#Execution
===========
UI Execution --> testng.xml is available at root location . Right click on it —> Run As —> TESTNG SUITE
API Execution --> apitestng.xml is available at root location.  Right click on it —> Run As —> TESTNG SUITE

#Reporting
===========
Default testng reports is available at root level folder. Go to test-output-->Suite--> index.html


#Version History
=================
#### 0.0.1
- This is the first version of API/themealdb  assignment 

