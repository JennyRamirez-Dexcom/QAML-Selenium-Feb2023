package Steps;

import Pages.DemoBlazePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class DemoBlazeSteps extends BaseSteps {
    public DemoBlazeSteps(WebDriver webDriver){
        super(webDriver);
    }
    DemoBlazePage demoBlazeSteps = PageFactory.initElements(webDriver, DemoBlazePage.class);
    public void openDemoBlazePage(){
        webDriver.get("https://www.demoblaze.com/index.html");
    }
    //Index page
    public void clickNexus6(){
        Wait<WebDriver> fluentWait = new FluentWait<>(webDriver).withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class); //se checa 30 veces
        fluentWait.until(wd ->{
            return demoBlazeSteps.getClickNexus6().isDisplayed();

        });
        demoBlazeSteps.getClickNexus6().click();
        Assert.assertEquals("https://www.demoblaze.com/prod.html?idp_=3",webDriver.getCurrentUrl());
    }
    //Prod page
    public void prodDisplayImage(){
        Wait<WebDriver> fluentWait = new FluentWait<>(webDriver).withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class); //se checa 30 veces
        fluentWait.until(wd ->{
            return demoBlazeSteps.getImageNexus6().isDisplayed();
        });
        Assert.assertEquals(demoBlazeSteps.getImageNexus6().isDisplayed(),true);
        Assert.assertEquals(demoBlazeSteps.getImageNexus6().isEnabled(),true);
    }
    public void prodDisplayName(){
        Assert.assertEquals(demoBlazeSteps.getProdName().isDisplayed(),true);
        Assert.assertEquals(demoBlazeSteps.getProdName().isEnabled(),true);
        Assert.assertEquals(demoBlazeSteps.getProdName().getText(),"Nexus 6");
    }
    public void prodDisplayPrice(){
        Assert.assertEquals(demoBlazeSteps.getProdPrice().isDisplayed(),true);
        Assert.assertEquals(demoBlazeSteps.getProdPrice().isEnabled(),true);
        Assert.assertEquals(demoBlazeSteps.getProdPrice().getText(),"$650 *includes tax");
    }
    public void prodDisplayDescriptionText(){
        Assert.assertEquals(demoBlazeSteps.getProdDescriptionText().isDisplayed(),true);
        Assert.assertEquals(demoBlazeSteps.getProdDescriptionText().isEnabled(),true);
        Assert.assertEquals(demoBlazeSteps.getProdDescriptionText().getText(),"The Motorola Google Nexus 6 is powered by 2.7GHz quad-core Qualcomm Snapdragon 805 processor and it comes with 3GB of RAM.");
    }
    public void prodDisplayAddCartButton(){
        Assert.assertEquals(demoBlazeSteps.getProdAddCartButton().isDisplayed(),true);
        Assert.assertEquals(demoBlazeSteps.getProdAddCartButton().isEnabled(),true);
        Assert.assertEquals(demoBlazeSteps.getProdAddCartButton().getText(),"Add to cart");
    }
    public void prodClickAddCartButton(){
        Wait<WebDriver> fluentWait = new FluentWait<>(webDriver).withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class); //se checa 30 veces
        fluentWait.until(wd ->{
            return demoBlazeSteps.getProdAddCartButton().isDisplayed();

        });
        Assert.assertEquals(demoBlazeSteps.getProdAddCartButton().isDisplayed(),true);
        Assert.assertEquals(demoBlazeSteps.getProdAddCartButton().isEnabled(),true);
        Assert.assertEquals(demoBlazeSteps.getProdAddCartButton().getText(),"Add to cart");
        demoBlazeSteps.getProdAddCartButton().click();
    }
    //Modal popup
    public void modalPopup() throws Exception{
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = webDriver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"Product added");
        try{
            alert.accept();
        }
        catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    //Cart page
    public void prodDisplayCartLink(){
        Assert.assertEquals(demoBlazeSteps.getProdCartLink().isDisplayed(),true);
        Assert.assertEquals(demoBlazeSteps.getProdCartLink().isEnabled(),true);
        Assert.assertEquals(demoBlazeSteps.getProdCartLink().getText(),"Cart");
    }
    public void prodClickCartLink(){
        Wait<WebDriver> fluentWait = new FluentWait<>(webDriver).withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class); //se checa 30 veces
        fluentWait.until(wd ->{
            return demoBlazeSteps.getProdCartLink().isDisplayed();

        });
        Assert.assertEquals(demoBlazeSteps.getProdCartLink().isDisplayed(),true);
        Assert.assertEquals(demoBlazeSteps.getProdCartLink().isEnabled(),true);
        Assert.assertEquals(demoBlazeSteps.getProdCartLink().getText(),"Cart");
        demoBlazeSteps.getProdCartLink().click();
        Assert.assertEquals("https://www.demoblaze.com/cart.html",webDriver.getCurrentUrl());
    }
    public void cartDisplayImage(){
        Wait<WebDriver> fluentWait = new FluentWait<>(webDriver).withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class); //se checa 30 veces
        fluentWait.until(wd ->{
            return demoBlazeSteps.getImageNexus6().isDisplayed();
        });
        Assert.assertEquals(demoBlazeSteps.getImageNexus6().isDisplayed(),true);
        Assert.assertEquals(demoBlazeSteps.getImageNexus6().isEnabled(),true);
    }
    public void cartDisplayTitle(){
        Assert.assertEquals(demoBlazeSteps.getCartTitle().isDisplayed(),true);
        Assert.assertEquals(demoBlazeSteps.getCartTitle().isEnabled(),true);
        Assert.assertEquals(demoBlazeSteps.getCartTitle().getText(),"Nexus 6");
    }
    public void cartDisplayPrice(){
        Assert.assertEquals(demoBlazeSteps.getCartPrice().isDisplayed(),true);
        Assert.assertEquals(demoBlazeSteps.getCartPrice().isEnabled(),true);
        Assert.assertEquals(demoBlazeSteps.getCartPrice().getText(),"650");
    }
    public void cartDisplayDelete(){
        Assert.assertEquals(demoBlazeSteps.getCartDelete().isDisplayed(),true);
        Assert.assertEquals(demoBlazeSteps.getCartDelete().isEnabled(),true);
        Assert.assertEquals(demoBlazeSteps.getCartDelete().getText(),"Delete");
    }
    public void cartDisplayTotal(){
        Assert.assertEquals(demoBlazeSteps.getCartTotal().isDisplayed(),true);
        Assert.assertEquals(demoBlazeSteps.getCartTotal().isEnabled(),true);
        Assert.assertEquals(demoBlazeSteps.getCartTotal().getText(),"650");
    }
    public void cartDisplayPlaceOrderButton(){
        Assert.assertEquals(demoBlazeSteps.getCartPlaceOrderButton().isDisplayed(),true);
        Assert.assertEquals(demoBlazeSteps.getCartPlaceOrderButton().isEnabled(),true);
        Assert.assertEquals(demoBlazeSteps.getCartPlaceOrderButton().getText(),"Place Order");
    }
}
