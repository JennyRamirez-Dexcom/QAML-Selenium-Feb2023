import Steps.DemoQADynamicPropertiesSteps;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoQADynamicPropertiesTest extends BaseTest{
    private WebDriver webDriver = getWebDriver();

    DemoQADynamicPropertiesSteps demoQADynamicPropertiesSteps = new DemoQADynamicPropertiesSteps(webDriver);

    @BeforeTest
    public void beforeScenarios(){
        demoQADynamicPropertiesSteps.abrirQADynamicPropertiesPage();
        demoQADynamicPropertiesSteps.maximizarVentana();
    }
    @Test(description = "Espera que que el boton cambie de color de letra utilizando FluentWait")
    public void botonCambiaColorLetraTest(){
        demoQADynamicPropertiesSteps.waitButtonChangeColor();
    }

    @Test(description = "Espera que que el boton sea visible utilizando ExplicitWait")
    public void botonVisibleDespuesDe5Test(){
        demoQADynamicPropertiesSteps.waitButtonIsVisible();
    }

    @AfterTest
    public void afterScenarios(){
        demoQADynamicPropertiesSteps.finalizarWebDriver();
    }
}
