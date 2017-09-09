package methods;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.qa.tlv.environment.BaseTest;
import com.qa.tlv.logger.Log;

public class AssertionMethods extends SelectElementByType implements BaseTest {
	// This file contains assertion methods which are called from
	// predefinedStepDefinitions

	// SelectElementByType eleType= new SelectElementByType();
	private WebElement element = null;

	/**
	 * Method to get page title
	 * 
	 * @return String
	 */
	public String getPageTitle() {
		return driver.getTitle();
	}

	/**
	 * Method to verify page title
	 * 
	 * @param title
	 *            : String : expected title
	 */
	public void checkTitle(String title) throws TestCaseFailed {
		String pageTitle = getPageTitle();

		if (!pageTitle.equals(title)) {
			throw new TestCaseFailed(
					"Page Title Not Matched, Expected Title: " + title + ", Actual Page Title : " + pageTitle);
		} else {
			Log.INFO("Page Title Matched, Actual Page Title : " + pageTitle);
		}

	}

	/**
	 * Method to verify partial page title
	 * 
	 * @param partialTitle
	 *            : String : partial title string
	 */
	public void checkPartialTitle(String partialTitle) throws TestCaseFailed {
		String pageTitle = getPageTitle();

		if (!pageTitle.contains(partialTitle)) {
			throw new TestCaseFailed(
					"Partial Page Title: " + partialTitle + " Not Present, Actual Page Title : " + pageTitle);
		} else {
			Log.INFO("Page Title Matched, Actual Page Title : " + pageTitle);
		}
	}

	/**
	 * Method to get element text
	 * 
	 * @param accessType
	 *            : String : Locator type (id, name, class, xpath, css)
	 * @param accessName
	 *            : String : Locator value
	 * @return String
	 */
	public String getElementText(String accessType, String accessName) {
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		return element.getText();

	}

	/**
	 * Method to check element text
	 * 
	 * @param accessType
	 *            : String : Locator type (id, name, class, xpath, css)
	 * @param actualValue
	 *            : String : Expected element text
	 * @param accessName
	 *            : String : Locator value
	 */
	public void checkElementText(String accessType, String actualValue, String accessName) throws TestCaseFailed {
		String elementText = getElementText(accessType, accessName);

		if (!elementText.equals(actualValue)) {
			throw new TestCaseFailed("Expected Text: " + actualValue + " Not Matched the Actual One: " + elementText);
		} else {
			Log.INFO("Text Matched");
		}
	}

	/**
	 * Method to check partial element text
	 * 
	 * @param accessType
	 *            : String : Locator type (id, name, class, xpath, css)
	 * @param actualValue
	 *            : String : Expected element text
	 * @param accessName
	 *            : String : Locator value
	 */
	public void checkElementPartialText(String accessType, String actualValue, String accessName)
			throws TestCaseFailed {
		String elementText = getElementText(accessType, accessName);

		if (!elementText.contains(actualValue)) {
			throw new TestCaseFailed("Expected Text: " + actualValue + " Not Matched The Actual One: " + elementText);
		} else {
			Log.INFO("Text Matched");
		}
	}

	/**
	 * Method to return element status - enabled?
	 * 
	 * @param accessType
	 *            : String : Locator type (id, name, class, xpath, css)
	 * @param accessName
	 *            : String : Locator value
	 * @return Boolean
	 */
	public boolean isElementEnabled(String accessType, String accessName) {
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		return element.isEnabled();
	}

	/**
	 * Element enabled checking
	 * 
	 * @param accessType
	 *            : String : Locator type (id, name, class, xpath, css)
	 * @param accessName
	 *            : String : Locator value
	 */
	public void checkElementEnable(String accessType, String accessName) throws TestCaseFailed {
		boolean result = isElementEnabled(accessType, accessName);
		if (!result) {
			throw new TestCaseFailed("Element: " + accessName + " Not Enabled");
		} else {
			Log.INFO("Element Enabled");
		}
	}

	/**
	 * method to get attribute value
	 * 
	 * @param accessType
	 *            : String : Locator type (id, name, class, xpath, css)
	 * @param accessName
	 *            : String : Locator value
	 * @param attributeName
	 *            : String : attribute name
	 * @return String
	 */
	public String getElementAttribute(String accessType, String accessName, String attributeName) {
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		return element.getAttribute(attributeName);
	}

	/**
	 * method to check attribute value
	 * 
	 * @param accessType
	 *            : String : Locator type (id, name, class, xpath, css)
	 * @param attributeName
	 *            : String : attribute name
	 * @param attributeValue
	 *            : String : attribute value
	 * @param accessName
	 *            : String : Locator value
	 */
	public void checkElementAttribute(String accessType, String attributeName, String attributeValue, String accessName)
			throws TestCaseFailed {
		String attrVal = getElementAttribute(accessType, accessName, attributeName);
		if (!attrVal.equals(attributeValue)) {
			throw new TestCaseFailed(
					"Actual Attribute Value: " + attrVal + " Not Matched The Expected One: " + attributeValue);
		} else {
			Log.INFO("Attribute Value Matched");
		}
	}

	/**
	 * method to get element status - displayed?
	 * 
	 * @param accessType
	 *            : String : Locator type (id, name, class, xpath, css)
	 * @param accessName
	 *            : String : Locator value
	 * @return Boolean
	 */
	public boolean isElementDisplayed(String accessType, String accessName) {
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		return element.isDisplayed();
	}

	/**
	 * method to check element presence
	 * 
	 * @param accessType
	 *            : String : Locator type (id, name, class, xpath, css)
	 * @param accessName
	 *            : String : Locator value
	 */
	public void checkElementPresence(String accessType, String accessName) throws TestCaseFailed {

		if (!isElementDisplayed(accessType, accessName)) {
			throw new TestCaseFailed("Element: " + accessName + " Not Presented");
		} else

		{
			Log.INFO("Element Present");
		}
	}

	/**
	 * method to check element not presence
	 * 
	 * @param accessType
	 *            : String : Locator type (id, name, class, xpath, css)
	 * @param accessName
	 *            : String : Locator value
	 */
	public void checkElementNotDisplayed(String accessType, String accessName) throws TestCaseFailed {

		if (isElementDisplayed(accessType, accessName)) {
			throw new TestCaseFailed("Element: " + accessName + " Presented");
		} else

		{
			Log.INFO("Element Not Presented");
		}
	}

	/**
	 * method to assert checkbox check/uncheck
	 * 
	 * @param accessType
	 *            : String : Locator type (id, name, class, xpath, css)
	 * @param accessName
	 *            : String : Locator value
	 * @param shouldBeChecked
	 */
	public void isCheckboxChecked(String accessType, String accessName, boolean shouldBeChecked) throws TestCaseFailed {
		WebElement checkbox = wait
				.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		if ((!checkbox.isSelected()) && shouldBeChecked)
			throw new TestCaseFailed("Checkbox is not checked");
		else if (checkbox.isSelected() && !shouldBeChecked)
			throw new TestCaseFailed("Checkbox is checked");
	}

	/**
	 * method to assert radio button selected/unselected
	 * 
	 * @param accessType
	 *            : String : Locator type (id, name, class, xpath, css)
	 * @param accessName
	 *            : String : Locator value
	 * @param shouldBeChecked
	 */
	public void isRadioButtonSelected(String accessType, String accessName, boolean shouldBeSelected)
			throws TestCaseFailed {
		WebElement radioButton = wait
				.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		if ((!radioButton.isSelected()) && shouldBeSelected)
			throw new TestCaseFailed("Radio Button not selected");
		else if (radioButton.isSelected() && !shouldBeSelected)
			throw new TestCaseFailed("Radio Button is selected");
	}

	// method to assert option from radio button group is selected/unselected
	public void isOptionFromRadioButtonGroupSelected(String accessType, String by, String option, String accessName,
			boolean shouldBeSelected) throws TestCaseFailed {
		List<WebElement> radioButtonGroup = wait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getelementbytype(accessType, accessName)));

		for (WebElement rb : radioButtonGroup) {
			if (by.equals("value")) {
				if (rb.getAttribute("value").equals(option)) {
					if ((!rb.isSelected()) && shouldBeSelected)
						throw new TestCaseFailed("Radio Button not selected");
					else if (rb.isSelected() && !shouldBeSelected)
						throw new TestCaseFailed("Radio Button is selected");
				}
			} else if (rb.getText().equals(option)) {
				if ((!rb.isSelected()) && shouldBeSelected)
					throw new TestCaseFailed("Radio Button not selected");
				else if (rb.isSelected() && !shouldBeSelected)
					throw new TestCaseFailed("Radio Button is selected");
			}
		}
	}

	/**
	 * method to get javascript pop-up alert text
	 * 
	 * @return String
	 */
	public String getAlertText() {
		return driver.switchTo().alert().getText();
	}

	/**
	 * method to check javascript pop-up alert text
	 * 
	 * @param text
	 *            : String : Text to verify in Alert
	 * @throws TestCaseFailed
	 */
	public void checkAlertText(String text) throws TestCaseFailed {
		if (!getAlertText().equals(text))
			throw new TestCaseFailed("Text on alert pop up not matched");
	}

	/**
	 * Method to verify if the particular option is Selected from Dropdown
	 * 
	 * @param accessType
	 *            : String : Locator type (id, name, class, xpath, css)
	 * @param by
	 *            : String : Select element from dropdown by text or value
	 * @param option
	 *            : String : Element to select from dropdown
	 * @param accessName
	 *            : String : Locator value
	 * @param shouldBeSelected
	 * @throws TestCaseFailed
	 */
	public void isOptionFromDropdownSelected(String accessType, String by, String option, String accessName,
			boolean shouldBeSelected) throws TestCaseFailed {
		Select selectList = null;
		WebElement dropdown = wait
				.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		selectList = new Select(dropdown);

		String actualValue = "";
		if (by.equals("text"))
			actualValue = selectList.getFirstSelectedOption().getText();
		else
			actualValue = selectList.getFirstSelectedOption().getAttribute("value");

		if ((!actualValue.equals(option)) && (shouldBeSelected))
			throw new TestCaseFailed("Option Not Selected From Dropwdown");
		else if ((actualValue.equals(option)) && (!shouldBeSelected))
			throw new TestCaseFailed("Option Selected From Dropwdown");
	}
}
