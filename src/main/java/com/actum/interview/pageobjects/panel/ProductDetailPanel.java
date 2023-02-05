package com.actum.interview.pageobjects.panel;

import com.actum.interview.pageobjects.element.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPanel {

    private interface Locators {
        interface XPath {
            String ADD_TO_CART_LINK = "//div[@id='tbodyid']//a[text()='Add to cart']";
        }
    }

    private final WebDriver driver;

    public ProductDetailPanel(WebDriver driver) {
        this.driver = driver;
    }

    public Link addToCartLink() {
        return new Link(driver.findElement(By.xpath(Locators.XPath.ADD_TO_CART_LINK)));
    }

}
