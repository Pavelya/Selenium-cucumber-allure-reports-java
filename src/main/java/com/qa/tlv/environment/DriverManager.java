package com.qa.tlv.environment;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    protected WebDriver driver;
    protected abstract void startService();
    protected abstract void stopService();
    protected abstract void createDriver();

    public void quitDriver() { 	
        if (driver!=null) {
            driver.quit();
            stopService();
            driver = null;
        }

    }

    public WebDriver getDriver() {
        if (driver == null) {
            startService();
            createDriver();
        }
        return driver;
    }
}