import Steps.DemoBlazeLandingPageSteps;
import Steps.InformaciondeProductoSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SR12120Test extends BaseTest{
    private WebDriver webDriver = getWebDriver();

    DemoBlazeLandingPageSteps demoBlazeLandingPageSteps = new DemoBlazeLandingPageSteps(webDriver);
    InformaciondeProductoSteps informaciondeProductoSteps = new InformaciondeProductoSteps(webDriver);

    @Test(description = "Abrir la pagina y hacer click en un producto para abrirlo")
    public void validarInformacionDeProducto(){
        demoBlazeLandingPageSteps.abrirPaginaDemoBlaze();
        demoBlazeLandingPageSteps.maximizarVentana();
        demoBlazeLandingPageSteps.clickenProducto();
        //Validando si el Boton Add to Cart esta visible
        Boolean BotonAddCardActual = informaciondeProductoSteps.validarBotonAddToCart();
        Assert.assertEquals(BotonAddCardActual, true);
        informaciondeProductoSteps.imprimir("El boton de Add to cart esta visible");
        //Validando si la Descripcion del producto esta visible
        Boolean InformacionDeProductoActual = informaciondeProductoSteps.validarDescripcionDeProducto();
        Assert.assertEquals(InformacionDeProductoActual, true);
        informaciondeProductoSteps.imprimir("La descripcion de producto esta visible");
        //Validando si el precio del producto esta visible
        Boolean PrecioDelProductoActual = informaciondeProductoSteps.validarPrecioProducto();
        Assert.assertEquals(PrecioDelProductoActual,true);
        informaciondeProductoSteps.imprimir("El precio del producto esta visible");
        //Validando si el precio del producto esta visible
        Boolean NombreDelProductoActual = informaciondeProductoSteps.validarNombreDelProducto();
        Assert.assertEquals(NombreDelProductoActual,true);
        informaciondeProductoSteps.imprimir("El nombre del producto esta visible");
        //Validando si la imagen del producto esta visible
        Boolean ImagenDelProductoActual = informaciondeProductoSteps.validarImagenDelProducto();
        Assert.assertEquals(ImagenDelProductoActual,true);
        informaciondeProductoSteps.imprimir("La imagen del producto esta visible");
        informaciondeProductoSteps.finalizarWebDriver();
    }

}
