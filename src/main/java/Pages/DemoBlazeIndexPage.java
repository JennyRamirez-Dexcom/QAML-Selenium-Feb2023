package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DemoBlazeIndexPage {

    @FindBy (css = "#tbodyid")
    private WebElement bodyCards;
    @FindBy (xpath = "//*[@id='tbodyid']/div")
    private List<WebElement> availableCardsInPage;


    public List<WebElement> getAvailableCardsInPage() {
        return availableCardsInPage;
    }

    public WebElement getBodyCards() {
        return bodyCards;
    }


}
