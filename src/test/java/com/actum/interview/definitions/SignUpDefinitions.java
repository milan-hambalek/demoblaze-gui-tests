package com.actum.interview.definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertEquals;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.AssertionsKt;

public class SignUpDefinitions extends AbstractDefinitions {

    @Before("@Signup")
    public void setUp() {
//        homePage = DemoblazeHomePage.getInstance();
    }

    @And("Opens up \"Sign Up\" form")
    public void openSignUpForm() {
//        homePage.menuPanel().signupLink().click();
    }

    @When("User signs up with username as {string} and unique password")
    public void signUpWithExistingUsername(String username) {
//        int length = 10;
//        String password = randomAlphanumeric(length);
//
//        homePage.signupForm().usernameInput().type(username);
//        homePage.signupForm().passwordInput().type(password);
//        homePage.signupForm().signupButton().click();
    }

    @When("User signs up with username as {string} and password as {string}")
    public void signUpWithIncompleteCredentials(String username, String password) {
//        homePage.signupForm().usernameInput().type(username);
//        homePage.signupForm().passwordInput().type(password);
//        homePage.signupForm().signupButton().click();
    }

    @When("User signs up with unique username and password")
    public void signUpWithValidCredentials() {
//        int length = 10;
//        String username = randomAlphabetic(length);
//        String password = randomAlphanumeric(length);
//
//        homePage.signupForm().usernameInput().type(username);
//        homePage.signupForm().passwordInput().type(password);
//        homePage.signupForm().signupButton().click();
    }

    @After("@Signup")
    public void tearDown() {
//        homePage.quit();
    }

}
