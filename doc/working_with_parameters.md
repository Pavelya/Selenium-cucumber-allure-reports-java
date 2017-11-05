# Pass parameters from config files

##### Two types of configuration files are enabled in project:

_src/main/resources/config.properties_  

	Goal: to store configuration, not depends from environment (example: folderName)  
	  
	Usage: PropertiesManagementMethods props = new PropertiesManagementMethods();  
	String folderName = props.getProperty(folderNameProperty);
	
_src/main/resources/ANY_NAME.environment.properties_  

	Goal: pass parameters, related to specific environment  
	  
	Usage: to point to environment config file pass env param: mvn test  "-Dbrowser=chrome" "-Denv=ANY_NAME"...  
	to get correct cofig: System.getProperty("ANY_NAME").toLowerCase();  
	to read data from environment cofig: preProdUrl = getEnvironmentProperty("preProdUrl");  
		   
	