import Steps.DemoBlazeLandingPageSteps;
import Steps.InformaciondeProductoSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SR12121Test extends BaseTest{
    private WebDriver webDriver = getWebDriver();

    InformaciondeProductoSteps informaciondeProductoSteps = new InformaciondeProductoSteps(webDriver);
    DemoBlazeLandingPageSteps demoBlazeLandingPageSteps = new DemoBlazeLandingPageSteps(webDriver);

    @Test(description = "Dar click en Add to Cart, Validar la alerta, el texto y dar ok a la alerta para que se cierre")
    public void validarAlerta(){
        demoBlazeLandingPageSteps.abrirPaginaDemoBlaze();
        demoBlazeLandingPageSteps.maximizarVentana();
        demoBlazeLandingPageSteps.clickenProducto();
        String textoAlertaActual = informaciondeProductoSteps.validarTextoAlerta();
        String textoAlertaExpected = "Product added";
        Assert.assertEquals(textoAlertaActual, textoAlertaExpected);
        informaciondeProductoSteps.cerrarAlerta();
        informaciondeProductoSteps.finalizarWebDriver();
    }
}
