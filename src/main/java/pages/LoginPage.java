package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    // Locators
    private By loginLink = By.linkText("Signup / Login");
    private By emailInput = By.name("email");
    private By passwordInput = By.name("password");
    private By loginButton = By.xpath("//button[text()='Login']");
    private By logoutLink = By.linkText("Logout");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions with Allure steps

    @Step("Click on 'Signup / Login' link")
    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

    @Step("Enter email: {0}")
    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    @Step("Enter password: {0}")
    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    @Step("Click on 'Login' button")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Check if logout link is visible")
    public boolean isLogoutVisible() {
        return driver.findElement(logoutLink).isDisplayed();
    }

    @Step("Perform login with email: {0} and password: {1}")
    public void login(String email, String password) {
        clickLoginLink();
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }
}
