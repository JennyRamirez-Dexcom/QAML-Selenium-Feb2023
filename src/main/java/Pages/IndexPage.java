package Pages;

import Helpers.Card;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.ArrayList;
import java.util.List;

public class IndexPage {

    @FindBy (css = "#tbodyid")
    private WebElement bodyCards;
    @FindBy (css = "div.card-block") ///"//*[@id='tbodyid']/div/div"
    private List<WebElement> availableCardsInPage;
    @FindBy (css = "#next2")
    private WebElement nextPageButton;
    @FindBy (css = "#prev2")
    private WebElement prevButton;



    public List<WebElement> getAvailableCardsInPage() {
        return availableCardsInPage;
    }


    public void getToNextPage(){
       getNextPageButton().click();
    }

    public List<Card> getAvailableCardsInPageInfo() {
        List<Card> listOfcarts = new ArrayList<Card>();
        //This should wait for the elements to load .... review process on current page
        List<WebElement> itemsForSaleList = getAvailableCardsInPage();

        for (WebElement cardAvailable :itemsForSaleList ) {
            Card card = new Card();
            card.setCardName(cardAvailable.findElement(By.xpath(" h4")).getText());
            card.setPrice(cardAvailable.findElement(By.cssSelector(" h5")).getText());
            card.setDescription(cardAvailable.findElement(By.cssSelector(" p")).getText());
            card.setImageRef(cardAvailable.findElement(By.xpath("./preceding-sibling::*[1]/img")).getAttribute("src"));
            listOfcarts.add(card);
        }
        return listOfcarts;
    }
    public List<Card> getAvailableCardsInPageInfo2(List<WebElement> itemsForSaleListIn) {
        List<Card> listOfcarts = new ArrayList<Card>();
        List<WebElement> itemsForSaleList = new ArrayList<WebElement>();
         itemsForSaleList = itemsForSaleListIn;
        for (WebElement cardAvailable :itemsForSaleList ) {
            Card card = new Card();
            card.setCardName(cardAvailable.findElement(By.xpath(" h4")).getText());
            card.setPrice(cardAvailable.findElement(By.cssSelector(" h5")).getText());
            card.setDescription(cardAvailable.findElement(By.cssSelector(" p")).getText());
            card.setImageRef(cardAvailable.findElement(By.xpath("./preceding-sibling::*[1]/img")).getAttribute("src"));
            listOfcarts.add(card);
        }
        return listOfcarts;
    }

    public WebElement getNextPageButton() {
        return nextPageButton;
    }

    public WebElement getBodyCards() {
        return bodyCards;
    }

    public WebElement getPrevButton() {
        System.out.println(prevButton.getText());
        return prevButton;
    }




}
