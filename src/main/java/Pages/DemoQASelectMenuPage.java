package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoQASelectMenuPage{

    //Aqui van todos los localizadores
    @FindBy(id = "oldSelectMenu")//By Page factory
    private WebElement listaColores;

    @FindBy(id = "cars")//By Page factory
    private WebElement listaCarros;

    public WebElement getListaColores(){//gets son publics
        return listaColores;
    }

    public WebElement getListaCarros(){
        return listaCarros;
    }
}
