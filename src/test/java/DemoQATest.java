import Steps.DemoQADroppableSteps;
import Steps.DemoQASteps;
import Steps.GoogleSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoQATest extends BaseTest{
    private WebDriver webDriver = getWebDriver();
    private DemoQASteps demoQASteps = new DemoQASteps(webDriver);
    private DemoQADroppableSteps demoQaDroppableSteps = new DemoQADroppableSteps(webDriver);
    private String demoQADroppedMessage= "Dropped!";


    @BeforeTest(description = "Precondiciones para las pruebas de DemoQATest",
    alwaysRun = true)
    public void beforeDemoQATests() {
        // 1. Abra https://demoqa.com/text-box/
        demoQASteps.imprimir("@BeforeTest");
        demoQASteps.abrirPaginaDemoQA();
        demoQASteps.maximizarVentana();
    }

    @Test(description = "Test para llenar formulario", priority = 1,groups = {"SmokeTest"})
    public void practica2(){
    // Completa el formulario
        demoQASteps.fillForm();

    //Close driver
        //demoQASteps.cerrarVentana();
    }

    @Test (priority = 1)
    public void practica_2(){
        demoQASteps.enviarFullName("Moises Lopez Garcia");
        demoQASteps.enviarEmail("moylop1996@qamindlab.com");
        demoQASteps.enviarCurrentAddress("Calle 1, Colonia 2, 12345");
        demoQASteps.enviarPermanentAddress("Calle Permanente, Colonia Permanente, 67890");
    }



    @Test(description = "Test para arrastrar un div y soltarlo en otro div", priority = 3)
    public void practica6ActionsTest() {
        demoQASteps.abrirDroppablePage();
        demoQASteps.dragAndDrop();
    }

    @AfterTest(description = "Metodo para ejecutar despues de cualquier test",
    alwaysRun = true)
    public void afterDemoQATests() {
        demoQASteps.imprimir("@AfterTest");
        demoQASteps.finalizarWebDriver();
    }

}
