package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoBlazeSamsungGalaxyS6Page {
    @FindBy(xpath = "//*[@id='tbodyid']/div[2]/div/a")
    private WebElement addToCart;

    @FindBy(xpath = "//*[@id='more-information']")
    private WebElement productDescription;

    @FindBy(xpath = "//*[@id='tbodyid']/h3")
    private WebElement price;

    @FindBy(xpath = "//*[@id='tbodyid']/h2")
    private WebElement nameOfProduct;

    @FindBy(xpath = "//*[@id='imgp']/div/img")
    private WebElement imageOfProduct;

    @FindBy(xpath = "//*[@id='navbarExample']/ul/li[4]/a")
    private WebElement cartLink;

    public WebElement getAddToCart(){return addToCart;}

    public WebElement getProductDescription(){return productDescription;}

    public WebElement getPrice(){return price;}

    public WebElement getNameOfProduct(){return nameOfProduct;}

    public WebElement getImageOfProduct(){return imageOfProduct;}

    public WebElement getCartLink(){return cartLink;}
}
