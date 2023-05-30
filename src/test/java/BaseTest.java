import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.rmi.PortableRemoteObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseTest {
    protected WebDriver webDriver;//el webdriver tiene que estar encapsulado

    protected WebDriver getWebDriver() {
        //File ruta = new File("/Users/mlopez/Downloads/chromedriver_mac_arm64/chromedriver.exe");//para chrome
        //System.setProperty("webdriver.chrome.driver",ruta.getPath());
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--incognito");
        //options.addArguments("--remote-allow-origins=*");
        //webDriver=new ChromeDriver(options);

        String rutaFireFoxDriver = getProperty("FIREFOX_DRIVER_PATH");
        File ruta = new File(rutaFireFoxDriver);//donde tengo el webdriver
        System.setProperty("webdriver.gecko.driver",ruta.getPath());
        webDriver=new FirefoxDriver();
        return webDriver;
    }

    public String getProperty(String key){
        Properties properties = new Properties();
        InputStream inputStream;
        String propertyValue = null;
        try{
            inputStream = new FileInputStream("/Users/mlopez/IdeaProjects/QAML-Selenium/settings.properties");
            properties.load(inputStream);
            propertyValue=properties.getProperty(key);
        } catch (IOException ioException){
        } finally {
        }
        return propertyValue;
    }
}
