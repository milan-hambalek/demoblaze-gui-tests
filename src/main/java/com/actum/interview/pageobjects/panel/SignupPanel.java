package com.actum.interview.pageobjects.panel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.actum.interview.pageobjects.element.Button;
import com.actum.interview.pageobjects.element.Input;

public class SignupPanel {

    private interface Locators {
        interface Css {
            String USERNAME_INPUT = "#signInModal #sign-username";
            String PASSWORDE_INPUT = "#signInModal #sign-password";
        }

        interface Xpath {
            String SIGNUP_BUTTON = "//div[@id='signInModal']//button[@onclick='register()']";
        }
    }

    private final WebDriver driver;

    public SignupPanel(WebDriver driver) {
        this.driver = driver;
    }

    public Input usernameInput() {
        return new Input(driver.findElement(By.cssSelector(Locators.Css.USERNAME_INPUT)));
    }

    public Input passwordInput() {
        return new Input(driver.findElement(By.cssSelector(Locators.Css.PASSWORDE_INPUT)));
    }

    public Button signupButton() {
        return new Button(driver.findElement(By.xpath(Locators.Xpath.SIGNUP_BUTTON)));
    }

}
