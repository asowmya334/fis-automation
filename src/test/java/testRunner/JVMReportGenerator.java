package testRunner;


import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JVMReportGenerator {
    public static void generateJVMReport(String jsonFilePath) {
            File reportOutputDirectory = new File("target/jvm-reports");

            // Create the folder if it does not exist
            if (!reportOutputDirectory.exists()) {
                reportOutputDirectory.mkdirs();
            }

            // Set up the configuration
            Configuration configuration = new Configuration(reportOutputDirectory, "eBay Automation Suite");
            configuration.addClassifications("Platform", "Windows");
            configuration.addClassifications("Browser", "Chrome");
            configuration.addClassifications("Environment", "QA");

            // JSON file(s) to generate the report
            List<String> jsonFiles = new ArrayList<>();
            jsonFiles.add(jsonFilePath);

            // Build the report
            ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
            reportBuilder.generateReports();
        }
    }
