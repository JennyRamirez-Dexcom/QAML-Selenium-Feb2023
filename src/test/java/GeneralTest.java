import Helpers.Card;
import Steps.DemoBlazeSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class GeneralTest extends BaseTest{

    public WebDriver webDriver = getWebDriver("Chrome");
    DemoBlazeSteps demoBlazeSteps = new DemoBlazeSteps(webDriver);

    String Iphone632gb = "Iphone 6 32gb";
    String expectedPriceIphone632gb = "$790 *includes tax";
    String priceIphone632gb = "790";
    String expectedDescriptionIphone632gb = "Product description\n" +
            "It comes with 1GB of RAM. The phone packs 16GB of internal storage cannot be expanded. As far as the cameras are concerned, the Apple iPhone 6 packs a 8-megapixel primary camera on the rear and a 1.2-megapixel front shooter for selfies.";
    String expectedImageLinkIphone632gb = "https://www.demoblaze.com/imgs/iphone_6.jpg";
    //List<String> list= Arrays.asList("Home (current)", "Contact", "About us", "Cart", "Log in", "Sign up");
    List<String> publicMenuOptionsExpected = new ArrayList<String>() {{
        add("Home\n" + "(current)");
        add("Contact");
        add("About us");
        add("Cart");
        add("Log in");
        add("Sign up");
    } };
    @BeforeTest(alwaysRun = true)
    public void inizialization(){
        demoBlazeSteps.getToDemoBlazePage();
    }

    @Test(priority = 1, groups = {"Sanity"})
    public void validateMenuOptionsGuessMode (){
        List<String> menuOptions = demoBlazeSteps.getMenuOptions();
        demoBlazeSteps.printOut("Options found" + menuOptions);
        Assert.assertEquals(menuOptions,publicMenuOptionsExpected);
    }

    @Test (priority = 3, groups = {"EndToEndTest","Sanity"} )
    public void loginSucess(){
        demoBlazeSteps.goToLoginMenuOption("QADEMOBLAZE", "123");
        Assert.assertEquals(demoBlazeSteps.getWelcomeMessage(), "Welcome QADEMOBLAZE");
    }



    @AfterTest (alwaysRun = true)
    public void closeBrowser(){
       demoBlazeSteps.cerrarVentana();
    }


}
