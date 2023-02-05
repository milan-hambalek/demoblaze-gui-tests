package com.actum.interview.definitions;

import com.actum.interview.pageobjects.page.DemoblazeHomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;

import static org.testng.Assert.*;

public class LogInDefinitions extends AbstractDefinitions {

    @Before("@Login")
    public void setUp() {
        homePage = DemoblazeHomePage.getInstance();
    }

    @Then("User {string} should log in successfully")
    public void verifySuccessfulLogin(String username) {
        homePage.menuPanel().waitForLogIn();

        assertFalse(homePage.menuPanel().signupLink().isDisplayed());
        assertFalse(homePage.menuPanel().loginLink().isDisplayed());
        assertTrue(homePage.menuPanel().logoutLink().isDisplayed());
        assertTrue(homePage.menuPanel().welcomeLink().isDisplayed());
        assertEquals(homePage.menuPanel().welcomeLink().text(), "Welcome " + username);
    }

    @After("@Login")
    public void tearDown() {
        homePage.quit();
    }

}
