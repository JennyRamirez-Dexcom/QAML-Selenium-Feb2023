package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalendarioWaitsPage {
    @FindBy(xpath = "//td[@title = 'Monday, May 22, 2023']")
    private WebElement tdMayo22;

    @FindBy(xpath = "//span[text() = 'Monday, May 22, 2023']")
    private WebElement spanMayo22;

    public WebElement getTdMayo22(){
        return tdMayo22;
    }

    public WebElement getSpanMayo22(){
        return spanMayo22;
    }
}
