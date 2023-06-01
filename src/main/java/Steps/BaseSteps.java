package Steps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseSteps {
    public WebDriver webDriver;

    //Constructor
    public BaseSteps(WebDriver driver) {
        this.webDriver = driver;
    }

    public String getURLActual() {
        return webDriver.getCurrentUrl();
    }

    public String getTituloActual() {
        return webDriver.getTitle();
    }

    public void cerrarVentana() {
        webDriver.close();
    }

    public String getCodigoFuente() {
        return webDriver.getPageSource();
    }

    public void finalizarWebDriver() {
        webDriver.quit();
    }

    public void imprimir(String cadenaAImprimir) {
        System.out.println(cadenaAImprimir);
    }


    public void scrollToElementJS(WebElement element) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void maximizarVentana() {
        webDriver.manage().window().maximize();
    }

    public void scrollToElement(WebElement element) {
        new Actions(webDriver)
                .scrollToElement(element)
                .perform();// <- Luz verde para ejecutar la/las acciones
    }

    public void moveToElementClickDragDrop(WebElement elementDroppable,
                                           WebElement drag) {
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

    public void dragAndDropElement(WebElement elementDrop,
                                   WebElement drag) {
        new Actions(webDriver)
                .dragAndDrop(drag, elementDrop)
                .perform();
    }

    public boolean isCorrectlyDisplayedElement(WebElement element){
        if(element.isDisplayed()){
            return true;
        }else {
            return false;
        }
    }

    //////////////////////




}
