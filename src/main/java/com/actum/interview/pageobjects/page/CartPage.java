package com.actum.interview.pageobjects.page;

import com.actum.interview.pageobjects.panel.CartPanel;
import org.openqa.selenium.WebDriver;

public class CartPage extends AbstractPage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPanel cartPanel() {
        return new CartPanel(driver);
    }

}
