package Steps;

import Pages.DemoBlazePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DemoBlazeSteps extends BaseSteps{
    public DemoBlazeSteps(WebDriver driver) {
        super(driver);
    }

    DemoBlazePage demoBlazePage = new DemoBlazePage(webDriver);

    public void abrirPaginaDemoBlaze(){
        webDriver.get("https://www.demoblaze.com/");
    }

    public List<WebElement> imprimirCategorias(){
        for (WebElement webElement: demoBlazePage.getCategories()){
            String categoria = webElement.getText();
            System.out.println(categoria);
        }
        return null;
    }

    public List<WebElement> obtenerCategorias(){
        for (WebElement webElement: demoBlazePage.getCategories()){
            String categoria = webElement.getText();
        }
        return null;
    }
}
