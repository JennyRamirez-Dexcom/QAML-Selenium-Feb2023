import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public String getProperty(String key){
        Properties properties = new Properties();
        InputStream input = null;
        String propertyValue = null;

        try{
            input = new FileInputStream("C:\\Users\\ÅrKångêL\\IdeaProjects\\QAML-Selenium-Feb2023\\settings.properties");
            properties.load(input);
            propertyValue = properties.getProperty(key);
            input.close();
        }catch (IOException ioException){

        }finally {
            //input.close();
        }

        return propertyValue;
    }

    protected WebDriver getWebDriver(){
        /* String rutaFireFox = getProperty("FIREFOX_DRIVER_PATH");
        File rootPath = new File(rutaFireFox);
        System.setProperty("webdriver.gecko.driver",rootPath.getPath());
        webDriver = new FirefoxDriver();*/

        String rutaChromeDriver = getProperty("CHROME_DRIVER_PATH");
        File rootPath = new File(rutaChromeDriver);
        System.setProperty("webdriver.chrome.driver",rootPath.getPath());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(options);

        return webDriver;
    }
}
