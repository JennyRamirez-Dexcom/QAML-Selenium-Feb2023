package Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() { return wait; }

    public void end() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    protected Wait<WebDriver> getFluentWait(long timeoutSecs, long everySecs) {
        return new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeoutSecs))
                .pollingEvery(Duration.ofSeconds(everySecs))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
    }
}
