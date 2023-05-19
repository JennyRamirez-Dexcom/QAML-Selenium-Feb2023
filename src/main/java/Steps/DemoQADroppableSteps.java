package Steps;

import Pages.DemoQADroppablePage;
import org.openqa.selenium.WebDriver;

public class DemoQADroppableSteps extends BaseSteps{
    private DemoQADroppablePage demoQADroppablePage = new DemoQADroppablePage(webDriver);

    public DemoQADroppableSteps(WebDriver driver) {
        super(driver);
    }

    public void gettoDemoblazePage(){
        webDriver.get("https://demoqa.com/droppable");
    }

    public void dragAndDrop() {
        dragAndDropElement(demoQADroppablePage.getDivDragabble(), demoQADroppablePage.getDivContainer());
    }

    public String getDroppedPElementText(){
        return demoQADroppablePage.getPDroppedElement().getText();
    }
}
