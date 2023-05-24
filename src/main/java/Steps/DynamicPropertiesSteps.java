package Steps;

import Pages.CalendarioWaitsPage;
import Pages.DynamicPropertiesPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicPropertiesSteps extends  BaseSteps{
    public DynamicPropertiesSteps(WebDriver driver){
        super(driver);
    }

    DynamicPropertiesPage dynamicPropertiesPage = PageFactory.initElements(webDriver,DynamicPropertiesPage.class);

    public void abrirPaginaDynamicProperties(){
        webDriver.get("https://demoqa.com/dynamic-properties");
    }

    public void waitVisibleElement(){
        Wait<WebDriver> fluentWait = new FluentWait<>(webDriver).withTimeout(Duration.ofSeconds((long) 5.7))
                .pollingEvery(Duration.ofSeconds((long) 0.1)).ignoring(NoSuchElementException.class); //se checa 30 veces
        fluentWait.until(wd ->{

            return dynamicPropertiesPage.getVisibleAfterButton().isDisplayed();
        });
    }

    public void waitChangeFontColor(){
        Wait<WebDriver> fluentWait = new FluentWait<>(webDriver).withTimeout(Duration.ofSeconds((long) 5.7))
                .pollingEvery(Duration.ofSeconds((long) 0.1)).ignoring(NoSuchElementException.class); //se checa 30 veces
        fluentWait.until(wd ->{

            return Color.fromString(dynamicPropertiesPage.getcolorChangeButton().getCssValue("font-color")).asHex()
                    == "#dc3545";
        });
    }
}


/*

public class CalendarioWaitsSteps extends BaseSteps{




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
}*/
