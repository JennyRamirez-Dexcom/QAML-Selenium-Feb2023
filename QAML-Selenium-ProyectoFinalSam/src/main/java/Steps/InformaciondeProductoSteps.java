package Steps;

import Pages.DemoBlazeLandingPage;
import Pages.InformacionDeProductoPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InformaciondeProductoSteps extends BaseSteps{
    public InformaciondeProductoSteps(WebDriver driver) {
        super(driver);
    }

    InformacionDeProductoPage informacionDeProductoPage = PageFactory.initElements(webDriver, InformacionDeProductoPage.class);

    public boolean validarBotonAddToCart(){
        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(
                        informacionDeProductoPage.getBotonAddToCart()
                ));
        Boolean botonAddToCardIsDisplayed = informacionDeProductoPage.getBotonAddToCart().isDisplayed();
        return botonAddToCardIsDisplayed;
    }

    public boolean validarDescripcionDeProducto(){
        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(
                        informacionDeProductoPage.getDescripcionDeProducto()
                ));
        Boolean descripcionDeProductoIsDisplayed = informacionDeProductoPage.getDescripcionDeProducto().isDisplayed();
        return descripcionDeProductoIsDisplayed;
    }

    public boolean validarPrecioProducto(){
        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(
                        informacionDeProductoPage.getPrecioDeProducto()
                ));
        Boolean precioProductoIsDisplayed = informacionDeProductoPage.getPrecioDeProducto().isDisplayed();
        return precioProductoIsDisplayed;
    }

    public boolean validarNombreDelProducto(){
        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(
                        informacionDeProductoPage.getNombreDelProducto()
                ));
        Boolean nombreProductoIsDisplayed = informacionDeProductoPage.getNombreDelProducto().isDisplayed();
        return nombreProductoIsDisplayed;
    }

    public boolean validarImagenDelProducto(){
        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(
                        informacionDeProductoPage.getImagenDeProducto()
                ));
        Boolean imagenProductoIsDisplayed = informacionDeProductoPage.getImagenDeProducto().isDisplayed();
        return imagenProductoIsDisplayed;
    }

    public String validarTextoAlerta(){
        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(
                        informacionDeProductoPage.getBotonAddToCart()
                ));
        informacionDeProductoPage.getBotonAddToCart().click();
        Alert alert = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.alertIsPresent());
        String textoAlerta = alert.getText();
        return textoAlerta;
    }

    public void agregarProductoAlCart(){
        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(
                        informacionDeProductoPage.getBotonAddToCart()
                ));
        informacionDeProductoPage.getBotonAddToCart().click();
        cerrarAlerta();
    }


}
