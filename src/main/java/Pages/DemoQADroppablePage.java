package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoQADroppablePage{

    //Aqui van todos los localizadores
    @FindBy(xpath = "//div[@id='draggable']")//By Page factory
    private WebElement divDraggable;

    @FindBy(xpath = "//div[@id='simpleDropContainer']/div[@id='droppable']")//By Page factory
    private WebElement divDroppable;

    public WebElement getDivDraggable() {
        return divDraggable;
    }

    public WebElement getDivDroppable() {
        return divDroppable;
    }
}
