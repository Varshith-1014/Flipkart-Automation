package tests;

import org.testng.annotations.Test;

import Base.BaseTest;
import pages.HomePage;
import pages.ResultsPage;
import pages.ProductPage;

public class AddToCartTest extends BaseTest {

    @Test
    public void runTest() {

        setUp();

        HomePage home = new HomePage(driver, wait);
        home.closePopup();
        home.searchProduct("Home Appliances");

        ResultsPage results = new ResultsPage(driver, wait);

        // Product 1
        results.clickFirstProduct();
        ProductPage p1 = new ProductPage(driver, wait);
        p1.switchToNewTab();
        p1.clickAddToCart();
        p1.goToCartPage();
        double price1 = p1.readFirstPrice();
        driver.close();
        driver.switchTo().window(p1.parentWindow);

        // Product 2
        results.clickSecondProduct();
        ProductPage p2 = new ProductPage(driver, wait);
        p2.switchToNewTab();
        p2.clickAddToCart();
        p2.goToCartPage();
        double price2 = p2.readSecondPrice();

        System.out.println("Total Price 1: " + price1);
        System.out.println("Total Price 2: " + price2);
        System.out.println("FINAL CHECKOUT COST: ₹" + (price1 + price2));

        tearDown();
    }
}
