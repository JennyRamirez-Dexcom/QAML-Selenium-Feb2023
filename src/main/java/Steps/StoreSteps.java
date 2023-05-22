package Steps;

import Pages.StorePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class StoreSteps extends BaseSteps{
    public StoreSteps (WebDriver driver){
        super(driver);
    }

    StorePage storePage = PageFactory.initElements(webDriver, StorePage.class);

    public void abrirPaginaDemoBlaze(){
        webDriver.get("https://www.demoblaze.com/");
    }

    public List<WebElement> imprimirCategorias(){
        for (WebElement webElement: storePage.getCategories()){
            String categoria = webElement.getText();
            System.out.println(categoria);
        }
        return null;
    }

    public List<WebElement> obtenerCategorias(){
        for (WebElement webElement: storePage.getCategories()){
            String categoria = webElement.getText();
        }
        return null;
    }
}
