package cucumber_runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Generic to execute dry Run
 * <p>
 * command line usage:
 * <p>
 * mvn clean -q -U install -Dtest=GenericRunner -DfailIfNoTests=false
 * -Denv=ENVIRONMENT -Ddevice=DEVICE -Dcucumber.options= "--tags @TAG_NAME"
 *
 * @author Iain Macdonald
 */
@CucumberOptions(plugin = { "pretty", "html:target/cucumber/cucumber-html-report",
		"json:target/cucumber/cucumber-json-report.json" }, monochrome = true, features = "src/test/resources/cucumber/features", glue = {
				"stepdefs" })
@RunWith(Cucumber.class)
public class GenericRunner {
}