package com.qa.tlv.environment;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {

    static WebDriverSetup chromeDriverSetup = new WebDriverSetup();
    private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();

    /*
     * Factory method for getting browsers
     */
    public WebDriver getBrowser(String browserName) {
        WebDriver driver = null;

        switch (browserName) {
        case "Firefox":
            driver = drivers.get("Firefox");
            if (driver == null) {
                driver = new FirefoxDriver();
                drivers.put("Firefox", driver);
            }
            break;
        case "IE":
            driver = drivers.get("IE");
            if (driver == null) {
                System.setProperty("webdriver.ie.driver", "C:\\Users\\abc\\Desktop\\Server\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                drivers.put("IE", driver);
            }
            break;
        case "Chrome":
            driver = drivers.get("Chrome");
            if (driver == null) {
                System.setProperty("webdriver.chrome.driver", chromeDriverSetup.getChromeDriverPath());
                driver = new ChromeDriver();
                drivers.put("Chrome", driver);
            }
            break;
        }
        return driver;
    }

    public static void closeAllDriver() {
        for (String key : drivers.keySet()) {
            drivers.get(key).close();
            drivers.get(key).quit();
        }
    }
}