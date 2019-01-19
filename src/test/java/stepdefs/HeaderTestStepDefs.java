package stepdefs;

import com.qa.tlv.pageObjects.HeaderPageObject;
import cucumber.api.java.en.And;

public class HeaderTestStepDefs {
    
	HeaderPageObject header = new HeaderPageObject();
	
	@And("^my header is displayed$")
	public void enterUsername() throws Throwable {
		header.verifyHeaderDisplayed();
	}
}
