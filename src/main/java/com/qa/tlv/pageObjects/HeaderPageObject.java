package com.qa.tlv.pageObjects;

import com.qa.tlv.environment.BaseTest;
import com.qa.tlv.logger.Log;
import static com.qa.tlv.methods.SelectorType.CSS;
import com.qa.tlv.methods.TestCaseFailed;

/**
 * Header POC
 * 
 * @author Pavel Yampolsky
 *
 */

public class HeaderPageObject implements BaseTest {
    
    // elements
    String headerCss = "div.header";

    public void verifyHeaderDisplayed() throws TestCaseFailed {
        Log.INFO("Verify header is displayed");
        browser.checkElementPresence(CSS, headerCss);
    }
}
