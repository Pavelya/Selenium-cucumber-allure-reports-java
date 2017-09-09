package stepdefs;

import com.qa.tlv.pageObjects.LoginWindowPageObject;

import cucumber.api.java.en.And;

public class LoginTestStepDefs {

	
	LoginWindowPageObject login = new LoginWindowPageObject ();
	
	@And("^enter username$")
	public void enterUsername() throws Throwable {

		login.enterUsername();
	}
	
	@And("^enter password$")
	public void enterPassword() throws Throwable {

		login.enterPassword();
	}
	
}
