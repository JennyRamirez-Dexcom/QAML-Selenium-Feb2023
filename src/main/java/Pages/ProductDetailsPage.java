package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage{

    @FindBy(xpath = "//div[@class='product-image']//img")
    private WebElement imgProduct;

    @FindBy(className = "name")
    private WebElement h2ProductName;

    @FindBy(className = "price-container")
    private WebElement h3ProductPrice;

    @FindBy(id = "more-information")
    private WebElement divProductDescription;

    @FindBy(xpath = "//a[contains(@onclick,'addToCart')]")
    private WebElement btnAddToCart;

    public WebElement getImgProduct(){
        return imgProduct;
    }

    public WebElement getH2ProductName(){
        return h2ProductName;
    }

    public WebElement getH3ProductPrice(){
        return h3ProductPrice;
    }

    public WebElement getDivProductDescription(){
        return divProductDescription;
    }

    public WebElement getBtnAddToCart(){
        return btnAddToCart;
    }
}
