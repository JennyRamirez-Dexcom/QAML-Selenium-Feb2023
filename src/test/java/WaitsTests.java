import Steps.CalendarioWaitsSteps;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class WaitsTests extends BaseTest {
    private WebDriver webDriver = getWebDriver();
    CalendarioWaitsSteps calendarioWaitsSteps = new CalendarioWaitsSteps(webDriver);

    @Test(description = "Prueba de Fluent Wait en Calendario para la fecha de hoy Mayo 22")
    public void calendarioWaitTest() {
        calendarioWaitsSteps.abrirPaginaCalendario();
        calendarioWaitsSteps.clickMay22();
        //Fluent Wait
        calendarioWaitsSteps.waitFechaSeleccionada();
        calendarioWaitsSteps.finalizarWebDriver();
    }

    @Test(description = "Prueba de Explicit Wait en Calendario para la fecha de hoy Mayo 22")
    public void calendarioExplicitWaitTest() {
        calendarioWaitsSteps.abrirPaginaCalendario();
        calendarioWaitsSteps.clickMay22();
        //Explicit Wait
        calendarioWaitsSteps.waitFechaSeleccionadaExplicit();
        calendarioWaitsSteps.finalizarWebDriver();
    }
}