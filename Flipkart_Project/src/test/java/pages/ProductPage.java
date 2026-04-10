package pages;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.WaitUtils;

public class ProductPage {

    public ChromeDriver driver;
    public WebDriverWait wait;

    public String parentWindow;

    // ========================
    // ALL LOCATORS
    // ========================
    By addCart = By.xpath("//div[text()='Add to cart'] | //div[contains(@style,'transform: translateY(0px) scale(1)')]");
    By goCart = By.xpath("//div[text()='Go to cart'] | //span[text()='Cart']");
    By price1 = By.xpath("//*[@id=\"slot-list-container\"]/div/div[1]/div/div/div/div/div/div[2]/div/div[3]/div/div/div/div[1]/div/div[2]/div/div/div[2]/div[1]/div/div/div");
    By price2 = By.xpath("(//span[contains(text(),'₹')])[2]");

    // ========================
    // CONSTRUCTOR
    // ========================
    public ProductPage(ChromeDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.parentWindow = driver.getWindowHandle();
    }

    // ========================
    // METHODS
    // ========================

    public void switchToNewTab() {
        Set<String> windows = driver.getWindowHandles();

        for (String win : windows) {
            if (!win.equals(parentWindow)) {
                driver.switchTo().window(win);
            }
        }
    }

    // FINAL 
    public void clickAddToCart() {
    	try {
    		WaitUtils.waitClickable(driver, wait, addCart);
            driver.findElement(addCart).click(); 
    	
    	}
    	
    	catch(Exception e)
    	{
    		WaitUtils.waitClickable(driver, wait, addCart);
            driver.findElement(addCart).click(); 
    	}
        // fresh element every time
    }

    public void goToCartPage() {
        WaitUtils.waitClickable(driver, wait, goCart);
        driver.findElement(goCart).click();
    }

    public double readFirstPrice() {
        String val = WaitUtils.waitVisible(driver, wait, price1).getText();
        val = val.replaceAll("[^0-9]", "");
        return Double.parseDouble(val);
    }

    public double readSecondPrice() {
        String val = WaitUtils.waitVisible(driver, wait, price2).getText();
        val = val.replaceAll("[^0-9]", "");
        return Double.parseDouble(val);
    }
}