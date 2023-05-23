package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoQADroppablePage extends BasePage{

    By dragElement =By.xpath("//div[@id='draggable']");
    By divContainer =By.xpath("//div[@id='simpleDropContainer']/div[2]");
    By droppedText = By.xpath("(//div[@id='droppable'])[1]/p");

    public DemoQADroppablePage(WebDriver webdriver) {
        super(webdriver);
    }

    private WebElement setDragMeElement(){
        return webdriver.findElement(dragElement);
    }

    public WebElement getDivDragabble(){
        return setDragMeElement();
    }

    private WebElement setDivDroppable(){
        return webdriver.findElement(divContainer);
    }

    public WebElement getDivContainer(){
        return setDivDroppable();
    }

    private WebElement setDroppedText() {
        return webdriver.findElement(droppedText);
    }

    public WebElement getPDroppedElement() {
        return setDroppedText();
    }


}
