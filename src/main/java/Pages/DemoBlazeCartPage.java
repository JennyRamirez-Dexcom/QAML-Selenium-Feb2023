package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DemoBlazeCartPage {
    @FindBy(xpath = "//*[@id='totalp']")
    private WebElement totalPrice;

    @FindBy(xpath = "//*[@id='page-wrapper']/div/div[2]/button")
    private WebElement placeOrder;

    @FindBy(xpath = "//*[@id='page-wrapper']/div/div[1]")
    private List<WebElement> listOfProducts;

    public WebElement getTotalPrice(){return totalPrice;}

    public WebElement getPlaceOrder(){return placeOrder;}

    public List<WebElement> getListOfProducts(){return listOfProducts;}
}
