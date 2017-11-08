package com.qa.tlv.utiities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.qa.tlv.environment.BaseTest;
import com.qa.tlv.logger.Log;

public class RedirectsChecker implements BaseTest {

	public void redirectsChecker() {

		int totalNumOfUrls = 0;
		int currentUrlNumberUnderTest = 0;
		boolean ifTestPassed = true;

		// create list that will hold not redirected URL
		List<String> notRedirectedUrls = new ArrayList<String>();
		List<String> allURLsFromRediretionTestUrls = new ArrayList<String>();

		// get num of URLs
		CSVReader counterReader = null;
		try {
			counterReader = new CSVReader(new FileReader("PACH_TO_REDURECTION_FILE"));
			@SuppressWarnings("unused")
			String[] counter;

			while ((counter = counterReader.readNext()) != null) {
				totalNumOfUrls++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		CSVReader reader = null;
		try {
			reader = new CSVReader(new FileReader("PACH_TO_REDURECTION_FILE"));
			String[] line;

			while ((line = reader.readNext()) != null) {

				currentUrlNumberUnderTest++;
				Log.INFO("Testing URL no: " + currentUrlNumberUnderTest + " from: " + totalNumOfUrls);

				String sourceUrl = line[0];
				String destinatonUrl = line[1];

				// remove cookies
				browserObj.deleteCookies();

				// open source page
				browserObj.navigate(sourceUrl);

				Log.INFO("Waiting 3 sec");
				try {
					browserObj.wait(3000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}

				// check if redirected to destination URL
				String afterRedirectionUrl = browserObj.getPageUrl();

				Log.INFO("Source URL= " + line[0]);
				Log.INFO("Expected destination URL " + line[1]);
				Log.INFO("Actual destination URL " + afterRedirectionUrl);

				// add not redirected URLs to list
				allURLsFromRediretionTestUrls.add("Source URL: " + sourceUrl);
				allURLsFromRediretionTestUrls.add("Expected destination URL " + destinatonUrl);
				allURLsFromRediretionTestUrls.add("Actual destination URL " + afterRedirectionUrl);
				allURLsFromRediretionTestUrls.add(" ");

				// set error if not redirected
				if (!afterRedirectionUrl.equals(destinatonUrl)) {

					Log.ERROR("TEST FAILED, SAVE DATA TO FILE AND START TO TEST NEXT URL");
					System.out.println(" ");

					// add not redirected URLs to list
					notRedirectedUrls.add("Source URL: " + sourceUrl);
					notRedirectedUrls.add("Expected destination URL " + destinatonUrl);
					notRedirectedUrls.add("Actual destination URL " + afterRedirectionUrl);
					notRedirectedUrls.add(" ");
					ifTestPassed = false;
				}

				else {
					Log.INFO("TEST PASSED, START TO TEST NEXT URL");
					System.out.println(" ");
					try {
						browserObj.wait(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// create file with not redirected URLs
		saveRedirectionResultToLogFile(notRedirectedUrls, "badRedirectsOutputFile");

		// create file with all URLs
		saveRedirectionResultToLogFile(allURLsFromRediretionTestUrls, "generalRedirectionLogFile");
		assertionObj.assertTrue(ifTestPassed);

	}

	// UTILS
	public void saveRedirectionResultToLogFile(List<String> notRedirectedUrls, String fileName) {
		try {

			File file = new File("EXTERNAL_DATA_FILES_FOLDER" + fileName);

			// delete old output file
			Log.INFO("Delete old output file: " + "EXTERNAL_DATA_FILES_FOLDER" + fileName);
			if (file.exists()) {
				file.delete();
			}

			// if file does not exists, then create it
			Log.INFO("Create new output file: " + "EXTERNAL_DATA_FILES_FOLDER" + fileName);
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			Log.INFO("Starting to create file with not redirected URLs");

			for (int i = 0; i < notRedirectedUrls.size(); i++) {
				bw.write(notRedirectedUrls.get(i));
				bw.write(System.getProperty("line.separator"));
				Log.INFO("Add: " + notRedirectedUrls.get(i) + " to bad redirecitons file");
			}
			bw.close();

			Log.INFO("Finished to create file with not redirected URLs");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
