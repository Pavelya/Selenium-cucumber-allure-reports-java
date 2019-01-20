package com.qa.tlv.environment;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.qa.tlv.logger.Log;

public class ChromeDriverManager extends DriverManager {

	WebDriverSetup chromeDriverSetup = new WebDriverSetup();

	private ChromeDriverService chService;

	@Override
	public void startService() {
		if (null == chService) {
			try {
				chService = new ChromeDriverService.Builder()
						.usingDriverExecutable(new File(chromeDriverSetup.getChromeDriverPath())).usingAnyFreePort()
						.build();
				chService.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void stopService() {
		if (null != chService && chService.isRunning())
			chService.stop();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void createDriver() {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();

		Map<String, String> mobileEmulation = new HashMap<>();
		mobileEmulation.put("deviceName", "iPhone X");

		ChromeOptions options = new ChromeOptions();

		if (getPlatform()) {
			Log.INFO("Create mobile browser");
			options.setExperimentalOption("mobileEmulation", mobileEmulation);
		}

		options.addArguments("test-type");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(chService, capabilities);
	}
    
    public boolean getPlatform() {
        return (System.getProperty("browser").contains("mobile")) ? true : false;
    }
}
