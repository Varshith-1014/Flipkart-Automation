package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultsPage {

    ChromeDriver driver;
    WebDriverWait wait;

    By product1 = By.xpath("//*[@id='container']/div/div[3]/div[1]/div[2]/div[2]/div/div[1]");
    By product2 = By.xpath("//*[@id='container']/div/div[3]/div[1]/div[2]/div[2]/div/div[2]");

    public ResultsPage(ChromeDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickFirstProduct() {
        WebElement p1 = wait.until(ExpectedConditions.elementToBeClickable(product1));
        p1.click();
    }

    public void clickSecondProduct() {
        WebElement p2 = wait.until(ExpectedConditions.elementToBeClickable(product2));
        p2.click();
    }
}