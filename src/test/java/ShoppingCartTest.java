import Helpers.Card;
import Steps.DemoBlazeSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartTest extends BaseTest{

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


    @Test (description = "Add Product to the cart" , priority = 3, groups = {"EndToEndTest"})
    public void addProductToShoppingCartTest(){
        demoBlazeSteps.getToDemoblazeProductPage("https://www.demoblaze.com/prod.html?idp_=5#");
        demoBlazeSteps.clickAddToCart();
        String alertText = demoBlazeSteps.getTextFromAlert();
        Assert.assertEquals(alertText,"Product added");
        demoBlazeSteps.acceptAlert();

    }

    @Test (description = "Validate Information on Shopping Cart" , priority = 5, groups = {"EndToEndTest"})
    public  void shoppingCartDetailTest1(){
        //Adding a product to the cart
        demoBlazeSteps.getToDemoblazeProductPage("https://www.demoblaze.com/prod.html?idp_=5#"); //https://www.demoblaze.com/prod.html?idp_=2
        demoBlazeSteps.clickAddToCart();
        demoBlazeSteps.acceptAlert();
        demoBlazeSteps.goToCartMenuOption();

        boolean itemExistInCart = demoBlazeSteps.validateISDeviceNameAndPriceInShoppingCart(Iphone632gb, priceIphone632gb );
        Assert.assertEquals(itemExistInCart, true);
        String imageLink = demoBlazeSteps.getImageLink();
        Assert.assertEquals(imageLink, expectedImageLinkIphone632gb);
        Assert.assertEquals(demoBlazeSteps.placeOrderBtnIsDisplayed(), true);

        //Adding a second product to the cart
        demoBlazeSteps.getToDemoblazeProductPage("https://www.demoblaze.com/prod.html?idp_=2");
        demoBlazeSteps.clickAddToCart();
        demoBlazeSteps.acceptAlert();
        demoBlazeSteps.goToCartMenuOption();

        int deleteOptions= demoBlazeSteps.getDeleteOptions().size();
        int itemsInShoppingCartCount = demoBlazeSteps.getListOfItemsInShoppingCart().size();
        Assert.assertEquals(deleteOptions,itemsInShoppingCartCount);
        int totalCalculated= demoBlazeSteps.calculateOrdertotal();
        Assert.assertEquals(Integer.parseInt(demoBlazeSteps.getOrdertotalValue()), totalCalculated );
    }


    @AfterTest (alwaysRun = true)
    public void closeBrowser(){
       demoBlazeSteps.cerrarVentana();
    }


}
