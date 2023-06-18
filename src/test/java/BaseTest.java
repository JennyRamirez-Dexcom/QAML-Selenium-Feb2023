import Pages.BasePage;
import Utilities.DriverSetup;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    DriverSetup driver;
    private BasePage basePage;

    @BeforeTest(description = "Configuración de precondiciones para ejecución de pruebas", alwaysRun = true)
    public void beforeTest() {
        driver = new DriverSetup();
        basePage = new BasePage(driver.getWebDriver());
    }

    @AfterTest(description = "Método creado para cerrar el navegador", alwaysRun = true)
    public void endTest() {
        basePage.end();
    }
}
