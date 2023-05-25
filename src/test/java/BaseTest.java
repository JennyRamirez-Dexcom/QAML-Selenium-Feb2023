import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseTest {
    protected WebDriver webDriver;

    //Siempre private o protected NO PUBLIC
    protected WebDriver getWebDriver() {
        String rutaFireFoxDriver = getProperty("FIREFOX_DRIVER_PATH");
        File ruta = new File(rutaFireFoxDriver);
        System.setProperty("webdriver.gecko.driver", ruta.getPath());
        //System.setProperty("webdriver.chrome.driver", ruta.getPath());
        webDriver = new FirefoxDriver();
        return webDriver;
    }

    public String getProperty(String key) {
        Properties properties = new Properties();
        InputStream inputStream;
        String propertyValue = null;
        try{
            inputStream = new FileInputStream("/Users/jxr20920/QAML-Feb2023/QAML-Selenium-May-6/settings.properties");
            properties.load(inputStream);
            propertyValue = properties.getProperty(key);
            inputStream.close();
        } catch (IOException ioException) {

        } finally {

        }
        return propertyValue;
    }
}
