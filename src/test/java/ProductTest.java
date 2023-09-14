import Helpers.Card;
import Steps.DemoBlazeSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductTest extends BaseTest{

    public WebDriver webDriver = getWebDriver("Chrome");
    DemoBlazeSteps demoBlazeSteps = new DemoBlazeSteps(webDriver);

    String Iphone632gb = "Iphone 6 32gb";
    String expectedPriceIphone632gb = "$790 *includes tax";
    String priceIphone632gb = "790";
    String expectedDescriptionIphone632gb = "Product description\n" +
            "It comes with 1GB of RAM. The phone packs 16GB of internal storage cannot be expanded. As far as the cameras are concerned, the Apple iPhone 6 packs a 8-megapixel primary camera on the rear and a 1.2-megapixel front shooter for selfies.";
    String expectedImageLinkIphone632gb = "https://www.demoblaze.com/imgs/iphone_6.jpg";
    //List<String> list= Arrays.asList("Home (current)", "Contact", "About us", "Cart", "Log in", "Sign up");

    @BeforeTest(alwaysRun = true)
    public void inizialization(){
        demoBlazeSteps.getToDemoBlazePage();
    }


    @Test(description = "get ALL available items to purchase", priority = 1,groups = {"EndToEndTest"})
    public void validateAvailableItems(){
        List<Card> allItemsList = demoBlazeSteps.getAllAvailableItemsToPurchase();
        demoBlazeSteps.printOut("TEST:  " + allItemsList.size());
        for (Card card : allItemsList){
            demoBlazeSteps.printOut(card.getImageRef());
            demoBlazeSteps.printOut(card.getCardName());
            demoBlazeSteps.printOut(card.getDescription());
            demoBlazeSteps.printOut(card.getPrice());
        }
    }

    @Test (description = "validate product details for Iphone 6 32gb" , priority = 4,groups = {"EndToEndTest"})
    public void productDetailsIphone632gbTest(){
        //demoBlazeSteps.getToDemoBlazePage();
        demoBlazeSteps.findCardByTextAndClick(Iphone632gb);
        Assert.assertEquals(demoBlazeSteps.AddToCartOptionIsDisplayed(),true);
        Assert.assertEquals(demoBlazeSteps.stringProductDescription(),expectedDescriptionIphone632gb);
        Assert.assertEquals(demoBlazeSteps.stringPrice(),expectedPriceIphone632gb);
        Assert.assertEquals(demoBlazeSteps.stringDeviceName(),Iphone632gb);
        Assert.assertEquals(demoBlazeSteps.imageIsDisplayed(),true);
    }



    @AfterTest (alwaysRun = true)
    public void closeBrowser(){
       demoBlazeSteps.cerrarVentana();
    }


}
