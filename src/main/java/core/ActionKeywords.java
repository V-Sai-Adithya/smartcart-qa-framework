package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActionKeywords {

    private WebDriver driver;

    public ActionKeywords(WebDriver driver) {
        this.driver = driver;
    }

    public void perform(String action, String locatorType, String locatorValue, String testDataKey) {

        By locator = getLocator(locatorType, locatorValue);
        String testData = testDataKey != null && !testDataKey.isEmpty() ? ExcelUtils.getUserData(testDataKey) : "";

        switch (action.toLowerCase()) {
            case "click":
                driver.findElement(locator).click();
                break;

            case "type":
                driver.findElement(locator).clear();
                driver.findElement(locator).sendKeys(testData);
                break;

            case "validate":
                boolean visible = driver.findElement(locator).isDisplayed();
                if (!visible) {
                    throw new AssertionError("Validation failed. Element not visible: " + locatorValue);
                }
                break;

            default:
                throw new IllegalArgumentException("Invalid action: " + action);
        }
    }

    private By getLocator(String type, String value) {
        return switch (type.toLowerCase()) {
            case "id" -> By.id(value);
            case "name" -> By.name(value);
            case "classname" -> By.className(value);
            case "xpath" -> By.xpath(value);
            case "css" -> By.cssSelector(value);
            case "linktext" -> By.linkText(value);
            case "partiallinktext" -> By.partialLinkText(value);
            default -> throw new IllegalArgumentException("Invalid locator type: " + type);
        };
    }
}
