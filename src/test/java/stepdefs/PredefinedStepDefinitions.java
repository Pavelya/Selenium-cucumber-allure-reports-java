package stepdefs;

import java.io.IOException;

import com.qa.tlv.environment.BaseTest;
import com.qa.tlv.methods.PropertiesManagementMethods;
import com.qa.tlv.methods.TestCaseFailed;

import cucumber.api.java.en.Then;

public class PredefinedStepDefinitions implements BaseTest {
    
    PropertiesManagementMethods props = new PropertiesManagementMethods();

	// Step to navigate to specified URL
	@Then("^user navigates to (.*)$")
	public void navigate_to(String link) throws IOException {
		browserObj.navigateTo(link);
	}
	
    // Step to navigate to base URL
    @Then("^user opens base lobby$")
    public void navigate_to_lobby() throws IOException {
        browserObj.navigateTo(props.getProperty("baseUrl"));
    }

	// Step to navigate forward
	@Then("^user navigates forward")
	public void navigate_forward() {
		browserObj.navigate("forward");
	}

	// Step to navigate backward
	@Then("^user navigates back")
	public void navigate_back() {
		browserObj.navigate("back");
	}

	// steps to refresh page
	@Then("^user refresh the page$")
	public void refresh_page() {
		browserObj.refreshDriver();
	}

	// Switch between windows

	// Switch to new window
	@Then("^user switch to new window$")
	public void switch_to_new_window() {
		browserObj.switchToNewWindow();
	}

	// Switch to old window
	@Then("^user switch to previous window$")
	public void switch_to_old_window() {
		browserObj.switchToOldWindow();
	}

	// Switch to new window by window title
	@Then("^user switch to window having title \"(.*?)\"$")
	public void switch_to_window_by_title(String windowTitle) throws Exception {
		browserObj.switchToWindowByTitle(windowTitle);
	}

	// Close new window
	@Then("^user closes new window$")
	public void close_new_window() {
		browserObj.closeNewWindow();
	}

	// Switch between frame

	// Step to switch to frame by web element
	@Then("^user switch to frame having (.+) \"(.*?)\"$")
	public void switch_frame_by_element(String method, String value) {
		browserObj.switchFrame(method, value);
	}

	// step to switch to main content
	@Then("^user switch to main content$")
	public void switch_to_default_content() {
		browserObj.switchToDefaultContent();
	}

	// To interact with browser

	// step to resize browser
	@Then("^user resize browser window size to width (\\d+) and height (\\d+)$")
	public void resize_browser(int width, int heigth) {
		browserObj.resizeBrowser(width, heigth);
	}

	// step to maximize browser
	@Then("^user maximize browser window$")
	public void maximize_browser() {
		browserObj.maximizeBrowser();
	}

	// Step to close the browser
	@Then("^user closes browser$")
	public void close_browser() throws IOException {
		browserObj.closeDriver();

	}

	// zoom in/out page

	// steps to zoom in page
	@Then("^user zoom in page$")
	public void zoom_in() {
		browserObj.zoomInOut("ADD");
	}

	// steps to zoom out page
	@Then("^user zoom out page$")
	public void zoom_out() {
		browserObj.zoomInOut("SUBTRACT");
	}

	// zoom out webpage till necessary element displays

	// steps to zoom out till element displays
	@Then("^user zoom out page till I see element having (.+) \"(.*?)\"$")
	public void zoom_till_element_display(String type, String accessName) throws Exception {
		miscmethodObj.validateLocator(type);
		browserObj.zoomInOutTillElementDisplay(type, "substract", accessName);
	}

	// reset webpage view use

	@Then("^user reset page view$")
	public void reset_page_zoom() {
		browserObj.zoomInOut("reset");
	}

	// scroll webpage

	@Then("^user scroll to (top|end) of page$")
	public void scroll_page(String to) throws Exception {
		browserObj.scrollPage(to);
	}

	// scroll webpage to specific element

	@Then("^user scroll to element having (.+) \"(.*?)\"$")
	public void scroll_to_element(String type, String accessName) throws Exception {
		miscmethodObj.validateLocator(type);
		browserObj.scrollToElement(type, accessName);
	}

	// hover over element

	// Note: Doesn't work on Windows firefox
	@Then("^user hover over element having (.+) \"(.*?)\"$")
	public void hover_over_element(String type, String accessName) throws Exception {
		miscmethodObj.validateLocator(type);
		browserObj.hoverOverElement(type, accessName);
	}

	// Assertion steps

	/**
	 * page title checking
	 * 
	 * @param present
	 *            :
	 * @param title
	 *            :
	 */
	@Then("^user should see page title as \"(.*)\"$")
	public void check_title(String title) throws TestCaseFailed {
		// System.out.println("Present :" + present.isEmpty());
		browserObj.checkTitle(title);
	}

	@Then("^user should see page source")
	public void getPageSource() throws TestCaseFailed {
		browserObj.getPageSource();
	}

	// step to check element partial text
	@Then("^user should\\s*((?:not)?)\\s+see page title having partial text as \"(.*?)\"$")
	public void check_partial_text(String present, String partialTextTitle) throws TestCaseFailed {
		// System.out.println("Present :" + present.isEmpty());
		browserObj.checkPartialTitle(partialTextTitle);
	}

	// step to check element text
	@Then("^element having (.+) \"([^\"]*)\" should\\s*((?:not)?)\\s+have text as \"(.*?)\"$")
	public void check_element_text(String type, String accessName, String present, String value) throws Exception {
		miscmethodObj.validateLocator(type);
		browserObj.checkElementText(type, value, accessName);
	}

	// step to check element partial text
	@Then("^element having (.+) \"([^\"]*)\" should\\s*((?:not)?)\\s+have partial text as \"(.*?)\"$")
	public void check_element_partial_text(String type, String accessName, String present, String value)
			throws Exception {
		miscmethodObj.validateLocator(type);
		browserObj.checkElementPartialText(type, value, accessName);
	}

	// step to check attribute value
	@Then("^element having (.+) \"([^\"]*)\" should\\s*((?:not)?)\\s+have attribute \"(.*?)\" with value \"(.*?)\"$")
	public void check_element_attribute(String type, String accessName, String present, String attrb, String value)
			throws Exception {
		miscmethodObj.validateLocator(type);
		browserObj.checkElementAttribute(type, attrb, value, accessName);
	}

	// step to check element enabled or not
	@Then("^element having (.+) \"([^\"]*)\" should\\s*((?:not)?)\\s+be (enabled|disabled)$")
	public void check_element_enable(String type, String accessName, String present, String state) throws Exception {
		miscmethodObj.validateLocator(type);
		boolean flag = state.equals("enabled");
		if (!present.isEmpty()) {
			flag = !flag;
		}
		browserObj.checkElementEnable(type, accessName);
	}

	// step to check element present or not
	@Then("^element having (.+) \"(.*?)\" should\\s*((?:not)?)\\s+be present$")
	public void check_element_presence(String type, String accessName, String present) throws Exception {
		miscmethodObj.validateLocator(type);
		browserObj.checkElementPresence(type, accessName);
	}

	// step to assert checkbox is checked or unchecked
	@Then("^checkbox having (.+) \"(.*?)\" should be (checked|unchecked)$")
	public void is_checkbox_checked(String type, String accessName, String state) throws Exception {
		miscmethodObj.validateLocator(type);
		boolean flag = state.equals("checked");
		browserObj.isCheckboxChecked(type, accessName, flag);
	}

	// steps to assert radio button checked or unchecked
	@Then("^radio button having (.+) \"(.*?)\" should be (selected|unselected)$")
	public void is_radio_button_selected(String type, String accessName, String state) throws Exception {
		miscmethodObj.validateLocator(type);
		boolean flag = state.equals("selected");
		browserObj.isRadioButtonSelected(type, accessName, flag);
	}

	// steps to assert option by text from radio button group
	// selected/unselected
	@Then("^option \"(.*?)\" by (.+) from radio button group having (.+) \"(.*?)\" should be (selected|unselected)$")
	public void is_option_from_radio_button_group_selected(String option, String attrb, String type, String accessName,
			String state) throws Exception {
		miscmethodObj.validateLocator(type);
		boolean flag = state.equals("selected");
		browserObj.isOptionFromRadioButtonGroupSelected(type, attrb, option, accessName, flag);
	}

	// steps to check link presence
	@Then("^link having text \"(.*?)\" should\\s*((?:not)?)\\s+be present$")
	public void check_element_presence(String accessName, String present) throws TestCaseFailed, Exception {
		browserObj.checkElementPresence("linkText", accessName);
	}

	// steps to check partail link presence
	@Then("^link having partial text \"(.*?)\" should\\s*((?:not)?)\\s+be present$")
	public void check_partial_element_presence(String accessName, String present) throws TestCaseFailed, Exception {
		browserObj.checkElementPresence("partialLinkText", accessName);
	}

	// step to assert javascript pop-up alert text
	@Then("^user should see alert text as \"(.*?)\"$")
	public void check_alert_text(String actualValue) throws TestCaseFailed {
		browserObj.checkAlertText(actualValue);
	}

	// step to select dropdown list
	@Then("^option \"(.*?)\" by (.+) from dropdown having (.+) \"(.*?)\" should be (selected|unselected)$")
	public void is_option_from_dropdown_selected(String option, String by, String type, String accessName, String state)
			throws Exception {
		miscmethodObj.validateLocator(type);
		boolean flag = state.equals("selected");
		browserObj.isOptionFromDropdownSelected(type, by, option, accessName, flag);
	}

	// Input steps

	// enter text into input field steps
	@Then("^user enters \"([^\"]*)\" into input field having (.+) \"([^\"]*)\"$")
	public void enter_text(String text, String type, String accessName) throws Exception {
		miscmethodObj.validateLocator(type);
		browserObj.enterText(type, text, accessName);
	}

	// clear input field steps
	@Then("^user clear input field having (.+) \"([^\"]*)\"$")
	public void clear_text(String type, String accessName) throws Exception {
		miscmethodObj.validateLocator(type);
		browserObj.clearText(type, accessName);
	}

	// select option by text/value from dropdown
	@Then("^user selects \"(.*?)\" option by (.+) from dropdown having (.+) \"(.*?)\"$")
	public void select_option_from_dropdown(String option, String optionBy, String type, String accessName)
			throws Exception {
		miscmethodObj.validateLocator(type);
		miscmethodObj.validateOptionBy(optionBy);
		browserObj.selectOptionFromDropdown(type, optionBy, option, accessName);
	}

	// select option by index from dropdown
	@Then("^user selects (\\d+) option by index from dropdown having (.+) \"(.*?)\"$")
	public void select_option_from_dropdown_by_index(String option, String type, String accessName) throws Exception {
		miscmethodObj.validateLocator(type);
		browserObj.selectOptionFromDropdown(type, "selectByIndex", option, accessName);
	}

	// select option by text/value from multiselect
	@Then("^user selects \"(.*?)\" option by (.+) from multiselect dropdown having (.+) \"(.*?)\"$")
	public void select_option_from_multiselect_dropdown(String option, String optionBy, String type, String accessName)
			throws Exception {
		miscmethodObj.validateLocator(type);
		miscmethodObj.validateOptionBy(optionBy);
		browserObj.selectOptionFromDropdown(type, optionBy, option, accessName);
	}

	// select option by index from multiselect
	@Then("^user selects (\\d+) option by index from multiselect dropdown having (.+) \"(.*?)\"$")
	public void select_option_from_multiselect_dropdown_by_index(String option, String type, String accessName)
			throws Exception {
		miscmethodObj.validateLocator(type);
		browserObj.selectOptionFromDropdown(type, "selectByIndex", option, accessName);
	}

	// deselect option by text/value from multiselect
	@Then("^I deselect \"(.*?)\" option by (.+) from multiselect dropdown having (.+) \"(.*?)\"$")
	public void deselect_option_from_multiselect_dropdown(String option, String optionBy, String type,
			String accessName) throws Exception {
		miscmethodObj.validateLocator(type);
		miscmethodObj.validateOptionBy(optionBy);
		browserObj.deselectOptionFromDropdown(type, optionBy, option, accessName);
	}

	// deselect option by index from multiselect
	@Then("^I deselect (\\d+) option by index from multiselect dropdown having (.+) \"(.*?)\"$")
	public void deselect_option_from_multiselect_dropdown_by_index(String option, String type, String accessName)
			throws Exception {
		miscmethodObj.validateLocator(type);
		browserObj.deselectOptionFromDropdown(type, "selectByIndex", option, accessName);
	}

	// step to unselect option from mutliselect dropdown list
	@Then("^I deselect all options from multiselect dropdown having (.+) \"(.*?)\"$")
	public void unselect_all_option_from_multiselect_dropdown(String type, String accessName) throws Exception {
		miscmethodObj.validateLocator(type);
		browserObj.unselectAllOptionFromMultiselectDropdown(type, accessName);
	}

	// check checkbox steps
	@Then("^I check the checkbox having (.+) \"(.*?)\"$")
	public void check_checkbox(String type, String accessName) throws Exception {
		miscmethodObj.validateLocator(type);
		browserObj.checkCheckbox(type, accessName);
	}

	// uncheck checkbox steps
	@Then("^I uncheck the checkbox having (.+) \"(.*?)\"$")
	public void uncheck_checkbox(String type, String accessName) throws Exception {
		miscmethodObj.validateLocator(type);
		browserObj.uncheckCheckbox(type, accessName);
	}

	// steps to toggle checkbox
	@Then("^I toggle checkbox having (.+) \"(.*?)\"$")
	public void toggle_checkbox(String type, String accessName) throws Exception {
		miscmethodObj.validateLocator(type);
		browserObj.toggleCheckbox(type, accessName);
	}

	// step to select radio button
	@Then("^user selects radio button having (.+) \"(.*?)\"$")
	public void select_radio_button(String type, String accessName) throws Exception {
		miscmethodObj.validateLocator(type);
		browserObj.selectRadioButton(type, accessName);
	}

	// steps to select option by text from radio button group
	@Then("^user selects \"(.*?)\" option by (.+) from radio button group having (.+) \"(.*?)\"$")
	public void select_option_from_radio_btn_group(String option, String by, String type, String accessName)
			throws Exception {
		miscmethodObj.validateLocator(type);
		browserObj.selectOptionFromRadioButtonGroup(type, option, by, accessName);
	}

	// Click element Steps

	// click on web element
	@Then("^user clicks on element having (.+) \"(.*?)\"$")
	public void click(String type, String accessName) throws Exception {
		miscmethodObj.validateLocator(type);
		browserObj.click(type, accessName);
	}

	// Forcefully click on element
	@Then("^I forcefully click on element having (.+) \"(.*?)\"$")
	public void click_forcefully(String type, String accessName) throws Exception {
		miscmethodObj.validateLocator(type);
		browserObj.clickForcefully(type, accessName);
	}

	// double click on web element
	@Then("^I double click on element having (.+) \"(.*?)\"$")
	public void double_click(String type, String accessValue) throws Exception {
		miscmethodObj.validateLocator(type);
		browserObj.doubleClick(type, accessValue);
	}

	// steps to click on link
	@Then("^user clicks on link having text \"(.*?)\"$")
	public void click_link(String accessName) {
		browserObj.click("linkText", accessName);
	}

	// Step to click on partial link
	@Then("^user clicks on link having partial text \"(.*?)\"$")
	public void click_partial_link(String accessName) {
		browserObj.click("partialLinkText", accessName);
	}

	// Progress methods

	// wait for specific period of time
	@Then("^user waits for (\\d+) sec$")
	public void wait(String time) throws NumberFormatException, InterruptedException {
		browserObj.wait(time);
	}

	// wait for specific element to display for specific period of time
	@Then("^user waits (\\d+) seconds for element having (.+) \"(.*?)\" to display$")
	public void wait_for_ele_to_display(String duration, String type, String accessName) throws Exception {
		miscmethodObj.validateLocator(type);
		browserObj.waitForElementToDisplay(type, accessName, duration);
	}

	// wait for specific element to enable for specific period of time
	@Then("^user waits (\\d+) seconds for element having (.+) \"(.*?)\" to be enabled$")
	public void wait_for_ele_to_click(String duration, String type, String accessName) throws Exception {
		miscmethodObj.validateLocator(type);
		browserObj.waitForElementToClick(type, accessName, duration);
	}

	// JavaScript handling steps

	// Step to handle java script
	@Then("^user accepts alert$")
	public void handle_alert() {
		browserObj.handleAlert("accept");
	}

	// Steps to dismiss java script
	@Then("^user dismiss alert$")
	public void dismiss_alert() {
		browserObj.handleAlert("dismiss");
	}

	// Configuration steps

	// step to print configuration
	@Then("^I print configuration$")
	public void print_config() {
		browserObj.printDesktopConfiguration();
	}
}
