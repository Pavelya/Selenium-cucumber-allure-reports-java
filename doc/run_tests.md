# Run automation
- Goto root (cd automationbase...)
- Run mvn clean to delete /target content folder
- Run mvn clean test  "-Dbrowser=chrome" "-Denv=pp1" "-Dcucumber.options=--tags @TAG_NAME --plugin io.qameta.allure.cucumberjvm.AllureCucumberJvm" to run the tests

- Browser params to pass:  
-- firefox
-- chrome
-- ie
-- safari