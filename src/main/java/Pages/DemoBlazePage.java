package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.*;

public class DemoBlazePage extends BasePage{
    public DemoBlazePage(WebDriver _webDriver) {
        super(_webDriver);
    }

    //Aqui van todos los localizadores

    private List<WebElement> setCategories(){
        return webDriver.findElements(By.xpath("//a[@id='itemc']"));
    }

    public List<WebElement> getCategories(){
        return setCategories();
    }
}
