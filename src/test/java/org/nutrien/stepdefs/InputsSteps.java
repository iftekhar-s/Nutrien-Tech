package org.nutrien.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.nutrien.pages.InputsPage;
import org.nutrien.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class InputsSteps {
    private WebDriver driver;
    private final InputsPage inputsPage;
    private final LoginPage loginPage;

    public InputsSteps(InputsPage inputsPage, LoginPage loginPage) {
        this.inputsPage = inputsPage;
        this.loginPage = loginPage;
    }

    @Given("I am on the inputs page")
    public void i_am_on_the_inputs_page() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        loginPage.open();
        loginPage.login("username", "password");
    }

    @When("I enter {string}")
    public void i_enter(String number) {
        inputsPage.enterNumber(number);
    }

    @Then("The input value should be the number I entered")
    public void the_input_value_should_be(String expectedNumber) {
        String actualNumber = inputsPage.getInputValue();
        Assert.assertEquals(actualNumber, expectedNumber,
                "Expected: " + expectedNumber + " but got: " + actualNumber);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
