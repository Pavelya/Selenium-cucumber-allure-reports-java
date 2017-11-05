package com.qa.tlv.methods;

import java.util.Arrays;

public class ErrorHandlingMethods {
	// Method to check browser type
	public void validateParameters(String platform, String browserType, String appPath) {
		if (platform.equals("desktop")) {
			if (Arrays.asList("ff", "ie", "chrome", "safari", "opera").contains(browserType))
				printErrorDesktop();
		} else if (platform.equals("android"))
			printErrorAndroid(browserType, appPath);
		else if (platform.equals("iOS"))
			System.out.println("Not Implemented...");
		else
			printInvalidPlatform();
	}

	// print error for desktop
	private void printErrorDesktop() {
		System.out.println("\nInappropraite desktop browser : \"#{ENV['BROWSER']}\"");
		System.out.println("\nUsage : cucumber BROWSER=browser_name");
		System.out.println("\nBrowser Supported  :\n");
		System.out.println("\n1.ie\n2.chrome\n3.ff\n4.safari\n5.opera");
		System.exit(0);
	}

	// print error for android
	public void printErrorAndroid(String browserType, String appPath) {
	}

	// print error if invalid platform
	public void printInvalidPlatform() {
		System.out.println("\nOops... Invalid Platform");
		System.out.println("\nSupported platform are \"android\" and \"iOS\".");
		System.out.println("\nTo run on Desktop no need to mention platform.");
		System.exit(0);
	}
}
