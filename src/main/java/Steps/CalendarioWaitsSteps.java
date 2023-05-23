package Steps;

import Pages.CalendarioWaitsPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class CalendarioWaitsSteps extends BaseSteps{

    public CalendarioWaitsSteps(WebDriver driver) {
        super(driver);
    }

    CalendarioWaitsPage calenarioWaitPage = PageFactory.initElements(webDriver, CalendarioWaitsPage.class);

    public void abrirPaginaCalendario(){
        webDriver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
    }

    public void clickMay22(){
        calenarioWaitPage.getTdMayo22().click();
    }

    public void waitFechaSeleccionada(){
        Wait<WebDriver> fluentWait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class);

        fluentWait.until(webDriver1 -> {
            return calenarioWaitPage.getSpanMayo22().isDisplayed();
        });
    }

    public void waitFechaSeleecionadaExplicito(){
        WebElement explicitWait = new WebDriverWait(webDriver,Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOf(
                        calenarioWaitPage.getSpanMayo22()
                ));
    }
}
