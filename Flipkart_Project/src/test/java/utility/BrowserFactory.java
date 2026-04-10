package utility;

import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

    public static ChromeDriver startBrowser() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}