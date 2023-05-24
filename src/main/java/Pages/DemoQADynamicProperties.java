package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoQADynamicProperties {
    @FindBy(id = "colorChange")
    private WebElement colorChangeButton;

    @FindBy(id = "visibleAfter")
    private WebElement visibleAfterButton;

    public WebElement getcolorChangeButton(){
        return colorChangeButton;
    }

    public WebElement getVisibleAfterButton(){
        return visibleAfterButton;
    }
}

// $x("//*[@id='colorChange']")
// $x("//*[@id='visibleAfter']")

