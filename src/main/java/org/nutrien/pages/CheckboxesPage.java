package org.nutrien.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxesPage {
    private final WebDriver driver;

    public CheckboxesPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getCheckbox(int num) {
        return driver.findElement(By.xpath("(//input[@type='checkbox'])[" + num + "]"));
    }

    public void selectCheckbox(int num) {
        WebElement checkbox = getCheckbox(num);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public boolean isCheckboxSelected(int num) {
        return getCheckbox(num).isSelected();
    }
}