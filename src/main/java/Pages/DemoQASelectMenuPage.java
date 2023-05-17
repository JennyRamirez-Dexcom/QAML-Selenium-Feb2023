package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoQASelectMenuPage extends BasePage {

    public DemoQASelectMenuPage(WebDriver _webDriver) {
        super(_webDriver);
    }

    private WebElement SetlistaColores(){ //Método encapsulado
        return webDriver.findElement(By.id("oldSelectMenu"));
    }

    public WebElement getListaColores(){ //lo utilizo en DemoQA
        return SetlistaColores();
    }

    private WebElement setListaCarros(){
        return webDriver.findElement(By.id("cars"));
    }

    public WebElement getListaCarros(){
        return setListaCarros();
    }

}
