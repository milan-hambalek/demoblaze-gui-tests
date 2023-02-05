package com.actum.interview.pageobjects.page;

import com.actum.interview.pageobjects.data.Product;
import com.actum.interview.pageobjects.panel.ProductsPanel;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DemoblazeHomePage extends AbstractPage {

    private static final int IMPLICIT_WAIT = 5;

    private static DemoblazeHomePage instance = null;

    public static DemoblazeHomePage getInstance() {
        if (instance == null || instance.isClosed()) {
            instance = new DemoblazeHomePage();
        }
        return instance;
    }

    private DemoblazeHomePage() {
        super(new FirefoxDriver());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com");
    }

    public ProductsPanel productsPanel() {
        return new ProductsPanel(driver);
    }

    public ProductDetailPage gotoProductDetail(Product product) {
        productsPanel().productLink(product.getName()).click();
        return new ProductDetailPage(driver);
    }

}
