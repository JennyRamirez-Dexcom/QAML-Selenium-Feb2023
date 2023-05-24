import Steps.DemoQASteps;
import Steps.DemoBlazeSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoBlazeTest extends BaseTest{
    private WebDriver webDriver = getWebDriver();

    private DemoBlazeSteps demoBlazeSteps = new DemoBlazeSteps(webDriver);

    @Test
    public void practica_5(){
        demoBlazeSteps.abrirPaginaDemoBlaze();
        demoBlazeSteps.selectList();
        demoBlazeSteps.finalizarWebDriver();
    }
}
