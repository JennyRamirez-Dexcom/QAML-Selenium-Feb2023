package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeTest;

public class StorePage {

    @FindBy (xpath = "//div[@class='list-group']/child::a[2]")
    private WebElement categoriesListPhones;

    @FindBy (xpath = "//div[@class='list-group']/child::a[3]")
    private WebElement categoriesListLaptops;

    @FindBy (xpath = "//div[@class='list-group']/child::a[4]")
    private  WebElement categoriesListMonitors;

    public WebElement PhonesCategorie(){
        return categoriesListPhones;
    }
    public WebElement laptopsCategorie(){
        return categoriesListLaptops;
    }
    public WebElement monitorsCategorie() {
        return categoriesListMonitors;
    }
}
