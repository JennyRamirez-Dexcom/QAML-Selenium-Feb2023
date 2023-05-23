package Steps;

import Pages.CalendarioWaitsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class CalendarioWaitSteps extends BaseSteps {
    public CalendarioWaitSteps(WebDriver driver) {
        super(driver);
    }

    CalendarioWaitsPage calendarioWaitsPage = PageFactory.initElements(webDriver, CalendarioWaitsPage.class);

    public void abrirPaginaCalendario() {
        webDriver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
    }

    public void clickMay22() {
        calendarioWaitsPage.getTdMay22().click();
    }

    public void waitFechaSeleccionada () {
        Wait<WebDriver> fluentWait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        fluentWait.until(webDriver1 -> {
            return webDriver1.findElement(By.id("idX"));
        });
    }
}
