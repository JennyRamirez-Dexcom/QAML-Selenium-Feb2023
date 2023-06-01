package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.ArrayList;
import java.util.List;

public class CartPage {

    @FindBy(xpath = "//a[@id='cartur']")
    private WebElement cartLink;

    public WebElement getCartLink(){
        return cartLink;
    }

    @FindBy(xpath = "//tr[@class='success']/td/img")
    private WebElement imagenProductoCart;

    public WebElement getImagenProductoCart(){
        return imagenProductoCart;
    }

    @FindBy(xpath = "(//tr[@class='success']/td)[2]")
    private WebElement titleProductoCart;

    public WebElement getTitleProductoCart(){
        return titleProductoCart;
    }

    @FindBy(xpath = "(//tr[@class='success']/td)[3]")
    private WebElement productPriceCart;

    public WebElement getProductPriceCart(){
        return productPriceCart;
    }

    @FindBy(xpath = "(//tr[@class='success']/td)[4]")
    private WebElement deleteLink;

    public WebElement getDeleteLink(){
        return deleteLink;
    }

    @FindBy(xpath = "//h3[@id='totalp']")
    private WebElement totalPrice;

    public WebElement getTotalPrice(){
        return totalPrice;
    }

    @FindBy(xpath = "//button[@class='btn btn-success']")
    private WebElement botonPlaceOrder;

    public WebElement getBotonPlaceOrder(){
        return botonPlaceOrder;
    }




}
