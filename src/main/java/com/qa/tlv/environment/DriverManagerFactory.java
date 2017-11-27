package com.qa.tlv.environment;

public class DriverManagerFactory {
	
	static ChromeDriverSetup chromeSetup = new ChromeDriverSetup();

    public static DriverManager getManager(DriverType type) {
    	
		// download and setup chrome driver as default
		chromeSetup.downloadChromeDriver();
		chromeSetup.unZipIt();
		chromeSetup.makeWebDriverExecutable();

        DriverManager driverManager;

        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new ChromeDriverManager();
                break;
            default:
                driverManager = new ChromeDriverManager();
                break;
        }
        return driverManager;

    }
}