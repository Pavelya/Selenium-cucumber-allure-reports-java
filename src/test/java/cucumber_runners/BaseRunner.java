package cucumber_runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.qa.tlv.utilities.reports.AllureReportConfigurationSetup;

/**
 * Runner to execute casino tests
 * 
 * command line usage:
 * 
 * mvn clean -q -U install -Dtest=BasetRunner -DfailIfNoTests=false
 * -Denv=ENVIRONMENT -Ddevice=DEVICE -Dcucumber.options= "--tags @TAG_NAME"
 * 
 * @author Pavel Yampolsky
 *
 */

@CucumberOptions(plugin = { "pretty",

		"html:target/cucumber/cucumber-html-report",

		"json:target/cucumber/cucumber-json-report.json"

}, dryRun = false, monochrome = true,

		tags = "@Q",

		features = "src/test/resources/features", glue = { "stepdefs" })
@RunWith(Cucumber.class)
public class BaseRunner {


@BeforeClass()
public static void runTomcat() throws Exception {

	// prepare reports folder
	AllureReportConfigurationSetup.prepareAllureResultsFolder();
}
}