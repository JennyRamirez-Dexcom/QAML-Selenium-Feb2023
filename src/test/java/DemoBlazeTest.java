import Steps.DemoBlazeSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoBlazeTest extends BaseTest{

    public WebDriver webDriver = getWebDriver("Chrome");
    DemoBlazeSteps demoBlazeSteps = new DemoBlazeSteps(webDriver);
    String Iphone632gb = "Iphone 6 32gb";
    String expectedPriceIphone632gb = "$790 *includes tax";
    String priceIphone632gb = "790";
    String expectedDescriptionIphone632gb = "Product description\n" +
            "It comes with 1GB of RAM. The phone packs 16GB of internal storage cannot be expanded. As far as the cameras are concerned, the Apple iPhone 6 packs a 8-megapixel primary camera on the rear and a 1.2-megapixel front shooter for selfies.";
    String expectedImageLinkIphone632gb = "https://www.demoblaze.com/imgs/iphone_6.jpg";

    @BeforeTest (alwaysRun = true)
    public void inizialization(){
        demoBlazeSteps.getToDemoBlazePage();
    }

    @Test (description = "validate product details for Iphone 6 32gb" , priority = 1,groups = {"EndToEndTest"})
    public void productDetailsIphone632gbTest(){
        demoBlazeSteps.findCardByTextAndClick(Iphone632gb);
        Assert.assertEquals(demoBlazeSteps.AddToCartOptionIsDisplayed(),true);
        Assert.assertEquals(demoBlazeSteps.stringProductDescription(),expectedDescriptionIphone632gb);
        Assert.assertEquals(demoBlazeSteps.stringPrice(),expectedPriceIphone632gb);
        Assert.assertEquals(demoBlazeSteps.stringDeviceName(),Iphone632gb);
        Assert.assertEquals(demoBlazeSteps.imageIsDisplayed(),true);
    }

    @Test (description = "Add Product to the cart" , priority = 2, groups = {"EndToEndTest"})
    public void addProductToShoppingCartTest(){
        demoBlazeSteps.getToDemoblazeProductPage("https://www.demoblaze.com/prod.html?idp_=5#");
        demoBlazeSteps.clickAddToCart();
        String alertText = demoBlazeSteps.getTextFromAlert();
        Assert.assertEquals(alertText,"Product added");
        demoBlazeSteps.acceptAlert();

    }

    @Test (description = "Validate Information on Shopping Cart" , priority = 3, groups = {"EndToEndTest"})
    public  void shoppingCartDetailTest1(){
        //Adding a product to the cart
        demoBlazeSteps.getToDemoblazeProductPage("https://www.demoblaze.com/prod.html?idp_=5#"); //https://www.demoblaze.com/prod.html?idp_=2
        demoBlazeSteps.clickAddToCart();
        demoBlazeSteps.acceptAlert();
        demoBlazeSteps.goToCartMenuOption();

        boolean itemExistInCart = demoBlazeSteps.validateISDeviceNameAndPriceInShoppingCart("Iphone 6 32gb", priceIphone632gb );
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
