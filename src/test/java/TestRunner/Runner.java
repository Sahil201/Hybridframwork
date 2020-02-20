package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = ".//Features/customers.feature",
        glue = "stepdefinitions",
        dryRun = false,
        plugin = {"pretty","html:test-output"}
        )

public class Runner {

}
