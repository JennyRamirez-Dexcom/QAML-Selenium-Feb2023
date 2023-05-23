import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class BaseTest {
    protected WebDriver webDriver;

    public WebDriver getWebDriver() {

        File roothPath = new File("C:/Users/OsLoV/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", roothPath.getPath());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(options);
        return webDriver;
    }
}
