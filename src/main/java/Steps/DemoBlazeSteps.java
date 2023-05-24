package Steps;

import Pages.DemoBlazePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DemoBlazeSteps extends BaseSteps{

    private DemoBlazePage demoBlazePage = PageFactory.initElements(webDriver,DemoBlazePage.class);

    public DemoBlazeSteps(WebDriver driver) {
        super(driver);
    }

    public void gettoDemoblazePage(){
        System.out.println("Test get to page https://www.demoblaze.com/");
        webDriver.get("https://www.demoblaze.com/");
    }

    private List<WebElement> getMenuoptionsList(){
        return demoBlazePage.findDemoBlazeMenuOptionsList();
    }

    public int  countMenuOptions(){
        return getMenuoptionsList().size();
    }

    public void printMenuOptions(){
        List<WebElement> listaMenu =  getMenuoptionsList();
        for(WebElement menuOption:listaMenu){
            imprimir(menuOption.getText());
        }
    }
}
