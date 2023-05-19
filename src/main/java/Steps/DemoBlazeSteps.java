package Steps;

import Pages.DemoBlazePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DemoBlazeSteps extends BaseSteps{

    private DemoBlazePage demoBlazePage = new DemoBlazePage(webDriver);

    public DemoBlazeSteps(WebDriver driver) {
        super(driver);
    }

    public void gettoDemoblazePage(){
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
