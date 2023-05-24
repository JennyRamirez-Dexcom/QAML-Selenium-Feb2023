package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ColorChangePage extends BasePage {

    public ColorChangePage(WebDriver _webDriver) {
        super(_webDriver);
    }

    public WebElement setColorChangeBox() {
        return webDriver.findElement(By.id("colorChange"));
    }

    public WebElement setVisibleAfterBox() {
        return webDriver.findElement(By.id("visibleAfter"));
    }

    public WebElement getColorChangeBox() {
        return setColorChangeBox();
    }

    public WebElement getVisibleAfterBox() {
        return setVisibleAfterBox();
    }
}
