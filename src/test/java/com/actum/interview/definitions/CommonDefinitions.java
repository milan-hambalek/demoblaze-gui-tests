package com.actum.interview.definitions;

import com.actum.interview.pageobjects.page.DemoblazeHomePage;
import com.actum.interview.pageobjects.page.Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertEquals;

public class CommonDefinitions {

    @Given("Unsigned user is at {string} site")
    public void openWebsite(String url) {
        DemoblazeHomePage.getInstance();
    }

    @And("Opens up \"Log In\" form")
    public void openLogInForm() {
        DemoblazeHomePage.getInstance().menuPanel().loginLink().click();
    }

    @When("User logs in with username as {string} and password as {string}")
    public void logIn(String username, String password) {
        DemoblazeHomePage.getInstance().loginForm().usernameInput().type(username);
        DemoblazeHomePage.getInstance().loginForm().passwordInput().type(password);
        DemoblazeHomePage.getInstance().loginForm().loginButton().click();
    }

    @Then("User should see alert message {string}")
    public void verifyAlertMessage(String expectedMessage) {
        Page page = DemoblazeHomePage.getInstance();
        assertEquals(page.acceptAlert(), expectedMessage);
    }

}
