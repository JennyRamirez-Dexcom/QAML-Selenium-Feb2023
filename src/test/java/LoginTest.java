import Steps.PracticeAutomationSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private WebDriver webDriver = getWebDriver(); //aquí voy a volver a crear un webdrive privado, aqui se reutiliza nuevamente del BaseTest
    private PracticeAutomationSteps loginSteps = new PracticeAutomationSteps(webDriver);

    @Test
    public void loginTest() {
        //Abra la página
        loginSteps.abrirPracticaLogin();
        //Escriba el nombre de usuario estudiante en el campo Nombre de usuario
        loginSteps.ingresarUsuario("student");
        //Escriba la contraseña Password123 en el campo Contraseña
        loginSteps.ingresarPassword("Password123");
        //Puch botón Enviar
        loginSteps.clickIngresa();

        //Verifique que la URL de la nueva página contenga "Practicetestautomation.com/logged-in-successfully/"
        String urlEsperada = "https://practicetestautomation.com/logged-in-successfully/";
        String urlActual = loginSteps.getURLActual();
        loginSteps.imprimir(urlActual);
        Assert.assertEquals(urlActual, urlEsperada);

        //Verifique que la nueva página contenga el texto esperado ('Felicitaciones' o 'inicio de sesión exitoso')
        String textoEsperado = "Congratulations student. You successfully logged in!";
        String textoActual = loginSteps.obtenerTextoMensaje();
        loginSteps.imprimir(textoActual);
        Assert.assertEquals(textoActual, textoEsperado);

        //Verifique que el botón Cerrar sesión se muestre en la nueva página
        boolean botonActual = loginSteps.botonLogOutVisible();
        Assert.assertTrue(botonActual);
        //loginSteps.finalizarWebDriver();
    }
}

