package Base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import utility.BrowserFactory;  // ✅ REQUIRED IMPORT

public class BaseTest {

    public ChromeDriver driver;
    public WebDriverWait wait;

    public void setUp() {
        driver = BrowserFactory.startBrowser();   
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");
    }

    public void tearDown() {
        driver.quit();
    }
}