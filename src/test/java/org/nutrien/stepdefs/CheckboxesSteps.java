package org.nutrien.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.nutrien.pages.CheckboxesPage;
import org.nutrien.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckboxesSteps {

    private WebDriver driver;
    private final CheckboxesPage checkboxesPage;
    private final LoginPage loginPage;

    public CheckboxesSteps(CheckboxesPage checkboxesPage, LoginPage loginPage) {
        this.checkboxesPage = checkboxesPage;
        this.loginPage = loginPage;
    }

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();  // Auto-downloads and configures
        driver = new ChromeDriver();
    }

    @Given("I am on the Checkboxes page")
    public void i_am_on_the_checkboxes_page() {
        loginPage.open();
        loginPage.login("username", "password");
    }
    @When("I select checkbox {int}")
    public void i_select_checkbox(Integer int1) {
        checkboxesPage.selectCheckbox(int1);
    }
    @Then("The checkbox {int} should be checked")
    public void the_checkbox_should_be_checked(Integer int1) {
        Assert.assertTrue(checkboxesPage.isCheckboxSelected(int1),
                "Checkbox " + int1 + " was not selected");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}