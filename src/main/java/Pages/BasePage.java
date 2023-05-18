package Pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver webDriver;
    public BasePage(WebDriver _webdriver) {
        this.webDriver = _webdriver;
    }
}
