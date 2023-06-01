package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalendarioWaitsPage {
    @FindBy(xpath = "//td[@title='Monday, May 22, 2023']")
    private WebElement tdMay22;

    @FindBy(xpath = "//span[text()='Monday, May 22, 2023']")
    private WebElement spanMay22;

    @FindBy(xpath = "//*[@id='visibleAfter']")
    private WebElement boxEnable;

    @FindBy(xpath = "//*[@id='colorChange']")
    private WebElement colorChange;

    public WebElement getTdMay22() {
        return tdMay22;
    }

    public WebElement getSpanMay22() {
        return spanMay22;
    }

    public WebElement getBoxEnable(){
        return boxEnable;
    }
    public WebElement getColorChange(){
        return colorChange;
    }
}