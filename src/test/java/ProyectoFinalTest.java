import Steps.ProyectoFinalSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProyectoFinalTest extends BaseTest{
    private WebDriver driver = getWebDriver();

    ProyectoFinalSteps proyectoFinalSteps = new ProyectoFinalSteps(driver);

    @Test(description="Flow completo para añadir un elemento al carrito")
    public void cartFlowTest() throws Exception {
        //"SR-12120"
        proyectoFinalSteps.abrirPaginaCart();
        proyectoFinalSteps.clickFirstElement();
        proyectoFinalSteps.showingCartButtonFirstElement();
        proyectoFinalSteps.showingDescriptionFirstElement();
        proyectoFinalSteps.showingPriceFirstElement();
        proyectoFinalSteps.showingTitleFirstElement();
        proyectoFinalSteps.showingImageFirstElement();
        //"SR-12121"
        proyectoFinalSteps.clickAddCartButton();
        proyectoFinalSteps.alertMessageHandling();
        //"SR-12130"
        proyectoFinalSteps.cartLinkClicked();
        Assert.assertEquals(proyectoFinalSteps.getURLActual(), "https://www.demoblaze.com/cart.html");
        proyectoFinalSteps.showingCartButtonFirstElement();
        proyectoFinalSteps.totalElements();
        proyectoFinalSteps.cartItemDetails();
        proyectoFinalSteps.finalizarWebDriver();
    }
}
