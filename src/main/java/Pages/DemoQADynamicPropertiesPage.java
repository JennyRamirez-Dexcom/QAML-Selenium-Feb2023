package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoQADynamicPropertiesPage {

    @FindBy  (xpath = "//button[@id='colorChange']")
    private WebElement colorchangeButton;

    @FindBy (id = "visibleAfter")
    private WebElement visibleAfter5SecondsButton;

    public WebElement getColorchangeButton() {
        return colorchangeButton;
    }

    public WebElement getVisibleAfter5SecondsButton() {
        return visibleAfter5SecondsButton;
    }


}
