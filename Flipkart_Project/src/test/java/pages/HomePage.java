package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    ChromeDriver driver;
    WebDriverWait wait;

    By popupClose = By.xpath("//span[@class='_30XB9F'] | //button[contains(.,'✕')] | /html/body/div[5]/div/span");
    By searchBox = By.xpath("//input[@type='text']");

    public HomePage(ChromeDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void closePopup() {
        WebElement pop = wait.until(ExpectedConditions.elementToBeClickable(popupClose));
        pop.click();
    }

    public void searchProduct(String text) {
        WebElement sb = wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        sb.sendKeys(text, Keys.ENTER);
    }
}