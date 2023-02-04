package com.actum.interview.pageobjects.element;

import org.openqa.selenium.WebElement;

public class AbstractElement {
    protected final WebElement element;

    protected AbstractElement(WebElement element) {
        this.element = element;
    }

    public void click() {
        element.click();
    }

    public String text() {
        return element.getText();
    }

    public boolean isDisplayed() {
        return element.isDisplayed();
    }

}
