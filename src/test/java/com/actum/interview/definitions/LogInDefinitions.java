package com.actum.interview.definitions;

import com.actum.interview.pageobjects.page.DemoblazeHomePage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.*;

public class LogInDefinitions extends AbstractDefinitions {

    @And("Opens up \"Log In\" form")
    public void openLogInForm() {
        homePage = DemoblazeHomePage.getInstance();
        homePage.menuPanel().loginLink().click();
    }

    @When("User logs in with username as {string} and password as {string}")
    public void logIn(String username, String password) {
        homePage.loginForm().usernameInput().type(username);
        homePage.loginForm().passwordInput().type(password);
        homePage.loginForm().loginButton().click();
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
