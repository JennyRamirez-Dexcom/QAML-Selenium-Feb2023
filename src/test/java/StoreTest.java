import Steps.BaseSteps;
import Steps.StoreSteps;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class StoreTest extends BaseTest{
    private WebDriver driver = getWebDriver();
    private StoreSteps storeSteps = new StoreSteps(driver);

    @BeforeSuite
    public void abrirPagina(){
        storeSteps.setUpStore();
    }
    @Test
    public void verifyPhonesIsDisplayed(){
        storeSteps.verifyIsPhonesCategory();
    }
    @Test
    public void  verifyLaptopsIsDisplayed(){
        storeSteps.verifyLaptopsCategory();
    }
    @Test
    public void verifyMonitorsIsDisplayed(){
        storeSteps.verifyIsMonitorsCategory();
    }
    @AfterSuite
    public void tearDown(){
        storeSteps.tearDown();
    }
}
