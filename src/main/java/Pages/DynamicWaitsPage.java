package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicWaitsPage {

   @FindBy(xpath = "//button[@id='colorChange']")
    private WebElement textoColor;

    public WebElement getbuttonColor() {
        return textoColor;
    }

    @FindBy(xpath = "//button[@id='visibleAfter']")
    private WebElement botonVisible;

    public WebElement getbuttonVisible() {
        return botonVisible;
    }

}
