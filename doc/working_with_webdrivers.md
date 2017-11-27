  
#General info  
Default browser to use in test is chrome. If no browser will be selected, chrome will be picked up. 
TBD: add support for Firefox and Safari 

# Chrome
Chrome webdriver is downloaded, unzipped and set in params automatically.  
To change the version of chrome webdriver:   
 1. Update: src/main/resources/selenium.properties  
 2. Set: chomeDriverVersion = VERSION  
 3. Pass "-Dbrowser=chrome" param for mvn, while test is executed
 
 List of version to update abvalible in official website: https://sites.google.com/a/chromium.org/chromedriver/downloads


