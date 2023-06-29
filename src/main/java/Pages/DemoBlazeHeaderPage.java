package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoBlazeHeaderPage {

    @FindBy (css = "a[id='cartur']")
    private WebElement cartMenuOotion;

    public WebElement getCartMenuOotion() {
        return cartMenuOotion;
    }
}
