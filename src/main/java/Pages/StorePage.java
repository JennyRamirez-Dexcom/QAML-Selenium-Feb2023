package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StorePage extends BasePage{
    @FindBy(xpath = "//a[@id='itemc']")
    private List<WebElement> categories;

    public List<WebElement> getCategories(){
        return categories;
    }
}
