package com.qa.tlv.environment;

import com.qa.tlv.methods.InitSystemProperties;

public class DriverManagerFactory {

	static WebDriverSetup chromeSetup = new WebDriverSetup();
	static InitSystemProperties initSystemProperties = new InitSystemProperties();

	static // get browser type from user selection
	String browserName = System.getProperty("browser", "chrome");

	public static DriverManager getManager(DriverType type) {

		initChrome();

		DriverManager driverManager;

		switch (type) {
		case CHROME:
			driverManager = new ChromeDriverManager();
			break;
		case FIREFOX:
			driverManager = new FirefoxDriverManager();
			break;
		default:
			driverManager = new ChromeDriverManager();
			break;
		}
		return driverManager;
	}

	public static DriverManager getManagerByUserSelection() {
		initChrome();
		DriverManager driverManager;

		switch (browserName) {
		case "chrome":
			driverManager = new ChromeDriverManager();
			break;
		case "firefox":
			driverManager = new FirefoxDriverManager();
			break;
		default:
			driverManager = new ChromeDriverManager();
			break;
		}
		return driverManager;
	}

	public static void initChrome() {
		// download and setup chrome driver as default
		chromeSetup.downloadChromeDriver();
		chromeSetup.unZipIt();
		chromeSetup.makeWebDriverExecutable();

		// set system vars for webdriver
		initSystemProperties.setWebdriverSystemProperty();
	}
}