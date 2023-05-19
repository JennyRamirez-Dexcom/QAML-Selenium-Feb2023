import Steps.DemoBlazeProductStoreSteps;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class DemoBlazeProductStoreTest extends BaseTest{

    private WebDriver webDriver = getWebDriver();
    private DemoBlazeProductStoreSteps demoBlazeProductStoreSteps = new DemoBlazeProductStoreSteps(webDriver);

    @Test
    public void tareaCategories(){
        demoBlazeProductStoreSteps.openDemoBlazerPage();
        demoBlazeProductStoreSteps.verifyCategoryListIsDisplayed();
        demoBlazeProductStoreSteps.verifyAllCategoriesExist();
        demoBlazeProductStoreSteps.cerrarVentana();
    }
}
