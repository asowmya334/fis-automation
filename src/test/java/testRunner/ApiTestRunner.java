package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
        (features = "src/test/APIAutomation/feature",
        glue = {"ApiAutomation/StepDefinition", "ApiAutomation/Util"},
        plugin = {"pretty","html:target/cucumberReport/cucumber.html"})
public class ApiTestRunner extends AbstractTestNGCucumberTests {
}