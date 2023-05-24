import Steps.CalendarioWaitsSteps;
import Steps.DynamicPropertiesSteps;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class DynamicPropertyTest extends BaseTest{
    private WebDriver webDriver = getWebDriver();

    private DynamicPropertiesSteps dynamicPropertiesSteps = new DynamicPropertiesSteps(webDriver);

    @Test(description="Boton visible despues de 5 segundos")
    public void visibleAfter5SecondsTest(){
        dynamicPropertiesSteps.abrirPaginaDynamicProperties();
        dynamicPropertiesSteps.waitVisibleElement();
        dynamicPropertiesSteps.finalizarWebDriver();
    }

    @Test(description="Cambiar el font despues de 5 segundos")
    public void changeFontAfter5SecondsTest(){
        dynamicPropertiesSteps.abrirPaginaDynamicProperties();
        dynamicPropertiesSteps.waitChangeFontColor();
        dynamicPropertiesSteps.finalizarWebDriver();
    }
}


