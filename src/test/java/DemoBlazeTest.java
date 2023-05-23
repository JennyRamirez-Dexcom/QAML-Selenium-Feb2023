import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import Steps.DemoBlazeSteps;

public class DemoBlazeTest extends BaseTest{
    //private WebDriver webDriver = getDriver("Edge");
    public WebDriver webDriver = getWebDriver() ;
    private DemoBlazeSteps demoBlazeSteps = new DemoBlazeSteps(webDriver);

    @Test
    public void validateMenuOptionsCount(){
        demoBlazeSteps.gettoDemoblazePage();
        int menuOptionsCount = demoBlazeSteps.countMenuOptions();
        demoBlazeSteps.printMenuOptions();
        Assert.assertEquals(menuOptionsCount, 3);
        demoBlazeSteps.finalizarWebDriver();
    }

}
