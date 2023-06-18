package Pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LandingPage extends BasePage {

    @FindBy(id = "navbarExample")
    private WebElement navigationBar;

    @FindBy(css = "a[href*='prod.html?idp_=1']")
    private WebElement samsungGalaxyS6;

    public LandingPage(WebDriver driver) {
        super(driver);
        driver.get("https://demoblaze.com/");
    }

    public boolean isPagePresent() {
        try {
            getFluentWait(120, 3).until(ExpectedConditions.visibilityOf(navigationBar));
            return true;
        }
        catch (TimeoutException e) {
            return false;
        }
    }

    public void selectElementSamsungGalaxyS6() {
        samsungGalaxyS6.click();
    }
}
