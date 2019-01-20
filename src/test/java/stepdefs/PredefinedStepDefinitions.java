package stepdefs;

import java.io.IOException;

import com.qa.tlv.environment.BaseTest;
import com.qa.tlv.methods.PropertiesManagementMethods;
import com.qa.tlv.methods.SelectorType;
import com.qa.tlv.methods.TestCaseFailed;

import cucumber.api.java.en.Then;

public class PredefinedStepDefinitions implements BaseTest {

    PropertiesManagementMethods props = new PropertiesManagementMethods();

    // Step to navigate to specified URL
    @Then("^user navigates to (.*)$")
    public void navigate_to(String link) throws IOException {
        browser.navigateTo(link);
    }

    // Step to navigate to base URL
    @Then("^user opens base lobby$")
    public void navigate_to_lobby() throws IOException {
        browser.navigateTo(props.getProperty("baseUrl"));
    }

    // Step to navigate forward
    @Then("^user navigates forward")
    public void navigate_forward() {
        browser.navigate("forward");
    }

    // Step to navigate backward
    @Then("^user navigates back")
    public void navigate_back() {
        browser.navigate("back");
    }

    // steps to refresh page
    @Then("^user refresh the page$")
    public void refresh_page() {
        browser.refreshDriver();
    }

    // Switch between windows

    // Switch to new window
    @Then("^user switch to new window$")
    public void switch_to_new_window() {
        browser.switchToNewWindow();
    }

    // Switch to old window
    @Then("^user switch to previous window$")
    public void switch_to_old_window() {
        browser.switchToOldWindow();
    }

    // Switch to new window by window title
    @Then("^user switch to window having title \"(.*?)\"$")
    public void switch_to_window_by_title(String windowTitle) throws Exception {
        browser.switchToWindowByTitle(windowTitle);
    }

    // Close new window
    @Then("^user closes new window$")
    public void close_new_window() {
        browser.closeNewWindow();
    }

    // Switch between frame

    // Step to switch to frame by web element
    @Then("^user switch to frame having (.+) \"(.*?)\"$")
    public void switch_frame_by_element(SelectorType selectorType, String value) {
        browser.switchFrame(selectorType, value);
    }

    // step to switch to main content
    @Then("^user switch to main content$")
    public void switch_to_default_content() {
        browser.switchToDefaultContent();
    }

    // To interact with browser

    // step to resize browser
    @Then("^user resize browser window size to width (\\d+) and height (\\d+)$")
    public void resize_browser(int width, int heigth) {
        browser.resizeBrowser(width, heigth);
    }

    // step to maximize browser
    @Then("^user maximize browser window$")
    public void maximize_browser() {
        browser.maximizeBrowser();
    }

    // scroll webpage

    @Then("^user scroll to (top|end) of page$")
    public void scroll_page(String to) throws Exception {
        browser.scrollPage(to);
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
        browser.checkTitle(title);
    }

    @Then("^user should see page source")
    public void getPageSource() throws TestCaseFailed {
        browser.getPageSource();
    }

    // step to check element partial text
    @Then("^user should\\s*((?:not)?)\\s+see page title having partial text as \"(.*?)\"$")
    public void check_partial_text(String present, String partialTextTitle) throws TestCaseFailed {
        browser.checkPartialTitle(partialTextTitle);
    }

    // step to assert javascript pop-up alert text
    @Then("^user should see alert text as \"(.*?)\"$")
    public void check_alert_text(String actualValue) throws TestCaseFailed {
        browser.checkAlertText(actualValue);
    }

    // step to select dropdown list
    @Then("^option \"(.*?)\" by (.+) from dropdown having (.+) \"(.*?)\" should be (selected|unselected)$")
    public void is_option_from_dropdown_selected(String option, String by, SelectorType selectorType, String accessName,
            String state) throws Exception {

        boolean flag = state.equals("selected");
        browser.isOptionFromDropdownSelected(selectorType, by, option, accessName, flag);
    }

    // Input steps
    // select option by text/value from dropdown
    @Then("^user selects \"(.*?)\" option by (.+) from dropdown having (.+) \"(.*?)\"$")
    public void select_option_from_dropdown(String option, String optionBy, SelectorType selectorType,
            String accessName) throws Exception {
        browser.selectOptionFromDropdown(selectorType, optionBy, option, accessName);
    }

    // Progress methods

    // wait for specific period of time
    @Then("^user waits for (\\d+) sec$")
    public void wait(String time) throws NumberFormatException, InterruptedException {
        browser.wait(time);
    }

    // JavaScript handling steps

    // Step to handle java script
    @Then("^user accepts alert$")
    public void handle_alert() {
        browser.handleAlert("accept");
    }

    // Steps to dismiss java script
    @Then("^user dismiss alert$")
    public void dismiss_alert() {
        browser.handleAlert("dismiss");
    }
}
