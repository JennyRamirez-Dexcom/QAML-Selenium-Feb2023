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
        String rutaFireFoxDriver = getProperty("FIREFOX_DRIVER_PATH");
        File ruta = new File(rutaFireFoxDriver);
        System.setProperty("webdriver.chrome.driver", ruta.getPath());


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(options);


        //System.setProperty("webdriver.chrome.driver", ruta.getPath());

        return webDriver;
    }

    public String getProperty(String key) {
        Properties properties = new Properties();
        InputStream inputStream;
        String propertyValue = null;
        try{
            inputStream = new FileInputStream("C:\\Users\\Suri Sinai\\Documents\\nuevaCarpetaGit\\QAML-Selenium-Feb2023\\settings.properties");
            properties.load(inputStream);
            propertyValue = properties.getProperty(key);
            inputStream.close();
        } catch (IOException ioException) {

        } finally {

        }
        return propertyValue;
    }
}
