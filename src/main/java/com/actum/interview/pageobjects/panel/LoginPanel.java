package com.actum.interview.pageobjects.panel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.actum.interview.pageobjects.element.Button;
import com.actum.interview.pageobjects.element.Input;

public class LoginPanel {

    private interface Locators {
        interface Css {
            String USERNAME_INPUT = "#logInModal #loginusername";
            String PASSWORD_INPUT = "#logInModal #loginpassword";
        }

        interface Xpath {
            String LOGIN_BUTTON = "//div[@id='logInModal']//button[@onclick='logIn()']";
        }
    }

    private final WebDriver driver;

    public LoginPanel(WebDriver driver) {
        this.driver = driver;
    }

    public Input usernameInput() {
        return new Input(driver.findElement(By.cssSelector(Locators.Css.USERNAME_INPUT)));
    }

    public Input passwordInput() {
        return new Input(driver.findElement(By.cssSelector(Locators.Css.PASSWORD_INPUT)));
    }

    public Button loginButton() {
        return new Button(driver.findElement(By.xpath(Locators.Xpath.LOGIN_BUTTON)));
    }

}
