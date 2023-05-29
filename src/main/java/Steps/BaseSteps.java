package Steps;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class BaseSteps {
    public WebDriver webDriver;

    //Constructor
    public BaseSteps(WebDriver driver) {
        this.webDriver = driver;
    }

    public void printToConsole(String txt) {
        System.out.println(txt);
    }

    public void openURL(String url){
        webDriver.get(url);
        this.maximizeWindow();
        printToConsole("Abriendo sitio web de: " + url);
    }

    public void maximizeWindow() {
        webDriver.manage().window().maximize();
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public String getTituloActual() {
        return webDriver.getTitle();
    }

    public void closeWindow() {
        webDriver.close();
    }

    public String getCodigoFuente() {
        return webDriver.getPageSource();
    }

    public void quitWebDriver() {
        printToConsole("Closing Browser");
        webDriver.quit();
    }

    public void scrollToElementJS(WebElement element) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void scrollToElement(WebElement element) {
        new Actions(webDriver)
                .scrollToElement(element)
                .perform();// <- Luz verde para ejecutar la/las acciones
    }

    public void moveToElementClickDragDrop(WebElement elementDroppable,WebElement drag) {
        int y = elementDroppable.getLocation().y;
        int x = elementDroppable.getLocation().x;
        int sizey = elementDroppable.getSize().height;
        int sizex = elementDroppable.getSize().width;

        int coordx = x + sizex/2;
        int coordy = y + sizey/2;

        new Actions(webDriver)
                .dragAndDropBy(drag, coordx, coordy)
                .perform();
    }

    public void dragAndDropElement(WebElement elementDrop,WebElement drag) {
        new Actions(webDriver)
                .dragAndDrop(drag, elementDrop)
                .perform();
    }

    public void hardAssertBooleanEquals(boolean s1,boolean s2){
        Assert.assertEquals(s1,s2);
    }

    public void hardAssertStringEquals(String s1,String s2){
        Assert.assertEquals(s1,s2);
    }

    public void hardAssertBooleanCondition(boolean condition){
        Assert.assertTrue(condition);
    }

    public boolean isCorrectlyDisplayedElement(WebElement element){
        boolean isDisplayed = false;
        return isDisplayed = element.isDisplayed() ? true : false;
    }

    public boolean isEnabledElement(WebElement element){
        boolean isDisplayed = false;
        return isDisplayed = element.isEnabled() ? true : false;
    }

    public void verifyUrlIsCorrect(String urlExpected,String currentUrl){
        this.hardAssertStringEquals(currentUrl,urlExpected);
    }

    public void sendTextToElement(WebElement ele,String txt){
        ele.sendKeys(txt);
    }

    public String getElementText(WebElement ele){
        return ele.getText();
    }

    public void implicitlyWait(int seconds) {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    public void moveToWebElement(WebElement ele) {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(ele).click().perform();
        actions.release().perform();
    }

    public void elementExist(WebElement ele) {
        try {
            Assert.assertTrue(this.isEnabledElement(ele));
            Assert.assertTrue(this.isCorrectlyDisplayedElement(ele));
        }catch(AssertionError e) {
            Assert.fail("The element doesn't exist !!");
        }
    }

    public void fluentWaitElementIsDisplayed(WebElement ele){
        Wait<WebDriver> fluentWait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        fluentWait.until(webDriver1 -> {
            return ele.isDisplayed();
        });
    }

    public void waitElementIsVisible(WebElement ele){
        WebElement explicitWait = new WebDriverWait(webDriver,Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOf(ele));
    }

    public void waitForElementPresent(WebElement ele) {
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOf(ele));
        }catch(Exception e) {
            throw new IllegalStateException("Web Element not found !!");
        }

    }

    public String getValueOfAttributeElement(WebElement ele,String attribute){
        String value = "";
        value = ele.getAttribute(attribute);
        return value;
    }
}
