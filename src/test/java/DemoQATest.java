import Steps.DemoQASteps;
import Steps.GoogleSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoQATest extends BaseTest{
    private WebDriver webDriver = getWebDriver();
    private DemoQASteps demoQASteps = new DemoQASteps(webDriver);

//    @Test
//    public void practica1() {
//        //1.Abrir DemoQA
//        demoQASteps.abrirPaginaDemoQA();
//
//        //2. Verifica que tengamos la URL correcta
//        String urlActual = demoQASteps.getURLActual();
//        System.out.println("La URL Actual es: " + urlActual);
//        Assert.assertEquals(urlActual, "https://demoqa.com/text-box/");
//
//        //3. Compruebe si se muestra el cuadro de texto Nombre completo
//        boolean fullName = demoQASteps.checkFullNameEmailIsDisplayed();
//        demoQASteps.assertBooleanEquals(fullName, true);
//
//        //4. Compruebe si se muestra el cuadro de texto de correo electrónico
//        boolean email = demoQASteps.checkEmailIsDisplayed();
//        demoQASteps.assertBooleanEquals(email, true);
//
//        //5. Compruebe si se muestra el cuadro de texto Dirección actual
//        boolean currentAddress = demoQASteps.checkCurrentAddressIsDisplayed();
//        demoQASteps.assertBooleanEquals(currentAddress, true);
//
//        //6. Compruebe si se muestra la dirección permanente
//        boolean permanentAddress = demoQASteps.permanentAddressIsDisplayed();
//        demoQASteps.assertBooleanEquals(permanentAddress, true);
//
//        //7. Compruebe si el botón Enviar está habilitado
//        boolean submitEnabled = demoQASteps.submitEnabled();
//        demoQASteps.assertBooleanEquals(submitEnabled, true);
//
//        //Close driver
//        demoQASteps.cerrarVentana();
//    }

    @Test
    public void practica2(){
    // 1. Abra https://demoqa.com/text-box/
        demoQASteps.abrirPaginaDemoQA();

    // Completa el formulario
        demoQASteps.fillForm();

    //Close driver
        //demoQASteps.cerrarVentana();
    }

    @Test
    public void practica_2(){
        demoQASteps.abrirPaginaDemoQA();
        demoQASteps.enviarFullName("Moises Lopez Garcia");
        demoQASteps.enviarEmail("moylop1996@qamindlab.com");
        demoQASteps.enviarCurrentAddress("Calle 1, Colonia 2, 12345");
        demoQASteps.enviarPermanentAddress("Calle Permanente, Colonia Permanente, 67890");
        //demoQASteps.clickSubmit();
        //demoQASteps.cerrarVentana();
    }

    @Test
    public void practica4_Select(){
        demoQASteps.abrirPaginaDemoQA();
        demoQASteps.navegarSelectMenuPage();
        demoQASteps.seleccionarColorPorText("Yellow"); //toeme q estar igual que en la página HTML
        demoQASteps.imprimir(demoQASteps.getColorSeleccionado());

        //imprimir todas las opciones con value
        demoQASteps.imprimirValoresOpcionesColoresDisponibles();

        //imprimir todas las opciones de colores, lo hace con for each
        demoQASteps.imprimirOpcionesDisponibles();

       //selección por index
        demoQASteps.seleccionarColorPorIndex(1); //se va a seleccionar el color azul.
        demoQASteps.imprimir(demoQASteps.getColorSeleccionado());

        //selección por value
        demoQASteps.seleccionarColorPorValue("3");
        demoQASteps.imprimir(demoQASteps.getColorSeleccionado());

    }

    @Test
    public void practica4_select_multiples(){
        demoQASteps.abrirPaginaDemoQA();
        demoQASteps.navegarSelectMenuPage();
        demoQASteps.imprimirOpcionesCarrosDisponibles();
        //demoQASteps.finalizarWebDriver();
    }
}
