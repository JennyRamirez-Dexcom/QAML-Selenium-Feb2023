import Pages.DemoBlazePage;
import Steps.DemoBlazeSteps;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class DemoBlazeTest extends BaseTest {
    private WebDriver driver = getWebDriver();
    DemoBlazeSteps demoBlazeSteps = new DemoBlazeSteps(driver);


    /*@Test(description="SR-12120 flow")
    public void SR12120() throws Exception {
    }
    @Test(description="SR-12121 flow")
    public void SR12121() throws Exception {
    }
    @Test(description="SR-12130 flow")
    public void SR12130() throws Exception {
    }*/
    @Test(description="All flows")
    public void AllRequirements() throws Exception {
        demoBlazeSteps.openDemoBlazePage();
        //SR-12120
        demoBlazeSteps.clickNexus6();
        demoBlazeSteps.prodDisplayImage();
        demoBlazeSteps.prodDisplayName();
        demoBlazeSteps.prodDisplayPrice();
        demoBlazeSteps.prodDisplayDescriptionText();
        //SR-12121
        //demoBlazeSteps.prodDisplayAddCartButton();
        demoBlazeSteps.prodClickAddCartButton();
        demoBlazeSteps.modalPopup();
        //SR-12130
        //demoBlazeSteps.prodDisplayCartLink();
        demoBlazeSteps.prodClickCartLink();
        demoBlazeSteps.cartDisplayImage();
        demoBlazeSteps.cartDisplayTitle();
        demoBlazeSteps.cartDisplayPrice();
        demoBlazeSteps.cartDisplayDelete();
        demoBlazeSteps.cartDisplayTotal();
        demoBlazeSteps.cartDisplayPlaceOrderButton();
    }
}
