package com.actum.interview.definitions;

import com.actum.interview.pageobjects.data.Product;
import com.actum.interview.pageobjects.page.DemoblazeHomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.testng.Assert.assertEquals;

public class CategoriesDefinitions extends AbstractDefinitions {

    private List<Product> displayedProducts;

    @Before("@Categories")
    public void setUp() {
        homePage = DemoblazeHomePage.getInstance();
    }

    @When("User browses through products without specifying category")
    public void browseAllProducts() {
        displayedProducts = homePage.productsPanel().collectProducts();
    }

    @Then("User should see all available products in correct order")
    public void verifyDisplayedProducts() throws IOException {
        List<Product> expectedProducts = Stream.of(Product.phones(), Product.laptops(), Product.monitors())
                .flatMap(Collection::stream).collect(Collectors.toList());
        assertEquals(displayedProducts, expectedProducts);
    }

    @When("User chooses \"Phones\" category and browses phones")
    public void browsePhones() {
        homePage.productsPanel().showPhonesOnly();
        displayedProducts = homePage.productsPanel().parseProducts();
    }

    @Then("User should see all available phones in correct order")
    public void verifyDisplayedPhones() throws IOException {
        assertEquals(displayedProducts, Product.phones());
    }

    @When("User chooses \"Laptops\" category and browses laptops")
    public void browseLaptops() {
        homePage.productsPanel().showLaptopsOnly();
        displayedProducts = homePage.productsPanel().parseProducts();
    }

    @Then("User should see all available laptops in correct order")
    public void verifyDisplayedLaptops() throws IOException {
        assertEquals(displayedProducts, Product.laptops());
    }

    @When("User chooses \"Monitors\" category and browses monitors")
    public void browseMonitors() {
        homePage.productsPanel().showMonitorsOnly();
        displayedProducts = homePage.productsPanel().parseProducts();
    }

    @Then("User should see all available monitors in correct order")
    public void verifyDisplayedMonitors() throws IOException {
        assertEquals(displayedProducts, Product.monitors());
    }

    @After("@Categories")
    public void tearDown() {
        homePage.quit();
    }

}
