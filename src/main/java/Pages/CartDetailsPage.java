package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartDetailsPage extends BasePage {

    @FindBy(xpath = "//table/tbody/tr[@class='success']")
    private List<WebElement> trProductAdded;

    @FindBy(xpath = "//table/tbody/tr[@class='success']/td[1]/img")
    private List<WebElement> tdProductImage;

    @FindBy(xpath = "//table/tbody/tr[@class='success']/td[2]")
    private List<WebElement> tdProductTitle;

    @FindBy(xpath = "//table/tbody/tr[@class='success']/td[3]")
    private List<WebElement> tdProductPrice;

    @FindBy(xpath = "//table/tbody/tr[@class='success']/td[4]/a")
    private List<WebElement> tdProductBtnDelete;

    @FindBy(xpath = "//h3[@id='totalp']")
    private WebElement h3TotalCart;

    @FindBy(xpath = "//button[@class='btn btn-success']")
    private WebElement btnPlaceOrder;

    @FindBy(xpath = "//li/a[contains(@onclick,'showcart')]")
    private WebElement liMenuCartFromCart;

    public List<WebElement> getTrProductAdded() {
        return trProductAdded;
    }

    public List<WebElement> getTdProductImage() {
        return tdProductImage;
    }

    public List<WebElement> getTdProductTitle() {
        return tdProductTitle;
    }

    public List<WebElement> getTdProductPrice() {
        return tdProductPrice;
    }

    public List<WebElement> getTdProductBtnDelete() {
        return tdProductBtnDelete;
    }

    public WebElement getH3TotalCart() {
        return h3TotalCart;
    }

    public WebElement getBtnPlaceOrder() {
        return btnPlaceOrder;
    }

    public WebElement getLiMenuCartFromCart() {
        return liMenuCartFromCart;
    }
}
