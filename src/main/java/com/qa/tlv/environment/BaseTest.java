package com.qa.tlv.environment;

import com.qa.tlv.methods.BrowserUtils;
import com.qa.tlv.methods.MiscMethods;
import com.qa.tlv.methods.NavigateMethods;
import com.qa.tlv.methods.PropertiesManagementMethods;

public interface BaseTest {

	MiscMethods miscmethodObj = new MiscMethods();
	NavigateMethods navigationObj = new NavigateMethods();
	PropertiesManagementMethods propertiesObj = new PropertiesManagementMethods();
	BrowserUtils browserObj = new BrowserUtils();

}
