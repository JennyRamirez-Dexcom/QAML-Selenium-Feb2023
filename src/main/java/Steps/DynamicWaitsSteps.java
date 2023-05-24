package Steps;

import Pages.DynamicWaitsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicWaitsSteps extends BaseSteps{
    public DynamicWaitsSteps(WebDriver driver) {
        super(driver);
    }

    DynamicWaitsPage dynamicWaitsPage= PageFactory.initElements(webDriver,DynamicWaitsPage.class);

    public void abrirPaginaDinamico() {
        webDriver.get("https://demoqa.com/dynamic-properties");
    }
    public String buttonColor() {
        WebElement contenidoTexto = dynamicWaitsPage.getbuttonColor();
        return contenidoTexto.getAttribute("class"); // Revisa por clase , ya que llama a una clase agregar el color rojo
        //getCssValue("color") rgba(220,53,69,1)
    }

    public void waitButtonTextoColor() {
        Wait<WebDriver> fluentWait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        fluentWait.until(wd -> {
            return dynamicWaitsPage.getbuttonColor().getAttribute("class");
        });
    }

    public void waitButtonVisibleExplicit() {
        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOf(
                        dynamicWaitsPage.getbuttonVisible()
                ));
    }
}