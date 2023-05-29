package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductStoreHomePage extends BasePage {

    @FindBy(xpath = "//div[@class='list-group']/a[@id='cat']")
    private WebElement aCategoryListTitle;

    @FindBy(xpath = "//div[@id='carouselExampleIndicators']")
    private WebElement divCarouselProducts;

    @FindBy(xpath = "//div[@class='card-block']/h4")
    private List<WebElement> h4ProductTitle;

    @FindBy(xpath = "//div[@class='card h-100']")
    private List<WebElement> divProducCard;

    @FindBy(xpath = "//li/a[contains(@href,'index')]")
    private WebElement liMenuHome;

    @FindBy(xpath = "//li/a[contains(@href,'cart')]")
    private WebElement liMenuCart;

    public WebElement getACategoryListTitle(){
        return aCategoryListTitle;
    }

    public WebElement getDivCarouselProducts(){
        return divCarouselProducts;
    }

    public List<WebElement> getH4ProductTitle(){
        return h4ProductTitle;
    }

    public List<WebElement> getDivProducCard(){
        return divProducCard;
    }

    public WebElement getLiMenuHome(){
        return liMenuHome;
    }

    public WebElement getLiMenuCart(){
        return liMenuCart;
    }
}
