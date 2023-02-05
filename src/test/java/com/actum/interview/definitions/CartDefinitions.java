package com.actum.interview.definitions;

import com.actum.interview.pageobjects.data.CartItem;
import com.actum.interview.pageobjects.data.Product;
import com.actum.interview.pageobjects.page.CartPage;
import com.actum.interview.pageobjects.page.DemoblazeHomePage;
import com.actum.interview.pageobjects.page.ProductDetailPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;

public class CartDefinitions extends AbstractDefinitions {

    private ProductDetailPage productDetailPage;
    private CartPage cartPage;
    private List<Product> shuffledProducts;

    @Before("@Cart")
    public void setUp() {
        homePage = DemoblazeHomePage.getInstance();
    }

    @When("User opens detail page of 1st product")
    public void open1stProductDetail() {
        shuffledProducts = homePage.productsPanel().parseProducts();
        Collections.shuffle(shuffledProducts);
        Product product = shuffledProducts.get(0);
        productDetailPage = homePage.gotoProductDetail(product);
    }

    @And("Adds it into cart")
    public void addToCart() {
        productDetailPage.addToCart();
    }

    @And("Goes back to main page")
    public void goBackToHomepage() {
        homePage = productDetailPage.gotoHomepage();
    }

    @When("User opens detail page of 2nd product")
    public void open2ndProductDetail() {
        Product product = shuffledProducts.get(1);
        productDetailPage = homePage.gotoProductDetail(product);
    }

    @When("User opens detail page of 3rd product")
    public void open3rdProductDetail() {
        Product product = shuffledProducts.get(2);
        productDetailPage = homePage.gotoProductDetail(product);
    }

    @And("Opens up cart page")
    public void gotoCart() {
        cartPage = productDetailPage.gotoCart();
    }

    @Then("User should see all selected products in cart")
    public void checkProductsInCart() {
        Set<CartItem> cartItems = cartPage.cartPanel().parseProducts();

        Set<CartItem> expectedCartItems = shuffledProducts.subList(0, 3).stream().map(p ->
                new CartItem(p.getName(), p.getPrice())
        ).collect(Collectors.toSet());

        assertEquals(cartItems, expectedCartItems);
    }

    @And("Total price is equal to sum of product prices")
    public void checkTotalPrice() {
        int expectedPrice = shuffledProducts.subList(0, 3).stream().map(Product::getPrice)
                .reduce(0, Integer::sum);
        int totalPrice = Integer.parseInt(cartPage.cartPanel().totalPriceElement().text());

        assertEquals(totalPrice, expectedPrice);
    }

    @After("@Cart")
    public void tearDown() {
        homePage.quit();
    }

}
