  
# Allure reports  

- Allure reports documentation: https://docs.qameta.io/allure/latest/  
- To remove last test results run rm -rf allure-results/
- To generate result.json pass  
 -Dcucumber.options="--plugin io.qameta.allure.cucumberjvm.AllureCucumberJvm" to test
- To use reporst in jenkins install Allure jenkins Plugin: https://wiki.jenkins.io/display/JENKINS/Allure+Pluginse
- To generate the report locally run: allure generate --clean
