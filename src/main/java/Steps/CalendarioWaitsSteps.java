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

    CalendarioWaitsPage calendarioWaitsPage = PageFactory.initElements(webDriver, CalendarioWaitsPage.class);

    public void abrirPaginaCalendario(){
        webDriver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
    }

    public void clickMay22(){
        calendarioWaitsPage.getTdMay22().click();
    }

    public void waitFechaSeleccionada(){
        Wait<WebDriver> fluentWait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))//Va a checar 15 veces, en 30 segundos va a checar cada 2 segundos, 30/2=15
                .ignoring(NoSuchElementException.class);

        fluentWait.until(webDriver -> {
            return calendarioWaitsPage.getSpanMay22().isDisplayed();
        });
    }

    public void waitFechaSeleccionadaExplicit(){
        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOf(
                        calendarioWaitsPage.getSpanMay22()
                ));
    }
}
