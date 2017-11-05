package com.qa.tlv.utiities;

import java.io.File;

import com.qa.tlv.logger.Log;
import com.qa.tlv.methods.PropertiesManagementMethods;

/**
 * Util to remove file from folder
 * 
 * source: https://coderanch.com/t/378308/java/delete-existing-files-dierectry
 *
 */

public class FileManipulationUtils{

	static PropertiesManagementMethods props = new PropertiesManagementMethods();

	public void removeFilesInFolder(String folderNameProperty) {
		try {

			String folderName = props.getProperty(folderNameProperty);

			Log.INFO("Remove file from: " + folderNameProperty + " folder");

			File file = new File(folderName);
			String[] myFiles;
			if (file.isDirectory()) {
				myFiles = file.list();
				for (int i = 0; i < myFiles.length; i++) {
					Log.INFO("Remove file: " + myFiles[i]);
					File myFile = new File(file, myFiles[i]);
					myFile.delete();
				}
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
}