package org.nutrien.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {
    private final WebDriver driver;
    private final By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    public void selectOption(String optionText) {
        WebElement dropdownElement = driver.findElement(dropdown);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(optionText);
    }

    public String getSelectedOption() {
        WebElement dropdownElement = driver.findElement(dropdown);
        Select dropdown = new Select(dropdownElement);
        return dropdown.getFirstSelectedOption().getText();
    }
}
