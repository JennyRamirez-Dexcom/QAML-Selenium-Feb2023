package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StorePage extends BasePage{

    @FindBy(xpath = "//div[@class='list-group']/child::a[2]")
    private WebElement phonesCategorieElem;

    @FindBy(xpath = "//div[@class='list-group']/child::a[3]")
    private WebElement laptopsCategorieElem;

    @FindBy(xpath = "//div[@class='list-group']/child::a[4]")
    private WebElement monitorsCategorieElem;


    public WebElement phonesCategorie(){
        return phonesCategorieElem;
    }
    public WebElement laptopsCategorie(){
        return laptopsCategorieElem;
    }
    public WebElement monitorsCategorie() {
        return monitorsCategorieElem;
    }
}
