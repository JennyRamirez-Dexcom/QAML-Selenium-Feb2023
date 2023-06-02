package Steps;

import Pages.SamsungPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SamsungSteps extends BaseSteps{
    public SamsungSteps(WebDriver driver){
        super(driver);
    }
    SamsungPage samsungPage = PageFactory.initElements(webDriver, SamsungPage.class);


    public void setUp(){
        webDriver.get("https://www.demoblaze.com/");
        webDriver.manage().window().maximize();
        imprimir("Navegando en Store");
    }
    public void escogerUnArtículoDeLaTienda(){
        samsungPage.getClickOnSamsung().click();
    }
    public void waitArtículos(){
        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOf(samsungPage.getClickOnSamsung()));
    }
    public void tearDown(){
        webDriver.quit();
    }
    public void isDisplayedImage(){
        samsungPage.getImagenSamsung().isDisplayed();
        imprimir("Image is displayed");
    }
    public void waitImage(){
        WebElement waitImage = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(samsungPage.getImagenSamsung()));
    }
    public void isDisplayedNameOfSamsung(){
        samsungPage.getNameSamsung().isDisplayed();
        imprimir("Name is displayed");
    }
    public void isDisplayedPrice(){
        samsungPage.getPriceSamsung().isDisplayed();
        imprimir("Price is displayed");
    }
    public void isDisplayedDescription(){
        samsungPage.getSamsungDescription().isDisplayed();
        imprimir("Description is displayed");
    }
    public void isDisplayedAddToCartButton(){
        samsungPage.getAddToCart().isDisplayed();
        imprimir("'Add to Cart' is displayed");
    }
    public void clickOnAddtoCart(){
        samsungPage.getAddToCart().click();
    }
    public void alert(){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        alert.accept();
    }
    public void goToCart(){
        samsungPage.getIdCart().click();
    }

    public void waitImageProduct(){
        WebElement waitImageProduct = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until((ExpectedConditions.visibilityOf(samsungPage.getImgsGalaxy())));
    }
    public void isDisplayedImageProduct(){
        samsungPage.getImgsGalaxy().isDisplayed();
        imprimir("Image is displayed");
    }
    public void isDisplayedTittle(){
        samsungPage.getTittleGalaxy().isDisplayed();
        imprimir("Tittle is displayed");
    }
    public void isDiplayedPrice(){
        samsungPage.getPriceGalaxy().isDisplayed();
        imprimir("Price is displayed");
    }
    public void isDisplayedDeleteButton(){
        samsungPage.getDeleteGalaxy().isDisplayed();
        imprimir("Delete button in displayed");
    }
    public void isDisplayedTotalPrice(){
        samsungPage.getTotalPrice().isDisplayed();
        imprimir("Total price is displayed");
    }
    public void isDisplayedePlaceOrderButton(){
        samsungPage.getPlaceOrderButton().isDisplayed();
        imprimir("Place Order Button is displayed");
    }


}
