package com.qa.tlv.environment;

import com.qa.tlv.methods.BrowserUtils;
import com.qa.tlv.methods.PropertiesManagementMethods;

public interface BaseTest {
	PropertiesManagementMethods props = new PropertiesManagementMethods();
	BrowserUtils browser = new BrowserUtils();
}
