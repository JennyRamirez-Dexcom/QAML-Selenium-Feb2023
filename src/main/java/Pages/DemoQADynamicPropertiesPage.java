package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoQADynamicPropertiesPage {
    @FindBy(xpath = "//button[contains(@class,'text-danger')]")
    private WebElement btnRedColor;

    @FindBy(xpath = "//button[@id='colorChange']")
    private WebElement btnWhiteColor;

    @FindBy(xpath = "//button[@id='visibleAfter']")
    private WebElement btnVisibleAfter5;

    public WebElement getBtnRedColor(){
        return btnRedColor;
    }

    public WebElement getBtnWhiteColor(){
        return btnVisibleAfter5;
    }

    public WebElement getBtnVisibleAfter5(){
        return btnVisibleAfter5;
    }
}
