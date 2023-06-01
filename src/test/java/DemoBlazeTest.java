import Steps.DemoBlazeSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoBlazeTest extends BaseTest{
    private WebDriver webDriver = getWebDriver();

    private DemoBlazeSteps demoBlazeSteps = new DemoBlazeSteps(webDriver);

    @BeforeTest(description = "Precondiciones para comenzar mi prueba")
    public void beforeDemoBlazeTest(){
        demoBlazeSteps.imprimir("@BeforeTest");
        demoBlazeSteps.abrirPaginaDemoBlaze();
        demoBlazeSteps.maximizarVentana();
        demoBlazeSteps.waitLink();
        demoBlazeSteps.selectProducto();
        demoBlazeSteps.waitAddToCart();
    }

    @Test(description = "SR=12120", priority = 1, groups = "Proyecto Final")
    public void seleccionarProducto(){
        demoBlazeSteps.imprimir("SR=12120");
        demoBlazeSteps.addToCartIsDisplayed();
        demoBlazeSteps.productDescriptionIsDisplayed();
        demoBlazeSteps.priceIsDisplayed();
        demoBlazeSteps.nameOfProductIsDisplayed();
        demoBlazeSteps.imageOfProductIsDisplayed();
    }

    @Test(description = "SR=12121", priority = 2, groups = "Proyecto Final")
    public void seleccionarAddToCart(){
        demoBlazeSteps.imprimir("SR=12121");
        demoBlazeSteps.selectAddToCart();
        demoBlazeSteps.cerrarAlerta();
    }

    @Test(description = "SR=12130", priority = 3, groups = "Proyecto Final")
    public void seleccionarCartLink(){
        demoBlazeSteps.imprimir("SR=12130");
        demoBlazeSteps.selectAddToCart();
        demoBlazeSteps.cerrarAlerta();
        demoBlazeSteps.selectCartLink();
        demoBlazeSteps.waitTotalPrice();
        demoBlazeSteps.imprimirListOfProducts();
        demoBlazeSteps.imprimir("El precio total es de $"+demoBlazeSteps.imprimirTotalPrice());
        demoBlazeSteps.placeOrderIsDisplayed();
    }

    @AfterTest(description = "Metodo para finalizar un test")
    public void afterDemoBlazeTest(){
        demoBlazeSteps.imprimir("@AfterTest");
        demoBlazeSteps.finalizarWebDriver();
    }
}