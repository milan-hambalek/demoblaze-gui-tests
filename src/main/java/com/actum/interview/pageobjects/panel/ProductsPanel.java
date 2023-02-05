package com.actum.interview.pageobjects.panel;

import com.actum.interview.pageobjects.data.Product;
import com.actum.interview.pageobjects.element.Button;
import com.actum.interview.pageobjects.element.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class ProductsPanel {

    private static final int PAGING_TIMEOUT = 5;

    private interface Locators {
        interface Id {
            String NEXT_BUTTON = "next2";
            String PREVIOUS_BUTTON = "prev2";
        }
        interface Css{
            String FIRST_PRODUCT_CARD_DIV = ".card.h-100";
        }
        interface XPath{
            String PHONES_CATEGORY_LINK = "//div[@class='list-group']/a[text()='Phones']";
            String LAPTOPS_CATEGORY_LINK = "//div[@class='list-group']/a[text()='Laptops']";
            String MONITORS_CATEGORY_LINK = "//div[@class='list-group']/a[text()='Monitors']";

            static String productLink(String productName) {
                return String.format("//div[@id='tbodyid']//a[contains(text(),'%s')]", productName);
            }
        }
    }

    private final WebDriver driver;

    public ProductsPanel(WebDriver driver) {
        this.driver = driver;
    }

    public Button nextButton() {
        return new Button(driver.findElement(By.id(Locators.Id.NEXT_BUTTON)));
    }

    public Button previousButton() {
        return new Button(driver.findElement(By.id(Locators.Id.PREVIOUS_BUTTON)));
    }

    public Link phonesLink() {
        return new Link(driver.findElement(By.xpath(Locators.XPath.PHONES_CATEGORY_LINK)));
    }

    public Link laptopsLink() {
        return new Link(driver.findElement(By.xpath(Locators.XPath.LAPTOPS_CATEGORY_LINK)));
    }

    public Link monitorsLink() {
        return new Link(driver.findElement(By.xpath(Locators.XPath.MONITORS_CATEGORY_LINK)));
    }

    public Link productLink(String productName) {
        return new Link(driver.findElement(By.xpath(Locators.XPath.productLink(productName))));
    }

    public void showPhonesOnly() {
        WebElement firstCardDiv = driver.findElement(By.cssSelector(Locators.Css.FIRST_PRODUCT_CARD_DIV));
        phonesLink().click();
        waitForProductsToReload(firstCardDiv);
    }

    public void showLaptopsOnly() {
        WebElement firstCardDiv = driver.findElement(By.cssSelector(Locators.Css.FIRST_PRODUCT_CARD_DIV));
        laptopsLink().click();
        waitForProductsToReload(firstCardDiv);
    }

    public void showMonitorsOnly() {
        WebElement firstCardDiv = driver.findElement(By.cssSelector(Locators.Css.FIRST_PRODUCT_CARD_DIV));
        monitorsLink().click();
        waitForProductsToReload(firstCardDiv);
    }

    public List<Product> collectProducts() {
        List<Product> products = new LinkedList<>();

        products.addAll(parseProducts());

        while(nextButton().isDisplayed()) {
            WebElement firstCardDiv = driver.findElement(By.cssSelector(Locators.Css.FIRST_PRODUCT_CARD_DIV));
            nextButton().click();
            waitForProductsToReload(firstCardDiv);
            products.addAll(parseProducts());
        }

        return products;
    }

    public List<Product> parseProducts() {
        List<WebElement> cards = driver.findElements(By.cssSelector(".card.h-100"));
        List<Product> products = cards.stream().map(e ->
            new Product(
                e.findElement(By.className("hrefch")).getText(),
                Integer.parseInt(e.findElement(By.tagName("h5")).getText().split("^\\$")[1]),
                e.findElement(By.id("article")).getText()
            )
        ).collect(Collectors.toList());

        return products;
    }

    private void waitForProductsToReload(WebElement stalenessCheckElement) {
        new WebDriverWait(driver, Duration.ofSeconds(PAGING_TIMEOUT)).until(
                stalenessOf(stalenessCheckElement)
        );
        new WebDriverWait(driver, Duration.ofSeconds(PAGING_TIMEOUT)).until(
                visibilityOfElementLocated(By.cssSelector(Locators.Css.FIRST_PRODUCT_CARD_DIV))
        );
    }
}
