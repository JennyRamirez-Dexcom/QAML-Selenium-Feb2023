import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class BaseTest {
    protected WebDriver webDriver;

    //Siempre private o protected NO PUBLIC
    protected WebDriver getWebDriver() {
        File ruta = new File("/Users/jxr20920/Downloads/geckodriver-2");
        System.setProperty("webdriver.gecko.driver", ruta.getPath());
        //System.setProperty("webdriver.chrome.driver", ruta.getPath());
        webDriver = new FirefoxDriver();
        return webDriver;
    }
}
