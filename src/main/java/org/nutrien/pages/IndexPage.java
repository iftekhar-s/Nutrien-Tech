package org.nutrien.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class IndexPage {
    private WebDriver driver;
    private By pageLinks = By.cssSelector("#content ul li a");

    public IndexPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickPageLink(String pageName) {
        List<WebElement> links = driver.findElements(pageLinks);
        links.stream()
                .filter(link -> link.getText().trim().equals(pageName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Link not found: " + pageName))
                .click();
    }
}
