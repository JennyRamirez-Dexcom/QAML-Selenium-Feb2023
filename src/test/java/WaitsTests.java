import Steps.CalendarioWaitsSteps;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class WaitsTests extends BaseTest {
    private WebDriver webDriver = getWebDriver();
    CalendarioWaitsSteps calendarioWaitsSteps = new CalendarioWaitsSteps(webDriver);
    @Test
    public void calendarioWaitTest() {
        calendarioWaitsSteps.abrirPaginaCalendario();
        calendarioWaitsSteps.clickMay22();
        calendarioWaitsSteps.waitFechaSeleccionada();
        calendarioWaitsSteps.finalizarWebDriver();
    }
    @Test
    public void calendarioExplicitWaitTest() {
        calendarioWaitsSteps.abrirPaginaCalendario();
        calendarioWaitsSteps.clickMay22();
        calendarioWaitsSteps.waitFechaSeleccionadaExplicit();
        calendarioWaitsSteps.finalizarWebDriver();
    }

}
