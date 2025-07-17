package org.nutrien.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasicAuthPage {
    private final WebDriver driver;
    private final By message = By.cssSelector(".example p");

    public BasicAuthPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUp(String username, String password) {
        driver.get("https://" + username + ":" + password +
                "@the-internet.herokuapp.com/basic_auth");
    }

    public String getMessageText() {
        return driver.findElement(message).getText();
    }
}