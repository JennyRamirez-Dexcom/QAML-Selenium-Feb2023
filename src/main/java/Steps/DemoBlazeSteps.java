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
import java.util.concurrent.TimeUnit;

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

    public void findCardByTextAndClick(String device){
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
        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(demoBlazeProdPage.getAddToCartBtn()));
        demoBlazeProdPage.getAddToCartBtn().click();
    }

     public String getTextFromAlert(){
        return getAlert().getText();
     }

     public void getToDemoblazeProductPage(String productPage){
        webDriver.navigate().to(productPage);
     }

    public void goToCartMenuOption(){
        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(demoBlazeHeaderPage.getCartMenuOotion()));
        demoBlazeHeaderPage.getCartMenuOotion().click();
    }

    public List<WebElement> getListOfItemsInShoppingCart(){
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        List<WebElement> devicesToPurchaseList =  demoBlazeShoppingCartPage.getShoppingCartDevicesList();
        return devicesToPurchaseList;
    }

    public boolean validateISDeviceNameAndPriceInShoppingCart(String device, String price){
       boolean itemInList =false;
        List<WebElement> shoppingCartItemsList = getListOfItemsInShoppingCart();
        for (WebElement deviceInShoppingCart: shoppingCartItemsList){
            if(deviceInShoppingCart.getText().contains(device) && deviceInShoppingCart.getText().contains(price));
            {
                itemInList=true;
            }
            break;
        }
        return itemInList;
    }

    public List<WebElement> getDeleteOptions(){
        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(demoBlazeShoppingCartPage.getDeleteOption()));
        return demoBlazeShoppingCartPage.getDeleteOptions();
    }

    public boolean placeOrderBtnIsDisplayed(){
        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(demoBlazeShoppingCartPage.getPlaceOrderBtn()));
        return demoBlazeShoppingCartPage.getPlaceOrderBtn().isDisplayed();
    }

    public String getImageLink(){
        return demoBlazeShoppingCartPage.getDeviceImage().getAttribute("src");
    }

    public String getOrdertotalValue(){
        return demoBlazeShoppingCartPage.getOrderTotalValue().getText();
    }

    public int calculateOrdertotal(){
       List<WebElement> valuesList = demoBlazeShoppingCartPage.getValuesList();
       int sum = 0;
       for(WebElement price:valuesList){
           sum = sum + Integer.parseInt(price.getText());
       }
       return sum;
    }


}
