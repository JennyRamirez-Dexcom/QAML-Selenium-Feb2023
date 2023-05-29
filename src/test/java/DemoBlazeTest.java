import Steps.DemoBlazeSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoBlazeTest extends BaseTest{
    public WebDriver webDriver = getWebDriver("Chrome");
    DemoBlazeSteps demoBlazeSteps = new DemoBlazeSteps(webDriver);
    String Iphone632gb = "Iphone 6 32gb";
    String expectedPriceIphone632gb = "$790 *includes tax";
    String expectedDescriptionIphone632gb = "Product description\n" +
            "It comes with 1GB of RAM. The phone packs 16GB of internal storage cannot be expanded. As far as the cameras are concerned, the Apple iPhone 6 packs a 8-megapixel primary camera on the rear and a 1.2-megapixel front shooter for selfies.";
    String expectedImageIphone632gb;

    @Test
    public void getCardIphone632gb(){
        demoBlazeSteps.getToDemoBlazePage();
        demoBlazeSteps.findCardByText(Iphone632gb);
        Assert.assertEquals(demoBlazeSteps.AddToCartOptionIsDisplayed(),true);
        Assert.assertEquals(demoBlazeSteps.stringProductDescription(),expectedDescriptionIphone632gb);
        Assert.assertEquals(demoBlazeSteps.stringPrice(),expectedPriceIphone632gb);
        Assert.assertEquals(demoBlazeSteps.stringDeviceName(),Iphone632gb);
        Assert.assertEquals(demoBlazeSteps.imageIsDisplayed(),true);
    }


}
