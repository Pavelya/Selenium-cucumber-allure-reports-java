# Pass parameters from config files

Two types of configuration files are enebled in project:

1.  src/main/resources/config.properties
	Goal: to store configuration, not depends from environment (example: test username)
	Usage: username = propertiesObj.getProperty("username");
	
2.	src/main/resources/ANY_NAME.environment.properties
	Goal: pass parameters, related to specific environment  
	Usage: to point to environment config file pass env param: mvn test  "-Dbrowser=chrome" "-Denv=ANY_NAME"...
		   to get correct cofig: System.getProperty("ANY_NAME").toLowerCase();
		   to read data from environment cofig: preProdUrl = propertiesObjgetEnvironmentProperty("preProdUrl");
	