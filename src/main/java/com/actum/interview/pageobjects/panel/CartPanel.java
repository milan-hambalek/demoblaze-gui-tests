package com.actum.interview.pageobjects.panel;

import com.actum.interview.pageobjects.data.CartItem;
import com.actum.interview.pageobjects.element.H3;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CartPanel {

    private static final int LOAD_TIMEOUT = 3;

    private interface Locators {
        interface Id {
            String TOTAL_PRICE = "totalp";
        }
        interface XPath {
            String CART_ROW = "//tbody[@id='tbodyid']/tr[@class='success']";
        }
    }

    private final WebDriver driver;

    public CartPanel(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForLoad() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(LOAD_TIMEOUT)).until(
                    ExpectedConditions.textMatches(By.id(Locators.Id.TOTAL_PRICE), Pattern.compile("\\d+"))
            );
        } catch (TimeoutException e) {
            // not a reason to fail. Cart may be empty.
        }
    }

    public H3 totalPriceElement() {
        return new H3(driver.findElement(By.id(Locators.Id.TOTAL_PRICE)));
    }

    public Set<CartItem> parseProducts() {
        List<WebElement> items = driver.findElements(By.xpath(Locators.XPath.CART_ROW));
        Set<CartItem> cartItems = items.stream().map(item ->
                   new CartItem(item.findElement(By.xpath("td[2]")).getText(),
                                Integer.parseInt(item.findElement(By.xpath("td[3]")).getText()))
           ).collect(Collectors.toSet());

        return cartItems;
    }

}
