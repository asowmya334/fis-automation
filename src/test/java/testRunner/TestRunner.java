package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;

@CucumberOptions
        (features = "src/test/eBayFeature/Feature",
        glue = {"eBayProject/StepDefinition", "eBayProject/Util"},
        plugin = {"pretty","html:target/cucumberReport/cucumber.html", "json:target/cucumber-reports/cucumber.json"},
                monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {
    @AfterSuite
    public void generateJVMReport() {
        // Path to the generated JSON report
        String jsonFilePath = "target/cucumber-reports/cucumber.json";

        // Generate the JVM report
        JVMReportGenerator.generateJVMReport(jsonFilePath);
    }
}