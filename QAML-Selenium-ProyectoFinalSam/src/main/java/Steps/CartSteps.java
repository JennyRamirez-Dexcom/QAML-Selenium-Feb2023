package Steps;

import Pages.CartPage;
import Pages.DemoBlazeLandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartSteps extends BaseSteps{

    public CartSteps(WebDriver driver) {
        super(driver);
    }
    CartPage cartPage = PageFactory.initElements(webDriver, CartPage.class);

    public void clickAlCartPage(){
        cartPage.getCartLink().click();
    }

    public boolean validarImagenProductoCart(){
        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(
                        cartPage.getImagenProductoCart()
                ));
        Boolean imagenProductCartIsDisplayed = cartPage.getImagenProductoCart().isDisplayed();
        return imagenProductCartIsDisplayed;
    }

    public boolean validarNombreDelProductoCart(){
        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(
                        cartPage.getTitleProductoCart()
                ));
        String nombreDelProductoTexto = cartPage.getTitleProductoCart().getText();
        imprimir("El nombre de producto es " + nombreDelProductoTexto);
        Boolean tituloProductoCartIsDisplayed = cartPage.getTitleProductoCart().isDisplayed();
        return tituloProductoCartIsDisplayed;
    }

    public boolean validarPrecioDelProductoCart(){
        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(
                        cartPage.getProductPriceCart()
                ));
        String precioDelProductoTexto = cartPage.getProductPriceCart().getText();
        imprimir("El precio de producto es $" + precioDelProductoTexto);
        Boolean productPriceCartIsDisplayed = cartPage.getProductPriceCart().isDisplayed();
        return productPriceCartIsDisplayed;
    }

    public boolean validarDeleteLink(){
        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(
                        cartPage.getDeleteLink()
                ));
        Boolean deleteLinkIsDisplayed = cartPage.getDeleteLink().isDisplayed();
        return deleteLinkIsDisplayed;
    }

    public boolean validarTotalPrice(){
        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(
                        cartPage.getTotalPrice()
                ));
        String precioDelProductoTexto = cartPage.getTotalPrice().getText();
        imprimir("El precio de Total del carrito es $" + precioDelProductoTexto);
        Boolean totalPriceIsDisplayed = cartPage.getTotalPrice().isDisplayed();
        return totalPriceIsDisplayed;
    }

    public boolean validarBotonPlaceOrder(){
        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(
                        cartPage.getBotonPlaceOrder()
                ));
        Boolean botonPlaceOrderIsDisplayed = cartPage.getBotonPlaceOrder().isDisplayed();
        return botonPlaceOrderIsDisplayed;
    }

}
