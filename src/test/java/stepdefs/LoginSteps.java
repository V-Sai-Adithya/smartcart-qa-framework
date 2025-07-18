package stepdefs;

import core.ExcelUtils;
import io.cucumber.java.en.*;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import static org.testng.AssertJUnit.assertTrue;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;

    @Step("User launches the application and initializes driver and login page")
    @Given("User launches the application")
    public void user_launches_the_application() {
        driver = Hooks.getDriver();
        loginPage = new LoginPage(driver);
    }

    @Step("User clicks on 'Signup / Login' link")
    @When("User clicks on Login link")
    public void user_clicks_on_login_link() {
        loginPage.clickLoginLink();
    }

    @Step("User enters username key: {0} and password key: {1} (fetched from Excel)")
    @And("User enters username {string} and password {string}")
    public void user_enters_credentials(String usernameKey, String passwordKey) {
        String username = ExcelUtils.getUserData(usernameKey);
        String password = ExcelUtils.getUserData(passwordKey);
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
    }

    @Step("User clicks on 'Login' button")
    @And("User clicks on Login button")
    public void user_clicks_on_login_button() {
        loginPage.clickLoginButton();
    }

    @Step("User verifies the presence of Logout link to confirm login success")
    @Then("User should see Logout link")
    public void user_should_see_logout_link() {
        assertTrue("Logout link not found — login might have failed!", loginPage.isLogoutVisible());
    }
}
