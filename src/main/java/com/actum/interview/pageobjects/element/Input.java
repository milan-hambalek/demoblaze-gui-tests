package com.actum.interview.pageobjects.element;

import org.openqa.selenium.WebElement;

public class Input extends AbstractElement {
    public Input(WebElement element) {
        super(element);
    }

    public void type(CharSequence... input) {
        element.sendKeys(input);
    }

}
