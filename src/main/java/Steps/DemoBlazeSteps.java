package Steps;

import Helpers.Card;
import Pages.*;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DemoBlazeSteps extends BaseSteps {
    DemoBlazeIndexPage demoBlazeIndexPage = PageFactory.initElements(webDriver, DemoBlazeIndexPage.class);
    DemoBlazeProdPage demoBlazeProdPage = PageFactory.initElements(webDriver, DemoBlazeProdPage.class);
    DemoBlazeMainFixOptionsPage demoBlazeOptionsPage = PageFactory.initElements(webDriver, DemoBlazeMainFixOptionsPage.class);
    DemoBlazeShoppingCartPage demoBlazeShoppingCartPage = PageFactory.initElements(webDriver, DemoBlazeShoppingCartPage.class);
    DemoBlazeLoginPage demoBlazeLoginPage = PageFactory.initElements(webDriver, DemoBlazeLoginPage.class);

    public DemoBlazeSteps(WebDriver driver) {
        super(driver);
    }

    private void waitForListOfItemsToLoad() {
        Wait<WebDriver> fluentWait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        fluentWait.until(webDriver1 -> {
            int cartsListsize = demoBlazeIndexPage.getAvailableCardsInPage().size();
            return (cartsListsize > 0);
        });
    }


    //Get Elements available in current page version 2 get all information fill
    public List<Card> getAvailableItems(){
        waitForListOfItemsToLoad();
        List<Card> listOFItemsAvailable = new ArrayList<>();
            listOFItemsAvailable = demoBlazeIndexPage.getAvailableCardsInPageInfo();
            printOut("QA-- Elements available in current page " + listOFItemsAvailable.size());
            for (Card card : listOFItemsAvailable) {
                printOut("Test cards " + card.getCardName());
                printOut(card.getDescription());
                printOut(card.getPrice());
                printOut(card.getImageRef());
            }
        return listOFItemsAvailable;
    }

    //Get Elements available in current page version 1 whole element
    private List<WebElement> findCardsListedInCurrentPage() {
        waitForListOfItemsToLoad();
        List<WebElement> cardsList = null;
        cardsList = demoBlazeIndexPage.getAvailableCardsInPage();
        printOut("ListSize in current page: " + cardsList.size());
        return cardsList;
    }

    public List<Card> getAllAvailableItemsToPurchase() {
        List<WebElement> listAllAvalItems = new ArrayList<>();
        List<WebElement> listAvalItemsInPage = findCardsListedInCurrentPage();
        listAllAvalItems.addAll(listAvalItemsInPage);
        //NEW
        List<Card> listOfCards = demoBlazeIndexPage.getAvailableCardsInPageInfo2(listAllAvalItems);

        do{
            getToNextPage();
           waitForElementToNotBeVisible(listAvalItemsInPage.get(0));
            listAvalItemsInPage = findCardsListedInCurrentPage();
            List<Card> availableCardsInPageInfo2 = demoBlazeIndexPage.getAvailableCardsInPageInfo2(listAvalItemsInPage);
            listOfCards.addAll(availableCardsInPageInfo2);
            listAllAvalItems.addAll(listAvalItemsInPage);
         }while (demoBlazeIndexPage.getNextPageButton().isDisplayed());
        printOut("List of items quantity accumulated: "+listAllAvalItems.size());

        //NEW CODE HERE
        //List<Card> listOfCards = demoBlazeIndexPage.getAvailableCardsInPageInfo2(listAllAvalItems);
        //return listOfCards;

        //Change the return
        //return listAllAvalItems;

        return listOfCards;
                //demoBlazeIndexPage.getAvailableCardsInPageInfo();
    }



    public void getToNextPage(){
        scrollToElement(demoBlazeIndexPage.getNextPageButton());
        demoBlazeIndexPage.getNextPageButton().click();
    }

    public void getPhoneItems(){
        demoBlazeOptionsPage.getPhonesMenuOption().click();
        List<WebElement> phonesAvailableList = findCardsListedInCurrentPage();
        Map<String,String> availablePhonesWithPrices = new HashMap<String,String>();
        for(WebElement phone:phonesAvailableList){
            availablePhonesWithPrices.put(phone.getText(),
                    phone.getAttribute(phone.findElement(By.xpath("//a[@class='hrefch']")).getText()));//findElement(By.xpath("//h4[@class='card-title']/h5"))
                    printOut(availablePhonesWithPrices.toString());
        }

    }

    public void getIphonesAvailableInformation(){
        List<Card> cardsInfo= demoBlazeIndexPage.getAvailableCardsInPageInfo();
        printOut("QA"+cardsInfo.size());
        for(Card card : cardsInfo ){
            printOut(card.getCardName());
            printOut(card.getDescription());
        }

    }



    public void findCardByTextAndClick(String device){
        int cont=0;
        List<WebElement> cardsList= findCardsListedInCurrentPage();
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
        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOf(demoBlazeProdPage.getAddToCartBtn()));
    }

    public boolean imageIsDisplayed(){
        return demoBlazeProdPage.getImageRef().isDisplayed();
    }

    public void clickAddToCart(){
        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(30))
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
        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOf(demoBlazeOptionsPage.getCartMenuOption()));
        demoBlazeOptionsPage.getCartMenuOption().click();
    }

    public void goToLoginMenuOption(String user, String password){
        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOf(demoBlazeOptionsPage.getLoginMenuOption()));
        demoBlazeOptionsPage.getLoginMenuOption().click();
        WebElement explicitWait1 = new WebDriverWait(webDriver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOf(demoBlazeLoginPage.getLoginUsername()));
        demoBlazeLoginPage.getLoginUsername().sendKeys(user);
        demoBlazeLoginPage.getPassword().sendKeys(password);
        demoBlazeLoginPage.getLoginButton().click();
    }

    public String getWelcomeMessage(){
        WebElement explicitWait2 = new WebDriverWait(webDriver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOf(demoBlazeLoginPage.getWelcomeMessage()));
        return  demoBlazeLoginPage.getWelcomeMessage().getText();
    }

    public List<WebElement> getListOfItemsInShoppingCart(){
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        List<WebElement> devicesToPurchaseList =  demoBlazeShoppingCartPage.getShoppingCartDevicesList();
        return devicesToPurchaseList;
    }

   public List<String> getMenuOptions(){
       return getOptionsTextFromAList(demoBlazeOptionsPage.getMenuOptionsHeader());
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

    public void waitForPreviousButtonToBeVisible(){
        waitForElementToBeVisible(demoBlazeIndexPage.getPrevButton());
    }


}
