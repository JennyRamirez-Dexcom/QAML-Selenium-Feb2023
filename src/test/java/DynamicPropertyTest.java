import Steps.CalendarioWaitsSteps;
import Steps.DynamicPropertiesSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.support.Color;

public class DynamicPropertyTest extends BaseTest{
    private WebDriver webDriver = getWebDriver();

    private DynamicPropertiesSteps dynamicPropertiesSteps = new DynamicPropertiesSteps(webDriver);

    @Test(description="Boton visible despues de 5 segundos")
    public void visibleAfter5SecondsTest(){

        dynamicPropertiesSteps.abrirPaginaDynamicProperties();
        //System.out.println(Color.fromString(webDriver.findElement(By.className("main-header")).getCssValue("color")).asHex());
        dynamicPropertiesSteps.waitVisibleElement();
        dynamicPropertiesSteps.finalizarWebDriver();

    }

    @Test(description="Cambiar el font despues de 5 segundos")
    public void changeFontAfter5SecondsTest(){
        dynamicPropertiesSteps.abrirPaginaDynamicProperties();
        dynamicPropertiesSteps.waitChangeFontColor();
        dynamicPropertiesSteps.finalizarWebDriver();
    }
}


