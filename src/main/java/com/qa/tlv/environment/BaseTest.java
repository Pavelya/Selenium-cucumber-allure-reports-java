package com.qa.tlv.environment;

import methods.BrowserUtils;
import methods.MiscMethods;
import methods.NavigateMethods;
import methods.PropertiesManagementMethods;

public interface BaseTest {

	MiscMethods miscmethodObj = new MiscMethods();
	NavigateMethods navigationObj = new NavigateMethods();
	PropertiesManagementMethods propertiesObj = new PropertiesManagementMethods();
	BrowserUtils browserObj = new BrowserUtils();

}
