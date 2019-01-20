package com.qa.tlv.methods;

import org.openqa.selenium.By;

public class SelectElementByType {
    /**
     * Method to select element 'by' type
     * 
     * @param type
     *            : String : 'By' type
     * @param access_name
     *            : String : Locator value
     * @return By
     */
    
    public static By getElementByType(SelectorType selectorType, String selectorValue) {

        switch (selectorType) {
        case CSS:
            return By.cssSelector(selectorValue);
        case ID:
            return By.id(selectorValue);
        case CLASS:
            return By.className(selectorValue);
        case XPATH:
            return By.xpath(selectorValue);
        case NAME:
            return By.name(selectorValue);
        case LINK_TEXT:
            return By.linkText(selectorValue);
        case PARTIAL_LINK_TEXT:
            return By.partialLinkText(selectorValue);
        default:
            return By.cssSelector(selectorValue);
        }
    }

}
