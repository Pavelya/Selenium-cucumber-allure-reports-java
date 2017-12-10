 
#General info  

Default platform to use in test is desktop. If no browser will be selected, chrome will be picked up. 
  
# To enable mobile emulation:  
 1. Pass "-Dbrowser=mobile" param for mvn, while test is executed  
 Example:  
 mvn clean install "-Dbrowser=mobile" "-Denv=pp1" "-Dcucumber.options=--tags @pack1 --plugin io.qameta.allure.cucumberjvm.AllureCucumberJvm"
 


