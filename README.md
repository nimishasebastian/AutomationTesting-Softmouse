#  SoftMouse Automation Testing

Automated regression test suite for the SoftMouse application using Selenium and Java. This project aims to ensure application stability by automating key workflows 
such as login, strain creation, editing, and deletion.


## Project Overview

This framework is built using:
- **Java**
- **Selenium WebDriver**
- **TestNG**
- **Maven**
- **Page Object Model (POM)**
- **ExtentReports** (for detailed test reporting)

##  Project Structure
com.Selenium.qa.base/ → Base Test Setup (TestBase.java)
com.Selenium.qa.pages/ → Page Object Classes
LoginPage.java
HomePage.java
CreateNewStrain.java
EditStrain.java
StrainsList.java

com.Selenium.qa.testcases/ → Test Classes
LoginPageTest.java
CreateNewStrainTest.java
StrainsListTest.java

testng.xml → TestNG Suite Runner
pom.xml → Maven Configuration


## Steps to Clone and Execute the step 
https://github.com/nimishasebastian/AutomationTesting-Softmouse

git clone https://github.com/nimishasebastian/AutomationTesting-Softmouse
cd AutomationTesting-Softmouse
mvn clean test

