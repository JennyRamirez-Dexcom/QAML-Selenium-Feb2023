import Steps.CalendarioWaitSteps;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class WaitsTest extends BaseTest {
    private WebDriver webDriver = getWebDriver();
    CalendarioWaitSteps calendarioWaitSteps = new CalendarioWaitSteps(webDriver);

    @Test(description = "Prueba de Fluent Wait en Calendario para la fecha de hoy")
    public void calendarioWaitTest() {
        calendarioWaitSteps.abrirPaginaCalendario();
        calendarioWaitSteps.clickMay22();
    }
}
