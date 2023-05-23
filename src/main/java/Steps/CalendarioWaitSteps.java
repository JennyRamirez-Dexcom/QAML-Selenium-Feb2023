package Steps;

import Pages.CalendarioWaitPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import org.openqa.selenium.NoSuchElementException;


public class CalendarioWaitSteps extends BaseSteps{

    CalendarioWaitPage calendarioWaitPage = PageFactory.initElements(webDriver, CalendarioWaitPage.class);

    public CalendarioWaitSteps(WebDriver driver) {
        super(driver);
   }

    public void abrirPaginaCalendario(){
        webDriver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
    }

   public void clickMay22(){
        calendarioWaitPage.getTdMay22().click();
   }

   public  void waitFechaSeleccionada() {
       Wait<WebDriver> fluentWait = new FluentWait<>(webDriver)
               .withTimeout(Duration.ofSeconds(60))
               .pollingEvery(Duration.ofSeconds(5))
               .ignoring(NoSuchElementException.class);

       fluentWait.until(webDriver1 -> {
           return calendarioWaitPage.getSpanMay22().isDisplayed();
           //return webDriver1.findElement(By.id("testID"));
       });
   }

    public void waitFechaSeleccionadaExplicit(){
        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOf(calendarioWaitPage.getSpanMay22()));
        }

}
