import Steps.DemoQAWaitsSteps;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class DemoQAWaitsTest extends BaseTest{
    private WebDriver webDriver = getWebDriver();
    DemoQAWaitsSteps demoQAWaitsSteps = new DemoQAWaitsSteps(webDriver);

    @Test(description = "Esperando a que se muestre el boton con letras rojas")
    public void cambioDeColorTest(){
        demoQAWaitsSteps.abrirPaginaColorChange();
        demoQAWaitsSteps.waitBotonColorChangeExplicit();
        demoQAWaitsSteps.finalizarWebDriver();
    }

    @Test(description = "Esperando a que se muestre el boton Visible despues de 5sec")
    public void botonVisibleTest(){
        demoQAWaitsSteps.abrirPaginaColorChange();
        demoQAWaitsSteps.waitBotonVisibleAfterWait();
        demoQAWaitsSteps.finalizarWebDriver();
    }
}
