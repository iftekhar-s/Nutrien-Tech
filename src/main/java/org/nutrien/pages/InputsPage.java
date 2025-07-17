package org.nutrien.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InputsPage {
    private WebDriver driver;
    private By inputField = By.tagName("input");

    public InputsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUp() {
        driver.get("https://the-internet.herokuapp.com/inputs");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(inputField));
    }

    public void enterNumber(String number) {
        WebElement input = driver.findElement(inputField);
        input.clear();
        input.sendKeys(number);
    }

    public String getInputValue() {
        return driver.findElement(inputField).getAttribute("value");
    }
}
