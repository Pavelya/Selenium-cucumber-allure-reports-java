package com.qa.tlv.pageObjects;

import java.io.IOException;

import com.qa.tlv.environment.BaseTest;
import com.qa.tlv.logger.Log;

/**
 * Template Base class.
 * 
 * @author Pavel Yampolsky
 *
 */

public class LoginWindowPageObject implements BaseTest {
	

	
	// environment
	String environment;

	// elements
	String usernameId;
	String username;
	String password;

	public LoginWindowPageObject() {

		// elements
		usernameId = "username";
		username = propertiesObj.getProperty("username");
		password = propertiesObj.getProperty("password");

	}

	public LoginWindowPageObject enterUsername() throws IOException {

		Log.INFO("Enter username");
		browserObj.enterText("id", username, usernameId);
		return this;
	}

	public LoginWindowPageObject enterPassword() throws IOException {

		Log.INFO("Enter password");
		browserObj.enterText("id", password, "password");
		
		return this;
	}

}
