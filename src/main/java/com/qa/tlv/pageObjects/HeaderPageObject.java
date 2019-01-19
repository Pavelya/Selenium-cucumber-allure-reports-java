package com.qa.tlv.pageObjects;

import java.io.IOException;

import com.qa.tlv.environment.BaseTest;
import com.qa.tlv.logger.Log;
import com.qa.tlv.methods.BrowserUtils;
import com.qa.tlv.methods.TestCaseFailed;

/**
 * Header
 * 
 * @author Pavel Yampolsky
 *
 */

public class HeaderPageObject implements BaseTest {
	
	BrowserUtils browser = new BrowserUtils();
	

	
	// environment
	String environment;

	// elements
	String headerCss;

	public HeaderPageObject() {

		// elements
		headerCss = "div.headesr";

	}

    public HeaderPageObject verifyHeaderDisplayed() throws TestCaseFailed {
        Log.INFO("Verify header is displayed");
        browserObj.checkElementPresence("css", headerCss);
        return this;
    }

	
}
