 
#General info  

Default browser to use in test is chrome. If no browser will be selected, chrome will be picked up. 
TBD: add support for Safari

# Firefox
To change the version of the driver:   
1. Download from https://github.com/mozilla/geckodriver/releases  
2. Unzip and save under: src/main/resources/selenium/firefoxdriver
3. Pass "-Dbrowser=firefox" param for mvn, while test is executed  

# Chrome
Chrome webdriver is downloaded, unzipped and set in params automatically.  
To change the version of chrome webdriver:   
 1. Update: src/main/resources/selenium.properties  
 2. Set: chomeDriverVersion = VERSION  
 3. Pass "-Dbrowser=chrome" param for mvn, while test is executed
 
 List of version to update abvalible in official website: https://sites.google.com/a/chromium.org/chromedriver/downloads


