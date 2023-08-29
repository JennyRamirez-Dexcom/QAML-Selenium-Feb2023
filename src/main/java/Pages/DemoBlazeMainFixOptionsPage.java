package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DemoBlazeMainFixOptionsPage {
    //Header
    @FindBy (css = "a[id='cartur']")
    private WebElement cartMenuOotion;
    @FindBy (xpath = "//div[@id='navbarExample']//ul/li/a")
    private List<WebElement> menuOptionsHeader;
    //Categories
    @FindBy (css = "//a[text()='Phones']")
    private WebElement phonesCategoryOption;
    @FindBy (xpath = "//a[text()='Phones']")
    private  WebElement phonesMenuOption;
    @FindBy (id = "login2")
    private WebElement loginMenuOption;

    public WebElement getLoginMenuOption() {
        return loginMenuOption;
    }

    public WebElement getCartMenuOption() {
        return cartMenuOotion;
    }



    public List<WebElement> getMenuOptionsHeader() {
        return menuOptionsHeader;
    }

    public WebElement getPhonesCategoryOption() {
        return phonesCategoryOption;
    }

    public WebElement getPhonesMenuOption() {
        return phonesMenuOption;
    }
}
