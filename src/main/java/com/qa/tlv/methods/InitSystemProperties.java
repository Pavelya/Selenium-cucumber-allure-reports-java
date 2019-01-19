package com.qa.tlv.methods;

import com.qa.tlv.environment.BaseTest;
import com.qa.tlv.environment.ChromeDriverSetup;

public class InitSystemProperties implements BaseTest {

	ChromeDriverSetup chromeDriverSetup = new ChromeDriverSetup();

	public void setWebdriverSystemProperty() {
		System.setProperty("webdriver.chrome.driver", chromeDriverSetup.getChromeDriverPath());
		System.setProperty("webdriver.gecko.driver", chromeDriverSetup.getfirefoxDriverPath());
	}
}