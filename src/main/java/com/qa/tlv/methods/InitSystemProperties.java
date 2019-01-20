package com.qa.tlv.methods;

import com.qa.tlv.environment.BaseTest;
import com.qa.tlv.environment.WebDriverSetup;

public class InitSystemProperties implements BaseTest {

	WebDriverSetup chromeDriverSetup = new WebDriverSetup();

	public void setWebdriverSystemProperty() {
		System.setProperty("webdriver.chrome.driver", chromeDriverSetup.getChromeDriverPath());
		System.setProperty("webdriver.gecko.driver", chromeDriverSetup.getfirefoxDriverPath());
	}
}