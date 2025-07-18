package stepdefs;

import core.DriverFactory;
import core.ExcelUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class Hooks {

    public static WebDriver driver;

    @Step("Setting up WebDriver and test configuration")
    @Before
    public void setUp() {
        try {
            driver = DriverFactory.initDriver();
            driver.get("https://automationexercise.com");

            ExcelUtils.loadExcel("src/test/resources/config/TestSuite.xlsx");
            ExcelUtils.loadUserProperties("src/test/resources/config/user-data.properties");

        } catch (Exception e) {
            System.err.println("❌ Failed during test setup: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Step("Tearing down WebDriver session after scenario")
    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    // Accessor for driver from StepDefs
    public static WebDriver getDriver() {
        return driver;
    }
}
