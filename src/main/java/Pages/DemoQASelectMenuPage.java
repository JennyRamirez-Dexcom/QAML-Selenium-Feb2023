package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoQASelectMenuPage extends BasePage{


    public DemoQASelectMenuPage(WebDriver _webDriver){
        super(_webDriver);
    }

//    public DemoQASelectMenuPage(WebDriver _webDriver){
//        super(_webDriver);
//    }

  /*  private WebElement setlistaColores(){
        WebDriver webDriver;
        return webDriver.findElement(By.id("oldSelectMenu"));
    }
*/

    @FindBy(id = "oldSelectMenu")
    private WebElement listaColores;

    @FindBy(id = "cars")
    private WebElement listaCarros;

    public WebElement getListaColores(){
        return listaColores;
    }

    public WebElement getListaCarros(){
        return listaCarros;
    }
}
