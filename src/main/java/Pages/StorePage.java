package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StorePage extends BasePage{

    @FindBy(xpath = "//div[@class='list-group']/child::a[2]")
    private WebElement PhonesCategorie;

    @FindBy(xpath = "//div[@class='list-group']/child::a[3]")
    private WebElement laptopsCategorie;

    @FindBy(xpath = "//div[@class='list-group']/child::a[4]")
    private WebElement monitorsCategorie;
    
}
