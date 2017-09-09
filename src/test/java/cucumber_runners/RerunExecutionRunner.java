package cucumber_runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Runner to casino mobile tests with rerun support This runner runs failed test
 * again
 * 
 * command line usage:
 * 
 * mvn clean -q -U install -Dtest=RerunExecutionRunner -DfailIfNoTests=false
 * -Denv=pp1 -Ddevice=iPhone6Emulator -Dcucumber.options= "--tags @TAG_NAME"
 * 
 * @author Pavel Yampolsky
 *
 */

@CucumberOptions(plugin = { "pretty",

		"html:target/cucumber/cucumber-html-report",

		"json:target/cucumber/cucumber-json-report.json",

		"rerun:target/rerun.txt"

}, dryRun = false, monochrome = true,

features = "@target/rerun.txt",

glue = { "stepdefs" })
@RunWith(Cucumber.class)
public class RerunExecutionRunner {
}
