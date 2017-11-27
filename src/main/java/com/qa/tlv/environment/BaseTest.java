package com.qa.tlv.environment;

import com.qa.tlv.methods.AssertionMethods;
import com.qa.tlv.methods.BrowserUtils;
import com.qa.tlv.methods.MiscMethods;
import com.qa.tlv.methods.PropertiesManagementMethods;

public interface BaseTest {

	MiscMethods miscmethodObj = new MiscMethods();
	PropertiesManagementMethods propertiesObj = new PropertiesManagementMethods();
	BrowserUtils browserObj = new BrowserUtils();
	AssertionMethods assertionObj = new AssertionMethods();

}
