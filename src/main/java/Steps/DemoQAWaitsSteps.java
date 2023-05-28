package Steps;

import Pages.DemoQAWaitsColorChangePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoQAWaitsSteps extends BaseSteps{

    public DemoQAWaitsSteps(WebDriver driver) {
        super(driver);
    }

    DemoQAWaitsColorChangePage demoQAWaitsColorChangePage = PageFactory.initElements(webDriver, DemoQAWaitsColorChangePage.class);

    public void abrirPaginaColorChange(){
        webDriver.get("https://demoqa.com/dynamic-properties");
    }

    public void waitBotonColorChangeExplicit() {
        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(6))
                .until(ExpectedConditions.visibilityOf(
                        demoQAWaitsColorChangePage.getBotonColorChange()
                ));
    }

    public void waitBotonVisibleAfterWait(){
        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(6))
                .until(ExpectedConditions.visibilityOf(
                        demoQAWaitsColorChangePage.getBotonAfter()
                ));
    }
}
