package Steps;

import Pages.StorePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class StoreSteps extends BaseSteps{
    public StoreSteps (WebDriver driver){
        super(driver);
    }
    StorePage storePage = PageFactory.initElements(webDriver, StorePage.class);

    public void setUpStore(){
        webDriver.get("https://www.demoblaze.com/");
        webDriver.manage().window().maximize();
        imprimir("Navegando en Store");
    }
    public boolean verifyIsPhonesCategory(){
        WebElement phones = storePage.phonesCategorie();
        imprimir("Phones Categorie is Displayed: " + phones.isDisplayed());
        return isCorrectlyDisplayedElement(phones);
    }
    public boolean verifyLaptopsCategory(){
        WebElement laptops = storePage.laptopsCategorie();
        imprimir("Laptops Categorie is DIsplayed: " + laptops.isDisplayed());
        return isCorrectlyDisplayedElement(laptops);
    }
    public boolean verifyIsMonitorsCategory(){
        WebElement monitors = storePage.monitorsCategorie();
        imprimir("Monitors Categorie is Displayed: " + monitors.isDisplayed());
        return isCorrectlyDisplayedElement(monitors);
    }
    public void tearDown(){
        webDriver.quit();
    }
}
