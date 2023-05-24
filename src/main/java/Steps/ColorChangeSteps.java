package Steps;

import Pages.ColorChangePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ColorChangeSteps extends BaseSteps {
    public ColorChangeSteps(WebDriver driver) {
        super(driver);
    }

    ColorChangePage colorChangePage = new ColorChangePage(webDriver);

    public void abrirPaginaDemoQA() {
        webDriver.get("https://demoqa.com/dynamic-properties");
    }

    public void explicitWait() {
        WebElement wait = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(colorChangePage.getColorChangeBox()));
    }

    public void executeColorChange() {
        colorChangePage.getColorChangeBox();
        explicitWait();
        colorChangePage.getVisibleAfterBox();
    }
}
