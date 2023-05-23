package Steps;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import Pages.CalendarioWaitsPage;
import Pages.DemoQADroppablePage;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class CalendarioWaitsSteps extends BaseSteps{
    public CalendarioWaitsSteps(WebDriver driver){
        super(driver);
    }

    CalendarioWaitsPage calendarioWaitsPage = PageFactory.initElements(webDriver,CalendarioWaitsPage.class);

    public void abrirPaginaCalendario(){
        webDriver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
    }

    public void clickMay22(){
        calendarioWaitsPage.getTdMay22().click();
    }

    public void waitFechaSeleccionada(){
        Wait<WebDriver> fluentWait = new FluentWait<>(webDriver).withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class); //se checa 30 veces
        fluentWait.until(wd ->{
            return calendarioWaitsPage.getSpanMay22().isDisplayed();
        });
    }

    public void waitFechaSeleccionadadaExplicit(){
        WebElement explicitWait = new WebDriverWait(webDriver,Duration.ofSeconds(60))
                .until(ExpectedConditions.visibilityOf(calendarioWaitsPage.getSpanMay22()));
    }
}
