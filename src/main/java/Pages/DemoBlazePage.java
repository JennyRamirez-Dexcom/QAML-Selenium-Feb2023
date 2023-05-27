package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoBlazePage {
    @FindBy(xpath = "//img[@src='imgs/Nexus_6.jpg']")
    private WebElement imageNexus6;
    //Index page
    @FindBy(xpath = "//a[@href='prod.html?idp_=3']")
    private WebElement clickNexus6;
    //Prod page
    @FindBy(xpath = "//h2[.='Nexus 6']")
    private WebElement prodName;
    @FindBy(xpath = "//h3[@class='price-container']")
    private WebElement prodPrice;
    @FindBy(xpath = "//div[@id='more-information']")
    private WebElement prodMoreInfo;
    @FindBy(xpath = "$x(//*[.='Product description']")
    private WebElement prodDescription;
    @FindBy(xpath = "//p[.='The Motorola Google Nexus 6 is powered by 2.7GHz quad-core Qualcomm Snapdragon 805 processor and it comes with 3GB of RAM.']")
    private WebElement prodDescriptionText;
    @FindBy(xpath = "//a[@class='btn btn-success btn-lg']")
    private WebElement prodAddCartButton;
    //Cart page
    @FindBy(xpath = "//a[@href='cart.html']")
    private WebElement prodCartLink;
    @FindBy(xpath = "//td/a[@href='#']")
    private WebElement cartDelete;
    @FindBy(xpath = "//td[contains(text(), 'Nexus 6')]")
    private WebElement cartTitle;
    @FindBy(xpath = "//td[contains(text(), '650')]")
    private WebElement cartPrice;
    @FindBy(xpath = "//h3[@id='totalp']")
    private WebElement cartTotal;
    @FindBy(xpath = "//button[@class='btn btn-success']")
    private WebElement cartPlaceOrderButton;

    public WebElement getClickNexus6(){
        return clickNexus6;
    }public WebElement getImageNexus6(){
        return imageNexus6;
    }
    //Prod page
    public WebElement getProdName(){
        return prodName;
    }
    public WebElement getProdPrice(){
        return prodPrice;
    }
    public WebElement getProdDescription(){
        return prodDescription;
    }
    public WebElement getProdDescriptionText(){
        return prodDescriptionText;
    }
    public WebElement getProdAddCartButton() {
        return prodAddCartButton;
    }
    // Cart page
    public WebElement getProdCartLink(){
        return prodCartLink;
    }
    public WebElement getCartTitle(){
        return cartTitle;
    }
    public WebElement getCartPrice(){
        return cartPrice;
    }
    public WebElement getCartDelete(){
        return cartDelete;
    }
    public WebElement getCartTotal(){
        return cartTotal;
    }
    public WebElement getCartPlaceOrderButton(){
        return cartPlaceOrderButton;
    }
}
