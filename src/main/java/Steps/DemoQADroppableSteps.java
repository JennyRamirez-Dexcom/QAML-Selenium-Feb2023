package Steps;

import Pages.DemoQADroppablePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DemoQADroppableSteps extends BaseSteps{
    //private DemoQADroppablePage demoQADroppablePage = new DemoQADroppablePage(webDriver);
    DemoQADroppablePage  demoQADroppablePage= PageFactory.initElements(webDriver, DemoQADroppablePage.class);

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
