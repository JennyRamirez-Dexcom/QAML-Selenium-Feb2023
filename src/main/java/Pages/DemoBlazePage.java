package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DemoBlazePage extends BasePage{
    By menuOptions = By.xpath("//a[@id='itemc']");

    public DemoBlazePage(WebDriver webdriver) {
        super(webdriver);
    }

    public List<WebElement> findDemoBlazeMenuOptionsList(){
        return webdriver.findElements(menuOptions);
    }


}
