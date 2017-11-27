package com.qa.tlv.environment;

import java.io.File;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

public class FirefoxDriverManager extends DriverManager {

	private GeckoDriverService ffService;

	@Override
	public void startService() {
		if (null == ffService) {
			try {
				ffService = new GeckoDriverService.Builder()
						.usingDriverExecutable(new File(
								"/Users/pavely/eclipse/java-mars/workspace/AutomationBase/src/main/resources/selenium/firefoxdriver/geckodriver"))
						.usingAnyFreePort().build();
				ffService.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void stopService() {
		if (null != ffService && ffService.isRunning())
			ffService.stop();
	}

	@Override
	public void createDriver() {
		driver = new FirefoxDriver();
	}

}
