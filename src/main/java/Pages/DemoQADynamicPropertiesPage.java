package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoQADynamicPropertiesPage {

    @FindBy(xpath = "//*[@id='colorChange']")
    private WebElement colorChangedButton;

    @FindBy(xpath = "//*[@id='visibleAfter']")
    private WebElement visibleAfter5SecondsButton;

    public WebElement getColorChangedButton(){
        return colorChangedButton;
    }

    public WebElement getVisibleAfter5SecondsButton(){
        return visibleAfter5SecondsButton;
    }
}
