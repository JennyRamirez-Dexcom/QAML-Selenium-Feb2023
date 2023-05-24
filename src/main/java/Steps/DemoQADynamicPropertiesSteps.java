package Steps;

import Pages.DemoQADynamicProperties;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class DemoQADynamicPropertiesSteps extends  BaseSteps{
    public DemoQADynamicPropertiesSteps(WebDriver driver){
        super(driver);
    }

    DemoQADynamicProperties demoQADynamicProperties = PageFactory.initElements(webDriver,DemoQADynamicProperties.class);

    public void abrirPaginaDynamicProperties(){
        webDriver.get("https://demoqa.com/dynamic-properties");
    }

    public void waitVisibleElement(){
        Wait<WebDriver> fluentWait = new FluentWait<>(webDriver).withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
        fluentWait.until(wd ->{
            return demoQADynamicProperties.getVisibleAfterButton().isDisplayed();
        });
    }

    public void waitChangeFontColor(){
        Wait<WebDriver> fluentWait = new FluentWait<>(webDriver).withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
        fluentWait.until(wd ->{
            //Color = "#dc3545"
            //return demoQADynamicProperties.getcolorChangeButton().isDisplayed();
            //String hexcolor = Color.fromString(demoQADynamicProperties.getcolorChangeButton().getCssValue("color")).asHex(); //converted Into HexFormat
            //System.out.println("Hex Color: " + hexcolor);
            //return hexcolor == "#dc3545";

            System.out.println(Color.fromString(demoQADynamicProperties.getcolorChangeButton().getCssValue("color")).asHex());
            return Color.fromString(demoQADynamicProperties.getcolorChangeButton().getCssValue("color")).asHex().contentEquals("#dc3545");
        });
    }
}