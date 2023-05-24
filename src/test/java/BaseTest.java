import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseTest {
    protected WebDriver webDriver;

    public WebDriver getWebDriver() {

        String rutaChromeDriver = getProperty(CHROME_DRIVER_PATH);
        File roothPath = new File(rutaChromeDriver);
        System.setProperty("webdriver.chrome.driver", roothPath.getPath());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(options);
        return webDriver;
    }

    public String getProperty(String key) {
        Properties properties = new Properties();
        InputStream inputStream;
        String propertyValue = null;
        try {
            inputStream = new FileInputStream("C:/Users/OsLoV/Documents/GitHub/QAML-Selenium-Feb2023/settings.properties");
            properties.load(inputStream);
            propertyValue = properties.getProperty(key);
            inputStream.close();
        }
        catch (IOException exception) {

        }
        finally {

        }
        return propertyValue;
    }
}
