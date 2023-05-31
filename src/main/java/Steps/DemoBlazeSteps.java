package Steps;

import Pages.DemoBlazeHeaderPage;
import Pages.DemoBlazeIndexPage;
import Pages.DemoBlazeProdPage;
import Pages.DemoBlazeShoppingCartPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DemoBlazeSteps extends BaseSteps{
    DemoBlazeIndexPage demoBlazeIndexPage = PageFactory.initElements(webDriver, DemoBlazeIndexPage.class);
    DemoBlazeProdPage demoBlazeProdPage = PageFactory.initElements(webDriver, DemoBlazeProdPage.class);
    DemoBlazeHeaderPage demoBlazeHeaderPage = PageFactory.initElements(webDriver, DemoBlazeHeaderPage.class);
    DemoBlazeShoppingCartPage demoBlazeShoppingCartPage = PageFactory.initElements(webDriver, DemoBlazeShoppingCartPage.class);

    public DemoBlazeSteps(WebDriver driver) {
        super(driver);
    }

    private void waitForElementToBeCompleted() {
        Wait<WebDriver> fluentWait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        fluentWait.until(webDriver1 -> {
            String cartsListsize = String.valueOf(demoBlazeIndexPage.getAvailableCardsInPage().size());
            return cartsListsize.equals("9");
        });
    }

    public List<WebElement> findCardsListInFirstPage(){
        waitForElementToBeCompleted();
         List<WebElement> cardsList = demoBlazeIndexPage.getAvailableCardsInPage();
         return cardsList;
    }

    public void findCardByText(String device){
        int cont=0;
        List<WebElement> cardsList= findCardsListInFirstPage();
        for(WebElement card: cardsList  ){

            boolean contains = card.getText().contains(device);
            if(contains){
                break;
            }
            cont= cont+1;
        }
        cardsList.get(cont).click();
        System.out.println("QA tracking on findCardByText"+cont);
    }

    public void getToDemoBlazePage(){
        webDriver.get("https://www.demoblaze.com/index.html");
    }

    public String stringProductDescription(){
        return demoBlazeProdPage.getProductDescription().getText();
    }

    public String stringPrice(){
        return demoBlazeProdPage.getPrice().getText();
    }

    public String stringDeviceName(){
        return demoBlazeProdPage.getDeviceName().getText();
    }

    public boolean AddToCartOptionIsDisplayed(){
        waitForVisibleAfter5SecondsButtontoBeDisplayed();
        return demoBlazeProdPage.getAddToCartBtn().isDisplayed();
    }

    private void waitForVisibleAfter5SecondsButtontoBeDisplayed(){
        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(demoBlazeProdPage.getAddToCartBtn()));
    }

    public boolean imageIsDisplayed(){
        return demoBlazeProdPage.getImageRef().isDisplayed();
    }

    public void clickAddToCart(){
        demoBlazeProdPage.getAddToCartBtn().click();
    }

     public String getTextFromAlert(){
        return getAlert().getText();
     }

     public void getToDemoblazeProductPage(){
        webDriver.navigate().to("https://www.demoblaze.com/prod.html?idp_=7#");
     }

    public void goToCartMenuOption(){
        demoBlazeHeaderPage.getCartMenuOotion().click();
    }

    public void getListOfItemsInShoppingCart(){
        List<WebElement> devicesToPurchaseList =  demoBlazeShoppingCartPage.getShoppingCartDevicesList();
        System.out.println(devicesToPurchaseList.size());
    }

    public boolean placeOrderBtnIsDisplayed(){
        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(demoBlazeShoppingCartPage.getPlaceOrderBtn()));
        return demoBlazeShoppingCartPage.getPlaceOrderBtn().isDisplayed();
    }


}
