package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoBlazeProdPage {

    @FindBy (css = "h2[class='name']")
    private WebElement deviceName;
    @FindBy (css = "h3[class='price-container']")
    private WebElement price;
    @FindBy (xpath = "//div[@id='more-information']")
    private WebElement productDescription;
    @FindBy (xpath = "//*[text()='Add to cart']")
    private WebElement addToCartBtn;
    @FindBy (xpath = "//img[@src='imgs/iphone_6.jpg']")
    private WebElement imageRefIphone6;


    public WebElement getDeviceName() {
        return deviceName;
    }

    public WebElement getPrice() {
        return price;
    }

    public WebElement getProductDescription() {
        return productDescription;
    }

    public WebElement getAddToCartBtn() {
        return addToCartBtn;
    }

    public WebElement getImageRef() {
        return imageRefIphone6;
    }
}
