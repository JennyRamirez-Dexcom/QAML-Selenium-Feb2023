package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoQADroppablePage extends BasePage {
//    public DemoQADroppablePage(WebDriver webDriver) {
//        super(webDriver);
//    }

    @FindBy(xpath = "//div[@id='draggable']")
    private WebElement divDraggable;

    @FindBy(xpath = "//div[@id='simpleDropContainer']/div[@id='droppable']")
    private WebElement divDroppable;

    public WebElement getDivDraggable() {
        return divDraggable;
    }

    public WebElement getDivDroppable() {
        return divDroppable;
    }
}
