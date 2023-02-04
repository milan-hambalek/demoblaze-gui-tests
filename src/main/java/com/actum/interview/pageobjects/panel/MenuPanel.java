package com.actum.interview.pageobjects.panel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.actum.interview.pageobjects.element.Link;

public class MenuPanel {

    private interface Locators {
        interface Id {
            String SIGNUP_LINK = "signin2";
            String LOGIN_LINK = "login2";
        }
    }

    private final WebDriver driver;

    public MenuPanel(WebDriver driver) {
        this.driver = driver;
    }

    public Link signupLink() {
        return new Link(driver.findElement(By.id(Locators.Id.SIGNUP_LINK)));
    }

    public Link loginLink() {
        return new Link(driver.findElement(By.id(Locators.Id.LOGIN_LINK)));
    }

}
