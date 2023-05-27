import Steps.PracticeTestAutomationSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeTestAutomationTest extends BaseTest{
    private WebDriver webDriver = getWebDriver();
    private PracticeTestAutomationSteps practiceTestAutomation = new PracticeTestAutomationSteps(webDriver);

    @Test
    public void PracticeTestAutomation(){

        practiceTestAutomation.abrirPracticeTestAutomation();
        practiceTestAutomation.capturarUsuario();
        practiceTestAutomation.capturarPassword();
        practiceTestAutomation.clickOnSubmit();
        practiceTestAutomation.VerifyURLContent();
        practiceTestAutomation.VerifyTextShowed();
        practiceTestAutomation.VerifyPrecenseOfLogOutButton();

        practiceTestAutomation.finalizarWebDriver();
    }
}

