package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DemoBlazeShoppingCartPage {

    @FindBy (xpath = "//tr[@class='success']")
    private List<WebElement> shoppingCartDevicesList;
    @FindBy (xpath = "//button[@data-target='#orderModal']")
    private WebElement placeOrderBtn;
    @FindBy (xpath = "//a[@href='#' and contains(text(),'Delete') ]")
    private List<WebElement>  deleteOptions;
    @FindBy (xpath = "//a[@href='#' and contains(text(),'Delete') ]")
    private WebElement  deleteOption;
    @FindBy (xpath = "//tr[@class='success']//img")
    private WebElement deviceImage;
    @FindBy (css = "#totalp")
    private WebElement orderTotalValue;
    @FindBy (xpath = "//tr[@class='success']//td[3]")
    List<WebElement> valuesList;


    public List<WebElement> getShoppingCartDevicesList() {
        return shoppingCartDevicesList;
    }

    public WebElement getPlaceOrderBtn() {
        return placeOrderBtn;
    }

    public List<WebElement> getDeleteOptions() {
        return deleteOptions;
    }

    public WebElement getDeleteOption() {
        return deleteOption;
    }

    public WebElement getDeviceImage() {
        return deviceImage;
    }

    public WebElement getOrderTotalValue() {
        return orderTotalValue;
    }

    public List<WebElement> getValuesList() {
        return valuesList;
    }
}
