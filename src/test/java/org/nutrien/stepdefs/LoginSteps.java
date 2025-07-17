package org.nutrien.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.nutrien.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        loginPage.open();
    }

    @When("I login with {string} and {string}")
    public void i_login_with_and(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("I should see a flash message saying {string}")
    public void i_should_see_a_flash_message_saying(String expectedMessage) {
        String actualMessage = loginPage.getFlashMessage();
        // Using contains() because flash message includes "×" close button
        Assert.assertTrue(actualMessage.contains(expectedMessage),
                "Expected message: '" + expectedMessage +
                        "' but got: '" + actualMessage + "'");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
