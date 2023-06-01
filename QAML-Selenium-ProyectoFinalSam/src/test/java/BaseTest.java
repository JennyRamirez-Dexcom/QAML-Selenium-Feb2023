import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
        String rutaChromeDriver = getProperty("CHROME_DRIVER_PATH");
        File ruta = new File(rutaChromeDriver);
        System.setProperty("webDriver.chrome.driver", ruta.getPath());
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
        try{
            inputStream = new FileInputStream("/Users/samanthacanorubio/Documents/QA ML-GithubRespaso/QAML-Selenium-Feb2023/QAML-Selenium-ProyectoFinalSam/settings.properties");
            properties.load(inputStream);
            propertyValue = properties.getProperty(key);
            inputStream.close();
        } catch (IOException ioException) {

        } finally {

        }
        return propertyValue;
    }
}
