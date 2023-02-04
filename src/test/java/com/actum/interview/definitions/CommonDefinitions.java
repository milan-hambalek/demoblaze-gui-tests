package com.actum.interview.definitions;

import com.actum.interview.pageobjects.page.DemoblazeHomePage;
import com.actum.interview.pageobjects.page.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.testng.Assert.assertEquals;

public class CommonDefinitions {

    @Given("Unsigned user is at {string} site")
    public void openWebsite(String url) {
        DemoblazeHomePage.getInstance();
    }

    @Then("User should see alert message {string}")
    public void verifyAlertMessage(String expectedMessage) {
        Page page = DemoblazeHomePage.getInstance();
        assertEquals(page.acceptAlert(), expectedMessage);
    }

}
