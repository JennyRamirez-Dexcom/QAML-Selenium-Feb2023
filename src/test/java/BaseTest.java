import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class BaseTest {
    private WebDriver webDriver;

    public WebDriver getWebDriver() {
        File ruta = new File("/Users/jxr20920/Downloads/geckodriver-2");
        System.setProperty("webDriver.gecko.driver", ruta.getPath());
        //System.setProperty("webdriver.chrome.driver", ruta.getPath());
        webDriver = new FirefoxDriver();
        return webDriver;
    }
}
