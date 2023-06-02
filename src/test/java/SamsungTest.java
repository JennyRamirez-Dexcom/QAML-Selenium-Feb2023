import Steps.SamsungSteps;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SamsungTest extends BaseTest {
    private WebDriver webDriver = getWebDriver();
    private SamsungSteps samsungSteps = new SamsungSteps(webDriver);
    @BeforeTest
    public void setUp(){
        samsungSteps.setUp();
    }
    @Test (description = "SR-12120: Hacer click en un Producto y  verificar que se muestre la imagen, descripcion, "+
            "precio y 'Add to cart'", priority = 1)
    public void beforeSamsunngTest(){
        samsungSteps.waitArtículos();
        samsungSteps.escogerUnArtículoDeLaTienda();
        samsungSteps.waitImage();
        samsungSteps.isDisplayedImage();
        samsungSteps.isDisplayedNameOfSamsung();
        samsungSteps.isDisplayedPrice();
        samsungSteps.isDisplayedDescription();
        samsungSteps.isDisplayedAddToCartButton();
    }
    @Test(description = "SR-12121: Dar click en 'Add to cart' y aceptar la alerta", priority = 2)
    public void clickOnAddToCard(){
        samsungSteps.clickOnAddtoCart();
        samsungSteps.alert();
    }
    @Test(description = "SR-12130, Ir a 'Cart' y verificar que se muestrela imagen de un producto, título, precio, "+
            "botón 'Delete', precio total y botón 'Place Order'", priority = 3)
    public void seeCart(){
        samsungSteps.goToCart();
        samsungSteps.waitImageProduct();
        samsungSteps.isDisplayedImageProduct();
        samsungSteps.isDisplayedTittle();
        samsungSteps.isDiplayedPrice();
        samsungSteps.isDisplayedDeleteButton();
        samsungSteps.isDisplayedTotalPrice();
        samsungSteps.isDisplayedePlaceOrderButton();
    }

    @AfterTest
    public void tearDown(){
        webDriver.quit();
    }

}
