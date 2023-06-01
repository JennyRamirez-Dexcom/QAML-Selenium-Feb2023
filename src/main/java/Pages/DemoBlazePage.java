package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DemoBlazePage {




    @FindBy(xpath = "//*[@id='tbodyid']/div[1]/div/div/h4")
    private WebElement selectProduct;

    @FindBy(xpath = "//div/a[@class='btn btn-success btn-lg']")
    private WebElement addToCart;

    @FindBy(xpath = "//*[@id='more-information']/p")
    private WebElement productDescription;

    @FindBy(xpath = "//*[@class='price-container']")
    private WebElement priceOfProduct;

    @FindBy(xpath = "//*[@id='imgp']/div/img")
    private WebElement imagePresent;

    @FindBy(xpath = "//h2[@class='name']")
    private WebElement titlePage;

    @FindBy(xpath = "//a[@id='cartur']")
    private WebElement cartButtom;

    public WebElement getSelectProduct() {
        return selectProduct;
    }

    @FindBy(xpath = "//*[@class='btn btn-success']")
    private WebElement placeOrder;

    @FindBy(xpath = "//*[@id='totalp']")
    private WebElement total;

    //

   // @FindBy(xpath = "//*[@class='card-img-top img-fluid']")
    //private WebElement multipliesProducts;


    //

    public WebElement getAddToCart(){
        return addToCart;
    }

    public WebElement getProductDescription(){
        return productDescription;
    }

    public WebElement getPriceOfProduct(){
        return priceOfProduct;
    }

    public WebElement getImagePresent(){
        return imagePresent;
    }

    public WebElement getTitlePage() {
        return titlePage;
    }

    public WebElement getCartButtom() {
        return cartButtom;
    }

    public WebElement getPlaceOrder() {
        return placeOrder;
    }

    public WebElement getTotal() {
        return total;
    }
    //public WebElement getMultipliesProducts() {
     //  return multipliesProducts;
    }

