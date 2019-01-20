package com.qa.tlv.pageObjects;

import com.qa.tlv.environment.BaseTest;
import com.qa.tlv.logger.Log;
import static com.qa.tlv.methods.SelectorType.CSS;

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
        browser.checkElementPresence(CSS, searchFormCSS);
    }

    public void enterSearchText(String searchText) throws TestCaseFailed {
        Log.INFO("Enter search text: "+searchText);
        browser.click(CSS, searchFormCSS);
        browser.enterTextByActions(CSS, searchText, searchFormCSS);
    }
}
