package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DemoBlazePage extends BasePage{


    public DemoBlazePage(WebDriver webDriver){
        super(webDriver);
    }



    private List<WebElement> setElementsList(){
        return webDriver.findElements(By.xpath("//*[@class='list-group']//descendant::a[@id='itemc']"));
        //lista = webDriver.findElements(By.xpath("//*"));
    }

    public List<WebElement> getElementsList(){
        return setElementsList();
    }
}
