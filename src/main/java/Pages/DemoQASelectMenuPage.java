package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoQASelectMenuPage {

    @FindBy (id = "oldSelectMenu")
    private  WebElement listaColores;

    @FindBy (id = "cars")
    private WebElement listaCarros;

    public WebElement getListaColores(){
        return listaColores;
    }

    public WebElement getListaCarros(){
        return listaCarros;
    }
}
