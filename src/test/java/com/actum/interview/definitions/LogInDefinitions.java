package com.actum.interview.definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.testng.Assert.assertEquals;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.AssertionsKt;

public class LogInDefinitions extends AbstractDefinitions {

    @Before("Login")
    public void setUp() {
//        homePage = DemoblazeHomePage.getInstance();
    }

    @And("Opens up \"Log In\" form")
    public void openLogInForm() {
//        homePage.menuPanel().loginLink().click();
    }

    @When("User logs in with username as {string} and password as {string}")
    public void logInWithIncompleteCredentials(String username, String password) {
//        homePage.loginForm().usernameInput().type(username);
//        homePage.loginForm().passwordInput().type(password);
//        homePage.loginForm().loginButton().click();
    }

    @After("@login")
    public void tearDown() {
//        homePage.quit();
    }

}
