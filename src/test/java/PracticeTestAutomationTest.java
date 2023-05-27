import Steps.PracticeTestAutomationSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.security.util.Password;

public class PracticeTestAutomationTest extends BaseTest{
    private WebDriver webDriver = getWebDriver();
    private PracticeTestAutomationSteps practiceTestAutomation = new PracticeTestAutomationSteps(webDriver);

    @Test
    public void PracticeTestAutomation(){

        practiceTestAutomation.abrirPracticeTestAutomation("https://practicetestautomation.com/practice-test-login/");
        practiceTestAutomation.capturarUsuario("username");
        practiceTestAutomation.capturarPassword("Password123"); //Password123
        practiceTestAutomation.clickOnSubmit();
        practiceTestAutomation.VerifyURLContent("practicetestautomation.com/logged-in-successfully/");
        practiceTestAutomation.VerifyTextShowed();
        practiceTestAutomation.VerifyPrecenseOfLogOutButton();

        practiceTestAutomation.finalizarWebDriver();
    }
}

