package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DemoBlazeShoppingCartPage {

    @FindBy (css = "tr[class='success']")
    private List<WebElement> shoppingCartDevicesList;
    @FindBy (xpath = "//button[@data-target='#orderModal']")
    private WebElement placeOrderBtn;

    public List<WebElement> getShoppingCartDevicesList() {
        return shoppingCartDevicesList;
    }

    public WebElement getPlaceOrderBtn() {
        return placeOrderBtn;
    }
}
