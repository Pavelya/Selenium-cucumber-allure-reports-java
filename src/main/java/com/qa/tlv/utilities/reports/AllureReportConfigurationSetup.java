package com.qa.tlv.utilities.reports;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.qa.tlv.logger.Log;

/**
 * Utils to setup Allure report
 * 
 * @author Pavel Yampolsky
 *
 */

public class AllureReportConfigurationSetup {

	// folders params
	static String allureReportResultsFolder = "allure-results";
	static String allureReportPropertiesFileName = "environment.properties";
	static String allureReportPropertiesFilePath = allureReportResultsFolder + "/" + allureReportPropertiesFileName;
	static String allureReportScreenshotsFolder = "Screenshots";

	static File allureReportPropertiesFile = new File(allureReportPropertiesFilePath);

	public static void prepareAllureResultsFolder() {

		// step 1. delete allure results folder
		File allureResultsFolder = new File(allureReportResultsFolder);
		try {
			deleteAllureResultsFolder(allureResultsFolder);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// step 2. create allure results folder
		try {
			createAllureResultsFolder(allureResultsFolder);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
        // step 3. delete allure screenshots folder
        File allureSnapshotsFolder = new File(allureReportScreenshotsFolder);
        try {
            deleteAllureResultsFolder(allureSnapshotsFolder);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // step 4. create allure screenshots folder
        try {
            createAllureResultsFolder(allureSnapshotsFolder);
        } catch (IOException e) {
            e.printStackTrace();
        }

		// step 5. create and populate allure report properties file
		writeToAllureConfigFile("ENVIRONMENT", "");
	}

	// UTILS
	public static void writeToAllureConfigFile(String propName, String propValue) {

		try {
			if (allureReportPropertiesFile.createNewFile()) {
				Log.INFO("File: " + allureReportPropertiesFilePath + " is created");
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// load config file
		Properties props = null;
		try {
			FileInputStream in = new FileInputStream(allureReportPropertiesFilePath);
			props = new Properties();
			props.load(in);
			in.close();
		} catch (Exception e) {

		}
		// edit config file
		try {
			FileOutputStream out = new FileOutputStream(allureReportPropertiesFilePath);
			props.setProperty(propName, propValue);
			props.store(out, null);
			out.close();
		} catch (Exception e) {
		}
	}

	public static void deleteAllureResultsFolder(File allureResultsFolder) throws IOException {

		if (allureResultsFolder.isDirectory()) {

			// directory is empty, then delete it
			if (allureResultsFolder.list().length == 0) {

				allureResultsFolder.delete();
				Log.INFO("Folder is deleted : " + allureResultsFolder.getAbsolutePath());

			} else {

				// list all the directory contents
				String files[] = allureResultsFolder.list();

				for (String temp : files) {
					// construct the file structure
					File fileDelete = new File(allureResultsFolder, temp);

					// recursive delete
					deleteAllureResultsFolder(fileDelete);
				}

				// check the directory again, if empty then delete it
				if (allureResultsFolder.list().length == 0) {
					allureResultsFolder.delete();
					Log.INFO("Directory is deleted : " + allureResultsFolder.getAbsolutePath());
				}
			}

		} else {
			// if file, then delete it
			allureResultsFolder.delete();
			Log.INFO("File is deleted : " + allureResultsFolder.getAbsolutePath());
		}
	}

	public static void createAllureResultsFolder(File allureResultsFolder) throws IOException {

		if (!allureResultsFolder.exists()) {
			if (allureResultsFolder.mkdir()) {
				Log.INFO("Directory is created!");
			} else {
				Log.ERROR("Failed to create directory!");
			}
		}
	}

	public static void createAllureHistoryFolder(File allureHistoryFolder) throws IOException {

		if (!allureHistoryFolder.exists()) {
			if (allureHistoryFolder.mkdir()) {
				Log.INFO("Directory is created!");
			} else {
				Log.ERROR("Failed to create directory!");
			}
		}
	}
}
