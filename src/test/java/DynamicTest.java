import Steps.DynamicWaitsSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicTest extends BaseTest{
    private WebDriver webDriver=getWebDriver();
    DynamicWaitsSteps dynamicWaitsSteps= new DynamicWaitsSteps(webDriver);

    @Test(description = "Prueba cambio de color del button Color Change")
    public void buttonTextoColor() {
    dynamicWaitsSteps.abrirPaginaDinamico();
    dynamicWaitsSteps.waitButtonTextoColor();
    dynamicWaitsSteps.finalizarWebDriver();
    }

    @Test(description = "Prueba visibilidad del botón Visible after 5 Seconds")
    public void buttonVisibleAfter() {
        dynamicWaitsSteps.abrirPaginaDinamico();
        dynamicWaitsSteps.waitButtonVisibleExplicit();
        dynamicWaitsSteps.finalizarWebDriver();
    }

}
