package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoQADroppablePage extends BasePage {
    public DemoQADroppablePage(WebDriver webDriver) {
        super(webDriver);
    }

    private WebElement setDivDraggable() {
        return webDriver.findElement(By.xpath("//div[@id='draggable']"));
    }

    private WebElement setDivDroppable() {
        return webDriver.findElement(By.xpath("//div[@id='simpleDropContainer']/div[@id='droppable']"));
    }

    private WebElement setDroppedText(){
        return  webDriver.findElement(By.xpath("//p[text()='Dropped!']"));
    }

    public WebElement getDivDraggable() {
        return setDivDraggable();
    }

    public WebElement getDivDroppable() {
        return setDivDroppable();
    }

    public WebElement getDroppedText(){
        return setDroppedText();
    }
}
