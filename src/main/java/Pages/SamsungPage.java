package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SamsungPage {

    @FindBy(className = "hrefch")
    private WebElement clickOnSamsung;

    //@FindBy(xpath = "div[@class='item active']//img")
    @FindBy(xpath = "//img[@src='imgs/galaxy_s6.jpg']")
    //@FindBy(xpath = "//*[@id='tbodyid']/div[1]/div/div/h4")
    private WebElement imagenSamsung;

    @FindBy(className = "name")
    private WebElement nameSamsung;

    @FindBy(className = "price-container")
    private WebElement priceSamsung;

    @FindBy(xpath = "//div/strong")
    private WebElement samsungDescription;

    @FindBy(xpath = "//a[@class='btn btn-success btn-lg']")
    private WebElement addToCart;

    @FindBy(id = "cartur")
    private WebElement idCart;

    @FindBy(xpath = "//*[@src='imgs/galaxy_s6.jpg']")
    private WebElement imgsGalaxy;

    @FindBy(xpath = "//tr[@class='success']//td//img")
    private WebElement tittleGalaxy;

    @FindBy(xpath = "//*/td[text()='360']")
    private WebElement priceGalaxy;

    @FindBy(xpath = "//*/a[text()='Delete']")
    private WebElement deleteGalaxy;

    @FindBy(id = "totalp")
    private WebElement totalPrice;

    @FindBy(xpath = "//button[@class='btn btn-success']")
    private WebElement placeOrderButton;

    public WebElement getClickOnSamsung(){
        return clickOnSamsung;
    }
    public WebElement getImagenSamsung(){
        return imagenSamsung;
    }
    public WebElement getNameSamsung(){
        return nameSamsung;
    }
    public WebElement getPriceSamsung(){
        return priceSamsung;
    }
    public WebElement getSamsungDescription(){
        return samsungDescription;
    }
    public WebElement getAddToCart(){
        return addToCart;
    }
    public WebElement getIdCart(){
        return idCart;
    }
    public WebElement getImgsGalaxy(){
        return imgsGalaxy;
    }
    public WebElement getTittleGalaxy(){
        return tittleGalaxy;
    }
    public WebElement getPriceGalaxy(){
        return priceGalaxy;
    }
    public WebElement getDeleteGalaxy(){
        return deleteGalaxy;
    }
    public WebElement getTotalPrice(){
        return totalPrice;
    }
    public WebElement getPlaceOrderButton(){
        return placeOrderButton;
    }
}
