package com.qa.tlv.pageObjects;

import com.qa.tlv.environment.BaseTest;
import com.qa.tlv.logger.Log;
import com.qa.tlv.methods.TestCaseFailed;

/**
 * Search
 * 
 * @author Pavel Yampolsky
 *
 */

public class SearchPageObject implements BaseTest {

    // elements
    String searchFormCSS = "div.searching";

    public void verifySearchDisplayed() throws TestCaseFailed {
        Log.INFO("Verify search is displayed");
        browserObj.checkElementPresence("css", searchFormCSS);
    }

    public void enterSearchText() throws TestCaseFailed {
        Log.INFO("Enter search text");
        browserObj.enterText("css", "AAA", searchFormCSS);
    }
}
