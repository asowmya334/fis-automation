package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
        (features = "src/test/eBayFeature/Feature",
        glue = {"eBayProject/StepDefinition", "eBayProject/Util"},
        plugin = {"pretty","html:target/cucumberReport/cucumber.html"})
public class TestRunner extends AbstractTestNGCucumberTests {
}