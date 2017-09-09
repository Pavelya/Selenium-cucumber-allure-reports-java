package cucumber_runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Runner to casino mobile tests with rerun support This runner populates test
 * file with failed tests
 * 
 * command line usage:
 * 
 * mvn clean -q -U install -Dtest=RerunPopulationRunner -DfailIfNoTests=false
 * -Denv=pp1 -Ddevice=iPhone6Emulator -Dcucumber.options= "--tags @TAG_NAME"
 * 
 * after_test_format_rerun_file tag should be executed before rerun using
 *                               RerunExecutionRunner
 * 
 * @author Pavel Yampolsky
 *
 */

@CucumberOptions(plugin = { "pretty",

		"html:target/cucumber/cucumber-html-report",

		"json:target/cucumber/cucumber-json-report.json",

		"rerun:target/rerun.txt"

}, dryRun = false, monochrome = true,

tags = "@functional_tests_casino_balance",

features = "src/test/resources/cucumber/features", glue = { "stepdefs" })
@RunWith(Cucumber.class)
public class RerunPopulationRunner {
}
