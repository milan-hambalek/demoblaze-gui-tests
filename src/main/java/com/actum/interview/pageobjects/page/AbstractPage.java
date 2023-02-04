package com.actum.interview.pageobjects.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

abstract class AbstractPage implements Page {
    private static final int IMPLICIT_WAIT = 5;
    private static final int ALERT_WAIT_TIMEOUT = 5;

    protected final WebDriver driver;
    private boolean isClosed = false;

    protected AbstractPage() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        driver.manage().window().maximize();
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
