package com.actum.interview.pageobjects.panel;

import com.actum.interview.pageobjects.element.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class MenuPanel {

    private static final int LOGIN_WAIT_TIMEOUT = 5;

    private interface Locators {
        interface Id {
            String SIGNUP_LINK = "signin2";
            String LOGIN_LINK = "login2";
            String LOGOUT_LINK = "logout2";
            String WELCOME_LINK = "nameofuser";
        }
        interface XPath {
            String HOME_LINK = "//div[@id='navbarExample']//a[starts-with(text(),'Home')]";
            String CART_LINK = "//div[@id='navbarExample']//a[text()='Cart']";
        }
    }

    private final WebDriver driver;

    public MenuPanel(WebDriver driver) {
        this.driver = driver;
    }

    public Link homeLink() {
        return new Link(driver.findElement(By.xpath(Locators.XPath.HOME_LINK)));
    }

    public Link signupLink() {
        return new Link(driver.findElement(By.id(Locators.Id.SIGNUP_LINK)));
    }

    public Link loginLink() {
        return new Link(driver.findElement(By.id(Locators.Id.LOGIN_LINK)));
    }

    public Link logoutLink() {
        return new Link(driver.findElement(By.id(Locators.Id.LOGOUT_LINK)));
    }

    public Link welcomeLink() {
        return new Link(driver.findElement(By.id(Locators.Id.WELCOME_LINK)));
    }

    public Link cartLink() {
        return new Link(driver.findElement(By.xpath(Locators.XPath.CART_LINK)));
    }

    public void waitForLogIn() {
        WebElement loginLink = driver.findElement(By.id(Locators.Id.LOGIN_LINK));
        new WebDriverWait(driver, Duration.ofSeconds(LOGIN_WAIT_TIMEOUT)).until(
                stalenessOf(loginLink)
        );
        new WebDriverWait(driver, Duration.ofSeconds(LOGIN_WAIT_TIMEOUT)).until(
                presenceOfElementLocated(By.id(Locators.Id.WELCOME_LINK))
        );
        new WebDriverWait(driver, Duration.ofSeconds(LOGIN_WAIT_TIMEOUT)).until(
                visibilityOfElementLocated(By.id(Locators.Id.WELCOME_LINK))
        );
    }

}
