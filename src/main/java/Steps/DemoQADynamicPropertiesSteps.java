package Steps;

import Pages.DemoQADynamicPropertiesPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoQADynamicPropertiesSteps extends BaseSteps{
    public DemoQADynamicPropertiesSteps(WebDriver driver) {
        super(driver);
    }

    DemoQADynamicPropertiesPage demoQADynamicPropertiesPage = PageFactory.initElements(webDriver, DemoQADynamicPropertiesPage.class);

    public void abrirQADynamicPropertiesPage(){
        webDriver.get("https://demoqa.com/dynamic-properties");
    }

    public void waitButtonChangeColor(){
        Wait<WebDriver> fluentWait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        fluentWait.until(webDriver1 -> {
            return demoQADynamicPropertiesPage.getBtnRedColor().isDisplayed();
        });

        demoQADynamicPropertiesPage.getBtnRedColor().click();
    }

    public void waitButtonIsVisible(){
        WebElement explicitWait = new WebDriverWait(webDriver,Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOf(
                        demoQADynamicPropertiesPage.getBtnVisibleAfter5()
                ));

        demoQADynamicPropertiesPage.getBtnRedColor().click();
    }
}
