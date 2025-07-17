package org.nutrien.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.nutrien.pages.BasicAuthPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class BasicAuthSteps {

    WebDriver driver;

    private BasicAuthPage basicAuthPage;

    @Given("I am on the basic auth page")
    public void i_am_on_the_basic_auth_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        basicAuthPage = new BasicAuthPage(driver);
    }

    @When("I use basic auth to login with {string} and {string}")
    public void i_use_basic_auth_to_login(String username, String password) {
        basicAuthPage.setUp(username, password);
    }

    @Then("I should see a paragraph saying {string}")
    public void i_should_see_message(String expectedMessage) {
        String actualMessage = basicAuthPage.getMessageText();
        Assert.assertTrue(actualMessage.contains(expectedMessage),
                "Expected: " + expectedMessage + " but got: " + actualMessage);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}