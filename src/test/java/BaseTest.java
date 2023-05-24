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
    protected WebDriver webDriver ;

    public WebDriver getWebDriver()  {
        String ruta= getProperty("CHROME_DRIVER_PATH");
        File rootpath = new File(ruta);
        System.setProperty("webdriver.chrome.driver", rootpath.getPath());
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(ops);
        return webDriver;
    }

    public String getProperty(String propertyKey)  {
        Properties properties = new Properties();
        InputStream inputStream;
        String propertyValue = null;
        try{
                inputStream = new FileInputStream("/Users/diana.figueroa/Documents/GitHub/QAML-Selenium-Feb2023/settings.properties");
                properties.load(inputStream);
                propertyValue =properties.getProperty(propertyKey);
               inputStream.close();
        }catch (IOException ioException){

        }finally {

        }
        return  propertyValue;
    }
}
