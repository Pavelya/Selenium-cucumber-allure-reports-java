package com.qa.tlv.pageObjects;

import com.qa.tlv.environment.BaseTest;
import com.qa.tlv.logger.Log;
import com.qa.tlv.methods.BrowserUtils;
import com.qa.tlv.methods.TestCaseFailed;

/**
 * Search
 * 
 * @author Pavel Yampolsky
 *
 */

public class SearchPageObject implements BaseTest {
	
	BrowserUtils browser = new BrowserUtils();
	

	
	// environment
	String environment;

	// elements
	String searchFormCSS;

	public SearchPageObject() {

		// elements
	    searchFormCSS = "div.searching";

	}

    public SearchPageObject verifySearchDisplayed() throws TestCaseFailed {
        Log.INFO("Verify search is displayed");
        browserObj.checkElementPresence("css", searchFormCSS);
        return this;
    }
    
    public SearchPageObject enterSearchText() throws TestCaseFailed {
        Log.INFO("Enter search text");
        browserObj.enterText("css", "AAA", searchFormCSS);
        return this;
    }

	
}
