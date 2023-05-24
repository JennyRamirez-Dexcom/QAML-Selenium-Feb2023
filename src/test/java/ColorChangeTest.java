import Steps.ColorChangeSteps;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ColorChangeTest extends BaseTest {
    private WebDriver webDriver = getWebDriver();
    ColorChangeSteps colorChangeSteps = new ColorChangeSteps(webDriver);

    @Test
    public void colorChangeTest () {
        colorChangeSteps.abrirPaginaDemoQA();
        colorChangeSteps.explicitWait();
        colorChangeSteps.executeColorChange();
    }
}
