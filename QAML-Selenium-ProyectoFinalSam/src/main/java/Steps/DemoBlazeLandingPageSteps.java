package Steps;

import Pages.DemoBlazeLandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoBlazeLandingPageSteps extends BaseSteps{
    public DemoBlazeLandingPageSteps(WebDriver driver) {
        super(driver);
    }

    DemoBlazeLandingPage demoBlazeLandingPage = PageFactory.initElements(webDriver, DemoBlazeLandingPage.class);

    public void abrirPaginaDemoBlaze(){
        webDriver.get("https://www.demoblaze.com/");
    }

    public void clickenProducto(){
        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(
                        demoBlazeLandingPage.getProducto1()
                ));
        demoBlazeLandingPage.getProducto1().click();
    }

    public void clickEnHome(){
        demoBlazeLandingPage.getHomeLink().click();
    }
}
