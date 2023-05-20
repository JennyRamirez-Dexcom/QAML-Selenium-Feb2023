import Steps.DemoBlazeSteps;
import Steps.DemoQASteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DemoBlazeTest extends BaseTest{
    private WebDriver webDriver = getWebDriver();
    private DemoBlazeSteps demoBlazeSteps = new DemoBlazeSteps(webDriver);

    @Test
    public void practica5(){
        demoBlazeSteps.abrirPaginaDemoBlaze();
        List<WebElement> lista = demoBlazeSteps.imprimirCategorias();
        List<WebElement> listaesperada = demoBlazeSteps.obtenerCategorias();
        Assert.assertEquals(lista, listaesperada);
        demoBlazeSteps.finalizarWebDriver();
    }
}
