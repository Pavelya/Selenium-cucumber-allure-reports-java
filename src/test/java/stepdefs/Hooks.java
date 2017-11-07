package stepdefs;

import java.io.IOException;

import com.qa.tlv.environment.BaseTest;
import com.qa.tlv.logger.Log;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks implements BaseTest {

	@After()
	public void afterScenario(Scenario scenario) throws IOException {

		if (scenario.isFailed()) {
			Log.ERROR("Scenario: " + scenario.getName() + " failed");
			browserObj.takeScreenShot();
			browserObj.attachSnapshotToReport();
		} else {
			Log.INFO("Scenario: " + scenario.getName() + " passed");
		}

		browserObj.closeDriver();

	}

	@Before()
	public void beforeScenario(Scenario scenario) throws IOException {

		Log.INFO("Scenario: " + scenario.getName() + " started");

	}
}
