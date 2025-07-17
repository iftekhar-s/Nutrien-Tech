package org.nutrien.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.nutrien.pages.IndexPage;
import org.nutrien.pages.LoginPage;
import org.nutrien.pages.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class IndexSteps {

    private WebDriver driver;
    private final IndexPage indexPage;
    private final LoginPage loginPage;

    public IndexSteps(LoginPage loginPage, IndexPage indexPage1) {
        this.loginPage = loginPage;
        this.indexPage = indexPage1;
    }

    @Given("I am at the index page")
    public void i_am_at_the_index_page() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        loginPage.open();
        loginPage.login("username", "password");
    }

    @When("I click the {string} link")
    public void i_click_the_link(String pageName) {
        indexPage.clickPageLink(pageName);
    }

    @Then("I should be directed to the selected page")
    public void i_should_be_directed_to_the_selected_page(String pageName) {
        String expectedUrl = Pages.getExpectedUrl(pageName);
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl,
                "Expected URL: " + expectedUrl + " but got: " + actualUrl);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}