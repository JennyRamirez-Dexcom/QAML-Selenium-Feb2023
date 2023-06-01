package Steps;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseSteps {
    public WebDriver webDriver;

    //Constructor
    public BaseSteps(WebDriver driver) {
        this.webDriver = driver;
    }

    public String getURLActual() {
        return webDriver.getCurrentUrl();
    }

    public String getTituloActual() {
        return webDriver.getTitle();
    }

    public void cerrarVentana() {
        webDriver.close();
    }

    public String getCodigoFuente() {
        return webDriver.getPageSource();
    }

    public void finalizarWebDriver() {
        webDriver.quit();
    }

    public void imprimir(String cadenaAImprimir) {
        System.out.println(cadenaAImprimir);
    }

    public void maximizarVentana() {
        webDriver.manage().window().maximize();
    }

    public void cerrarAlerta(){
        Alert alert = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

}
