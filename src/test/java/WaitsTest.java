import Steps.CalendarioWaitsSteps;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class WaitsTest extends BaseTest{
    private WebDriver webDriver = getWebDriver();
    CalendarioWaitsSteps calendarioWaitsSteps = new CalendarioWaitsSteps(webDriver);

    @Test(description = "Prueba de Fluent Wait en calendario para la fecha de hoy")
    public void calendarioWaitTest(){
        calendarioWaitsSteps.abrirPaginaCalendario();
        calendarioWaitsSteps.maximizarVentana();
        calendarioWaitsSteps.clickMay22();
        calendarioWaitsSteps.waitFechaSeleccionada();
        calendarioWaitsSteps.finalizarWebDriver();
    }

    @Test(description = "Prueba de Explicit Wait Wait en calendario para la fecha de hoy")
    public void calendarioExplicitWaitTest(){
        calendarioWaitsSteps.abrirPaginaCalendario();
        calendarioWaitsSteps.maximizarVentana();
        calendarioWaitsSteps.clickMay22();
        calendarioWaitsSteps.waitFechaSeleecionadaExplicito();
        calendarioWaitsSteps.finalizarWebDriver();
    }
}
