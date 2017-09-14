# Run automation
- Goto root (cd automationbase...)
- Run mvn clean to delete /target content folder
- Run mvn test  "-Dbrowser=chrome" "-Denv=pp1" "-Dtest=BaseRunner" "-Dcucumber.options=--tags @functional_tests" - Dcucumber.options="--plugin io.qameta.allure.cucumberjvm.AllureCucumberJvm" to run the tests

- Browser params to pass:  
-- firefox
-- chrome
-- ie
-- safari