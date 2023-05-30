import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.swing.plaf.PanelUI;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseTest {
    private WebDriver webDriver;

    protected WebDriver getWebDriver() {
        String rutaChromeDrive= getProperty("CHROME_DRIVER_PATH");
        //File ruta = new File("/Users/INETUM-1443/Documents/PracticaAuto/controladoresNavegador/chromedriver.exe");
        File ruta = new File(rutaChromeDrive);
        System.setProperty("webdriver.chromedriver", ruta.getPath());
       ChromeOptions opciones = new ChromeOptions();
        //webDriver.addArguments("--incognito");
        opciones.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver();
        return webDriver;// Devuelve
    }

    public String getProperty(String key){
        Properties properties = new Properties();
        InputStream inputStream;
        String propertyValue=null;
        try {
            inputStream=new FileInputStream("C://Users/INETUM-1443/Documents/PracticaAuto/QAML-Selenium-Feb2023/setting.properties");
            properties.load(inputStream);
            propertyValue=properties.getProperty(key);
            inputStream.close();
        }catch (IOException ioException){

        }finally{

        }return propertyValue;
    }
}