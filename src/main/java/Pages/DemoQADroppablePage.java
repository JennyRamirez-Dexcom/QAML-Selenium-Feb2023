package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoQADroppablePage extends BasePage{

    @FindBy(xpath = "//div[@id='draggable']")
    private WebElement dragElement;

    @FindBy (xpath = "//div[@id='simpleDropContainer']/div[2]")
    private WebElement divContainer;

    @FindBy (xpath = "(//div[@id='droppable'])[1]/p")
    private WebElement droppedText;

    public DemoQADroppablePage(WebDriver webdriver) {
        super(webdriver);
    }


    public WebElement getDivDragabble(){
        return dragElement;
    }


    public WebElement getDivContainer(){
        return divContainer;
    }


    public WebElement getPDroppedElement() {
        return droppedText;
    }

}
