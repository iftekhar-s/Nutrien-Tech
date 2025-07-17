package org.nutrien.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.nutrien.pages.DropdownPage;
import org.nutrien.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DropdownSteps {
    private WebDriver driver;
    private final DropdownPage dropdownPage;
    private final LoginPage loginPage;

    public DropdownSteps(LoginPage loginPage, DropdownPage dropdownPage) {
        this.loginPage = loginPage;
        this.dropdownPage = dropdownPage;
    }

    @Given("I am on the Dropdown page")
    public void i_am_on_the_dropdown_page() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        loginPage.open();
        loginPage.login("username", "password");
    }

    @When("I select {string}")
    public void i_select(String option) {
        dropdownPage.selectOption(option);
    }

    @Then("The dropdown value should be {string}")
    public void the_dropdown_value_should_be(String expectedOption) {
        String actualOption = dropdownPage.getSelectedOption();
        Assert.assertEquals(actualOption, expectedOption,
                "Expected option: " + expectedOption + " but got: " + actualOption);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
