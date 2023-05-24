import Steps.GoogleSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {
    private WebDriver webDriver = getWebDriver();
    private GoogleSteps googleSteps = new GoogleSteps(webDriver);

    @Test
    public void openGoogleTest() {
        googleSteps.abrirPaginaGoogle();
        String urlActual = googleSteps.getURLActual();
        System.out.println("La URL actual es: " + urlActual);
        Assert.assertEquals(urlActual, "https://www.google.com/");
    }

    @Test
    //Ejercicio 2 - Tarea 3
    public void titleGoogleTest() {
        googleSteps.abrirPaginaGoogle();
        String currentTittle= googleSteps.getTituloActual();
        Assert.assertEquals(currentTittle, "Google");

    }

    @Test
    public void metodoNavigateTest() {
        String urlExpected = "https://www.google.com/";
        googleSteps.abrirPaginaGoogle();
        String urlActual = googleSteps.getURLActual();
        googleSteps.imprimir(urlActual);
        Assert.assertEquals(urlActual, urlExpected); //Hard assert

        String tituloExpectedFacebook = "Facebook - log in or sign up";
        googleSteps.navegarPaginaFacebook();
        String tituloActualFacebook = googleSteps.getTituloActual();
        googleSteps.imprimir(tituloActualFacebook);
        Assert.assertEquals(tituloActualFacebook, tituloExpectedFacebook);

        googleSteps.navegarPaginaESPN();
        String urlEsperada = "https://www.espn.com.mx/";
        String urlESPN = googleSteps.getURLActual();
        googleSteps.imprimir(urlESPN);
        Assert.assertEquals(urlESPN, urlEsperada);

        webDriver.navigate().back();
        googleSteps.imprimir(tituloActualFacebook);
        Assert.assertEquals(tituloActualFacebook, tituloExpectedFacebook);

    }

    @Test
    public void enviarBusquedaGoogle() {
        googleSteps.abrirPaginaGoogle();
        googleSteps.enviarBusquedaEnGoogle("selenium");
        //googleSteps.clickBuscar();
        googleSteps.enviarEnter();
    }

    @AfterTest
    public void closeBrowser(){
        googleSteps.cerrarVentana();
    }

}
