package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",         // Path to feature files
        glue = {"stepdefs"},                              // Step definition package
        plugin = {
                "pretty",                                 // Console logs
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", // Allure results
                "html:target/cucumber-reports.html",      // HTML report
                "json:target/cucumber.json",              // JSON for Jenkins/Allure plugin
                "junit:target/cucumber.xml"               // Optional: xUnit format for Jenkins plugins
        },
        monochrome = true                                 // Readable console output
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
