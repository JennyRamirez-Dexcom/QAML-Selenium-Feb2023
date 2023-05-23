import Steps.CalendarioWaitSteps;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class WaitTest extends BaseTest{

    private WebDriver webDriver = getWebDriver();
    CalendarioWaitSteps calendarioWaitSteps = new CalendarioWaitSteps(webDriver);

    @Test(description = "Test Wait")
    public void selectMay22Test(){
        calendarioWaitSteps.abrirPaginaCalendario();
        calendarioWaitSteps.clickMay22();
        calendarioWaitSteps.waitFechaSeleccionada();
        calendarioWaitSteps.finalizarWebDriver();
    }

    @Test(description = "Test Wait")
    public void selectMay22ExplicitWaitTest(){
        calendarioWaitSteps.abrirPaginaCalendario();
        calendarioWaitSteps.clickMay22();
        calendarioWaitSteps.waitFechaSeleccionadaExplicit();
        calendarioWaitSteps.finalizarWebDriver();
    }




}
