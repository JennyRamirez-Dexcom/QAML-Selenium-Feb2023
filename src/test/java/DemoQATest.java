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

    @BeforeTest(description = "Precondiciones para las pruebas de DemoQATest", alwaysRun = true)
    public void  beforeDemoQATest(){
        demoQASteps.imprimir("@BeforeTest");
        demoQASteps.abrirPaginaDemoQA();
        demoQASteps.maximizarVentana();
    }

    @Test (description = "Test para llenar formulario", groups = {"SmokeTest"})
    public void practica2(){
        demoQASteps.fillForm();
    }

    @Test
    public void practica_2(){
        demoQASteps.enviarFullName("Moises Lopez Garcia");
        demoQASteps.enviarEmail("moylop1996@qamindlab.com");
        demoQASteps.enviarCurrentAddress("Calle 1, Colonia 2, 12345");
        demoQASteps.enviarPermanentAddress("Calle Permanente, Colonia Permanente, 67890");
    }

    @Test(priority = 2)
    public void practica4_Select(){
        demoQASteps.navegarSelectMenu();

        demoQASteps.imprimirOpcionesColoresDisponibles();

        demoQASteps.imprimir("Imprimir atributo Value:");
        demoQASteps.imprimirValoresOpcionesColoresDisponibles();

        demoQASteps.selecccionarColorPorTexto("Yellow");
        demoQASteps.imprimir(demoQASteps.getColorSeleccionado());

        demoQASteps.seleccionarColorPorValue("2");//Green
        demoQASteps.imprimir(demoQASteps.getColorSeleccionado());

        demoQASteps.seleccionarColorPorIndex(4);//Purple
        demoQASteps.imprimir(demoQASteps.getColorSeleccionado());
    }

    @Test(priority = 2)
    public void practica4_select_multiple(){
        demoQASteps.navegarSelectMenu();
        demoQASteps.scrollHaciaListaCarros();
        demoQASteps.imprimirOpcionesCarrosDisponibles();
    }

    @Test(description = "Test para arrastrar un div y soltarlo en otro div", priority = 1)//prioridad entre mas grande lo correra al final
    public void practica6ActionsTest() {
        demoQASteps.abrirDroppablePage();
        demoQASteps.dragAndDrop();
    }

    @AfterTest(description = "Metodo para ejecutar despues de cualquier test", alwaysRun = true)
    public void afterDemoQATest(){
        demoQASteps.imprimir("@AfterTest");
        demoQASteps.finalizarWebDriver();
    }
}
