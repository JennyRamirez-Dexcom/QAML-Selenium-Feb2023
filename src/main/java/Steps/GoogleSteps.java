package Steps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleSteps extends BaseSteps {

    public GoogleSteps(WebDriver driver) {
        super(driver);
    }

    public void abrirPaginaGoogle() {
        webDriver.get("https://www.google.com");
    }

    public void navegarPaginaFacebook() {
        webDriver.navigate().to("https://www.facebook.com/");
    }

    public void navegarPaginaESPN() {
        webDriver.navigate().to("https://www.espn.com.mx/");
    }

    public void enviarBusquedaEnGoogle(String busqueda) {
        WebElement barraBusqueda = webDriver.findElement(
                By.cssSelector("textarea[name='q']")
        );
        barraBusqueda.sendKeys(busqueda);
    }

    public void clickBuscar() {
        List<WebElement> botonesBusqueda = webDriver.findElements(
                By.cssSelector("input[name='btnK']")
        );

        botonesBusqueda.get(1).click();
    }

    public void enviarEnter() {
        WebElement barraBusqueda = webDriver.findElement(
                By.cssSelector("textarea[name='q']")
        );
        barraBusqueda.sendKeys(Keys.ENTER);
    }
}
