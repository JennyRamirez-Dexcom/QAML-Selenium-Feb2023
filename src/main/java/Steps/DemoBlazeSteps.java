package Steps;

import Pages.DemoBlazePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class DemoBlazeSteps extends BaseSteps{
    public DemoBlazeSteps(WebDriver driver) {

        super(driver);
    }

    DemoBlazePage demoBlazePage = new DemoBlazePage(webDriver);


    public void abrirPaginaDemoBlaze(){
        webDriver.get("https://www.demoblaze.com/");

        imprimir("Navegando en DemoBlaze");
    }

    public void selectList(){
       List<WebElement> lista = demoBlazePage.getElementsList();
       imprimir(String.valueOf(lista.isEmpty()));
       String values[] = new String[3];
       values[0] = "Phones";
       values[1] = "Laptops";
       values[2] = "Monitors";
       int contador = 0;
        for (WebElement o: lista
             ) {
            imprimir(o.getText());
            Assert.assertEquals(values[contador++],o.getText());

        }
    }

}
