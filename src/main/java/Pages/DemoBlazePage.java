package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DemoBlazePage {

    @FindBy (xpath = "//a[@id='itemc']")
    private List<WebElement> menuOptions;

    public List<WebElement> findDemoBlazeMenuOptionsList(){
        return menuOptions;
    }


}
