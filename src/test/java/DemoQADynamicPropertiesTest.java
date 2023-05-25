
import Steps.DemoQADynamicPropertiesSteps;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class DemoQADynamicPropertiesTest extends BaseTest{
    private WebDriver webDriver = getWebDriver();

    private DemoQADynamicPropertiesSteps demoQADynamicPropertiesSteps = new DemoQADynamicPropertiesSteps(webDriver);

    @Test(description="Boton disponible en 5 segundos")
    public void visibleAfter5SecondsTest(){
        demoQADynamicPropertiesSteps.abrirPaginaDynamicProperties();
        demoQADynamicPropertiesSteps.waitVisibleElement();
        demoQADynamicPropertiesSteps.finalizarWebDriver();
    }

    @Test(description="Cambiar fuente en 5 segundos")
    public void changeFontAfter5SecondsTest(){
        demoQADynamicPropertiesSteps.abrirPaginaDynamicProperties();
        demoQADynamicPropertiesSteps.waitChangeFontColor();
        demoQADynamicPropertiesSteps.finalizarWebDriver();
    }
}