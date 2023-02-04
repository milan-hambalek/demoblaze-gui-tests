package com.actum.interview.definitions;

import com.actum.interview.pageobjects.page.DemoblazeHomePage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class SignUpDefinitions extends AbstractDefinitions {

    @And("Opens up \"Sign Up\" form")
    public void openSignUpForm() {
        homePage = DemoblazeHomePage.getInstance();
        homePage.menuPanel().signupLink().click();
    }

    @When("User signs up with username as {string} and unique password")
    public void signUpWithExistingUsername(String username) {
        int length = 10;
        String password = randomAlphanumeric(length);

        homePage.signupForm().usernameInput().type(username);
        homePage.signupForm().passwordInput().type(password);
        homePage.signupForm().signupButton().click();
    }

    @When("User signs up with username as {string} and password as {string}")
    public void signUpWithIncompleteCredentials(String username, String password) {
        homePage.signupForm().usernameInput().type(username);
        homePage.signupForm().passwordInput().type(password);
        homePage.signupForm().signupButton().click();
    }

    @When("User signs up with unique username and password")
    public void signUpWithValidCredentials() {
        int length = 10;
        String username = randomAlphabetic(length);
        String password = randomAlphanumeric(length);

        homePage.signupForm().usernameInput().type(username);
        homePage.signupForm().passwordInput().type(password);
        homePage.signupForm().signupButton().click();
    }

    @After("@Signup")
    public void tearDown() {
        homePage.quit();
    }

}
