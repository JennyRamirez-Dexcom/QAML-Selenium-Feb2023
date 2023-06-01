package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DemoBlazePage {
    @FindBy(xpath = "//*[@id='tbodyid']/div[1]/div/div/h4/a")
    private WebElement samsungGalaxyS6;

    public WebElement getSamsungGalaxyS6(){return samsungGalaxyS6;}
}
