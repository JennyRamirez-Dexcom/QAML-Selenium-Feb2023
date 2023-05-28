package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoQAWaitsColorChangePage {
    @FindBy(xpath = "//button[@id='visibleAfter']")
    private WebElement BotonAfter;

    @FindBy(xpath = "//button[@class='mt-4 text-danger btn btn-primary']")
    private WebElement BotonColorChange;

    public WebElement getBotonColorChange(){
        return BotonColorChange;
    }

    public WebElement getBotonAfter(){
        return BotonAfter;
    }
}
