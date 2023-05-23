package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;

public class DemoQADroppablePage extends BasePage{

    //By dragElement =By.xpath("//div[@id='draggable']");
    //By divContainer =By.xpath("//div[@id='simpleDropContainer']/div[2]");
    //By droppedText = By.xpath("(//div[@id='droppable'])[1]/p");

    //This replace the set method and is call in the get suing directly the element
    @FindBy (xpath = "//div[@id='draggable']")
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
