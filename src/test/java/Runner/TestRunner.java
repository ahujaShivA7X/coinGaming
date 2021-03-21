package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/Features",
        plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json",
                "junit:target/cucumber-reports/Cucumber.xml",
                "html:target/cucumber-reports",
                "com.cucumber.listener.ExtentCucumberFormatter:output/report.html"},
        monochrome = true,
        glue = "StepDefinition"
)

public class TestRunner {
}
