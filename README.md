### **Hoffner readme file**

Software requirements:
Java 1.8
Intelijj

Plugins:
Cucumber for java

How to use:

git clone git@github.com:andreoli1001via/kriegerdigital.git

Go to build - build project

Go to file - settings - Build, Execution, Deployment - Build Tools - Gradle - put Run testes using Intellij IDEA

Go to file - Project Structure - modules - verify if you have a module > origination-crm-tests

If not add a module Gradle - Java with name origination-crm-tests

Go to file HoffnerTest.java and open it

In the file you can change the @TAG the scenario you want to run filling with one of these below:

@HoffnerScenario01
@HoffnerScenario02
@HoffnerScenario03
@HoffnerScenario04

Verify on right corner, click on selection box and click on Edit Configuration.

Add a Junit test and on Junit Configuration observe if the fields are like:
"Class" : krieger.steps.portabilidade.HoffnerTest
"VM options:" -ea
"Working directory:"$MODULE_WORKING_DIR$"
"Use classpath of module:" = origination-crm-testes.test

and run it with Junit

