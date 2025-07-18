package core;

import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class TestExecutor {

    public static void runTest(String testCaseName) {
        try {
            // Load Excel and user properties
            ExcelUtils.loadExcel("src/test/resources/config/TestSuite.xlsx");
            ExcelUtils.loadUserProperties("src/test/resources/config/user-data.properties");

            if (!ExcelUtils.shouldRunTest(testCaseName)) {
                System.out.println("❌ Skipping Test: " + testCaseName);
                return;
            }

            System.out.println("✅ Running Test: " + testCaseName);

            WebDriver driver = DriverFactory.initDriver();
            driver.get("https://automationexercise.com");

            ActionKeywords ak = new ActionKeywords(driver);
            List<Map<String, String>> steps = ExcelUtils.getTestSteps(testCaseName);

            for (Map<String, String> step : steps) {
                String action = step.getOrDefault("Action", "");
                String locatorType = step.getOrDefault("LocatorType", "");
                String locatorValue = step.getOrDefault("LocatorValue", "");
                String testDataKey = step.getOrDefault("TestDataKey", "");

                System.out.printf("➡️ Step: %s - %s - %s - %s%n", action, locatorType, locatorValue, testDataKey);
                ak.perform(action, locatorType, locatorValue, testDataKey);
            }

            Thread.sleep(2000); // for visibility
            DriverFactory.quitDriver();

        } catch (Exception e) {
            e.printStackTrace();
            DriverFactory.quitDriver();
        }
    }
}
