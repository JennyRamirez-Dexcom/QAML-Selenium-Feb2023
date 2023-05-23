import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class BaseTest {
    private WebDriver webDriver;

    public WebDriver getWebDriver() {
        File rootpath= new File("/Users/diana.figueroa/Documents/GitHub/QAML-Selenium-Feb2023/src/main/resources/Drivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", rootpath.getPath());
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(ops);
        return webDriver;
    }
}
