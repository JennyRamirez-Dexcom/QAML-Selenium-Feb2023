package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class ProyectoFinalPage {
    @FindBy(xpath = "//*[@id='tbodyid']/div[1]/div/a")
    private WebElement firstItemCard;

    @FindBy(xpath ="//*[@id='imgp']/div/img")
    private WebElement itemCardImage;

    @FindBy( xpath = "//*[contains(@class,'btn-success')]")
    private WebElement itemCardCartButton;

    @FindBy( xpath = "//*[@class='name']")
    private WebElement itemCardTitle;

    @FindBy( xpath = "//*[@class='price-container']")
    private WebElement itemCardPrice;

    @FindBy( id = "more-information")
    private WebElement itemCardDescription;

    @FindBy( xpath = "//*[@id='navbarExample']/ul/li[4]/a")
    private WebElement cartNavbar;

    @FindBy( xpath = "//*[text()='Total']")
    private WebElement totalh2Title;

    @FindBy( xpath = "//*[@class='panel-heading']/h3")
    private WebElement totalh3Value;

    @FindBy( xpath = "//*[@id='tbodyid']//descendant::tr")
    private List<WebElement> cartItems;

    public WebElement getFirstItemCard(){
        return firstItemCard;
    }

    public WebElement getItemCardImage(){
        return itemCardImage;
    }

    public WebElement getItemCardCartButton(){
        return itemCardCartButton;
    }

    public WebElement getItemCardTitle(){
        return itemCardTitle;
    }
    public WebElement getItemCardPrice(){
        return itemCardPrice;
    }

    public WebElement getItemCardDescription(){
        return itemCardDescription;
    }

    public WebElement getCartNavbar(){
        return cartNavbar;
    }

    public WebElement getTotalh2Title(){
        return totalh2Title;
    }

    public WebElement getTotalh3Value(){
        return totalh3Value;
    }

    public List<WebElement> getCartItems(){
        return cartItems;
    }
}



