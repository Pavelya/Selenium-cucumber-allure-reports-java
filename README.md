# Automation base

Automation Testing Using Selenium, BDD and Allure reports

Automation base is a behavior driven development (BDD) approach to write automation test script to test Web.  
The framework supports reporting with Allure reports

Getting Started
-------------
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

Prerequisites
--------------
Maven  
Git

Installing
-------------
Clone the repo to get a working project


Running the tests - command line mode
-------------------
cd to project path  

mvn clean test -Dbrowser=chrome -Denv=pp1 -Dtest=BaseRunner "-Dcucumber.options=--tags @functional_tests --plugin io.qameta.allure.cucumberjvm.AllureCucumberJvm"

Running the tests - from IDE  
-------------------
Run [src/test/java/cucumber_runners/BaseRunner.java](src/test/java/cucumber_runners/BaseRunner.java)  as maven test


Documentation
-------------
* [Installation](doc/installation.md)
* [Run tests](doc/run_tests.md)
* [Pass external parameters to test](doc/working_with_parameters.md)
* [Use allure reports](doc/allure_reports.md)
* [Use predefined steps](doc/canned_steps.md)
* [Webdriver types support](doc/working_with_webdrivers.md)
* [Mobile emulation](doc/mobile_emulation.md)

Built With
-------------
* [Selenium](http://www.seleniumhq.org/) - The web framework to automate browsers
* [Maven](https://maven.apache.org/) - Dependency Management
* [Cucumber](https://cucumber.io/) - Behavior Driven Development (BDD) library 
* [Allure reports](http://allure.qatools.ru/) - Reporting 

Contributing
-------------
Please read [CONTRIBUTING.md](doc/CONTRIBUTING.md) for details of the process for submitting pull requests.

Versioning
-------------
[SemVer](http://semver.org/) is in use for versioning.   
For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

Authors
-------------
**Pavel Yampolsky**  - Skype: pavel.yampolsky.willhill Email: 2pavelya@gmail.com

License
-------------
This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
