package com.actum.interview.pageobjects.page;

import com.actum.interview.pageobjects.panel.LoginFormPanel;
import com.actum.interview.pageobjects.panel.MenuPanel;
import com.actum.interview.pageobjects.panel.SignupFormPanel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

abstract class AbstractPage implements Page {

    private static final int ALERT_WAIT_TIMEOUT = 5;

    protected final WebDriver driver;
    private boolean isClosed = false;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public MenuPanel menuPanel() {
        return new MenuPanel(driver);
    }

    public SignupFormPanel signupForm() {
        return new SignupFormPanel(driver);
    }

    public LoginFormPanel loginForm() {
        return new LoginFormPanel(driver);
    }

    public DemoblazeHomePage gotoHomepage() {
        menuPanel().homeLink().click();
        return DemoblazeHomePage.getInstance();
    }

    public CartPage gotoCart() {
        menuPanel().cartLink().click();
        CartPage cartPage = new CartPage(driver);
        cartPage.cartPanel().waitForLoad();
        return cartPage;
    }

    public String acceptAlert() {
        new WebDriverWait(driver, Duration.ofSeconds(ALERT_WAIT_TIMEOUT)).until(ExpectedConditions.alertIsPresent());
        String text = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return text;
    }

    public void quit() {
        isClosed = true;
        driver.quit();
    }

    public boolean isClosed() {
        return isClosed;
    }

}
