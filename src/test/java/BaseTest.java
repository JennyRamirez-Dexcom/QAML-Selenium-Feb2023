import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.*;
import java.util.Properties;

public class BaseTest {
    private WebDriver webDriver;

    File driverRootPath;

    public WebDriver getWebDriver(String browser) {
        switch (browser) {
            case "Chrome":
                driverRootPath = new File(getproperties("CHROMEDRIVERPATH"));
                System.setProperty("webdriver.chrome.dirver", driverRootPath.getPath());
                System.out.println("Chrome test webdriver setup"+ driverRootPath.getPath());
                ChromeOptions ops = new ChromeOptions();
                ops.addArguments("--remote-allow-origins=*");
                webDriver = new ChromeDriver(ops);
                break;

            case "Firefox":
                System.out.println("Firefox......");
                driverRootPath = new File(getproperties("FIREFOXDRIVERPATH"));
                System.setProperty("webdriver.gecko.driver", driverRootPath.getPath());
                FirefoxOptions options1 = new FirefoxOptions();
                options1.addArguments("--remote-allow-origins=*");
                webDriver = new FirefoxDriver(options1);
                break;

            default:
                driverRootPath = new File("/Users/diana.figueroa/Desktop/DianysDev/BootcampMavenPlusWebDriver/src/main/resources/Drivers/msedgedriver");
                System.setProperty("webdriver.edge.driver", driverRootPath.getPath());
                EdgeOptions options2 = new EdgeOptions();
                options2.addArguments("--remote-allow-origins=*");
                System.out.println("Driver ready");
                webDriver = new EdgeDriver(options2);
                break;
        }
        return webDriver;

    }


    public  String getproperties(String propertyKey){
        Properties properties = new Properties();
        InputStream inputStream;
        String propertyValue = null;

        try {
            inputStream= new FileInputStream("/Users/diana.figueroa/Desktop/QAML-Selenium Final project/settings.properties");
            properties.load(inputStream);
            propertyValue = properties.getProperty(propertyKey);
            inputStream.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return propertyValue;
    }
}
