package Steps;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BaseSteps {
    public WebDriver webDriver;

    public BaseSteps(WebDriver driver){
        this.webDriver=driver;
    }

    public String getUrlActual(){
        return webDriver.getCurrentUrl();
    }

    public String getTituloActual(){
        return webDriver.getTitle();
    }

    public void cerrarVentana(){
        webDriver.close();
    }

    public String getCodigoFuente(){
        return webDriver.getPageSource();
    }

    public void finalizarWebDriver(){
        webDriver.quit();
    }

    public void imprimir(String cadenaAImprimir){
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
                .perform();
    }

    public void moveToElementClickDragDrop(WebElement elementDroppable, WebElement drag) {
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

    public void dragAndDropElement(WebElement elementDrop, WebElement drag) {
        new Actions(webDriver)
                .dragAndDrop(drag, elementDrop)
                .perform();
    }
}
