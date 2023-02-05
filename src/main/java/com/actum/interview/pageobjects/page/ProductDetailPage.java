package com.actum.interview.pageobjects.page;

import com.actum.interview.pageobjects.panel.ProductDetailPanel;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends AbstractPage {

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public ProductDetailPanel productDetailPanel() {
        return new ProductDetailPanel(driver);
    }

    public void addToCart() {
        productDetailPanel().addToCartLink().click();
        acceptAlert();
    }

}
