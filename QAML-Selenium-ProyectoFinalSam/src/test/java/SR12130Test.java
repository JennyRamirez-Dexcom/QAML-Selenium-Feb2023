import Steps.CartSteps;
import Steps.DemoBlazeLandingPageSteps;
import Steps.InformaciondeProductoSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SR12130Test extends BaseTest{
    private WebDriver webDriver = getWebDriver();
    InformaciondeProductoSteps informaciondeProductoSteps = new InformaciondeProductoSteps(webDriver);
    DemoBlazeLandingPageSteps demoBlazeLandingPageSteps = new DemoBlazeLandingPageSteps(webDriver);
    CartSteps cartSteps = new CartSteps(webDriver);

    @Test(description = "Validar pagina Add to Cart cuando un producto ha sido agregado")
    public void validarCartUnProducto(){
        demoBlazeLandingPageSteps.abrirPaginaDemoBlaze();
        demoBlazeLandingPageSteps.maximizarVentana();
        demoBlazeLandingPageSteps.clickenProducto();
        informaciondeProductoSteps.agregarProductoAlCart();
        cartSteps.clickAlCartPage();
        Boolean ActualIMGstatus = cartSteps.validarImagenProductoCart();
        Assert.assertEquals(ActualIMGstatus, true);
        Boolean actualTitleProductostatus = cartSteps.validarNombreDelProductoCart();
        Assert.assertEquals(actualTitleProductostatus,true);
        Boolean actualPricestatus = cartSteps.validarPrecioDelProductoCart();
        Assert.assertEquals(actualPricestatus,true);
        Boolean actualDeleteLinkstatus = cartSteps.validarDeleteLink();
        Assert.assertEquals(actualDeleteLinkstatus,true);
        Boolean actualTotalPricestatus = cartSteps.validarTotalPrice();
        Assert.assertEquals(actualTotalPricestatus,true);
        Boolean actualBotonPlaceOrderStatus = cartSteps.validarBotonPlaceOrder();
        Assert.assertEquals(actualBotonPlaceOrderStatus,true);
        cartSteps.finalizarWebDriver();
    }

}
