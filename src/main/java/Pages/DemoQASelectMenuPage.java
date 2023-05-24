package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoQASelectMenuPage extends BasePage{

    public DemoQASelectMenuPage(WebDriver webDriver){
        super(webDriver);
    }

    private WebElement setlistaColores(){
        return webDriver.findElement(By.id("oldSelectMenu"));
    }

    public WebElement getListaColores(){
        return setlistaColores();
    }

    private WebElement setListaCarros(){
        return webDriver.findElement(By.id("cars"));
    }

    public WebElement getListaCarros(){
        return setListaCarros();
    }
}
