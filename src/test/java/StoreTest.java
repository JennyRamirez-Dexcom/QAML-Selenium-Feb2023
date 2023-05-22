import Steps.BaseSteps;
import Steps.StoreSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class StoreTest extends BaseTest{
    private WebDriver driver = getWebDriver();
    private StoreSteps storeSteps = new StoreSteps(driver);

    @Test
    public void practica5(){
        storeSteps.abrirPaginaDemoBlaze();
        List<WebElement> lista = storeSteps.imprimirCategorias();
        List<WebElement> listaesperada = storeSteps.obtenerCategorias();
        Assert.assertEquals(lista, listaesperada);
        storeSteps.finalizarWebDriver();
    }
}
