package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoBlazeLandingPage {

    @FindBy(xpath = "//a[contains(text(),'Home')]")
    private WebElement homeLink;

    public WebElement getHomeLink(){
        return homeLink;
    }

    @FindBy(xpath = "(//h4[@class='card-title']/a)[1]")
    private WebElement producto1;

    public WebElement getProducto1(){
        return producto1;
    }


}
