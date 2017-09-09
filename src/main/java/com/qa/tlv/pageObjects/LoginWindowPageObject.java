package com.qa.tlv.pageObjects;

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

	public LoginWindowPageObject enterUsername() {

		Log.INFO("Enter username");
		inputObj.enterText("id", username, usernameId);
		return this;
	}

	public LoginWindowPageObject enterPassword() {

		Log.INFO("Enter password");
		inputObj.enterText("id", password, "password");
		return this;
	}

}
