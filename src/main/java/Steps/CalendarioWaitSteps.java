package Steps;

import Pages.CalendarioWaitsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;

import java.util.function.Function;

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
        Wait <WebDriver> fluentWait = new Wait<WebDriver>() {
            @Override
            public <T> T until(Function<? super WebDriver, T> isTrue) {
                return null;
            }
        }
    }
}
