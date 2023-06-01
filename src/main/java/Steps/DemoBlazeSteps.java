package Steps;

import Pages.DemoBlazeCartPage;
import Pages.DemoBlazePage;
import Pages.DemoBlazeSamsungGalaxyS6Page;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.soap.Text;
import java.time.Duration;
import java.time.Instant;
import java.util.function.Function;

public class DemoBlazeSteps extends BaseSteps {
    public DemoBlazeSteps(WebDriver driver) {
        super(driver);
    }

    DemoBlazePage demoBlazePage = PageFactory.initElements(webDriver, DemoBlazePage.class);
    DemoBlazeCartPage demoBlazeCartPage = PageFactory.initElements(webDriver, DemoBlazeCartPage.class);
    DemoBlazeSamsungGalaxyS6Page demoBlazeSamsungGalaxyS6Page = PageFactory.initElements(webDriver, DemoBlazeSamsungGalaxyS6Page.class);

    public void abrirPaginaDemoBlaze() {
        webDriver.get("https://www.demoblaze.com/");
    }

    public void selectProducto(){
        WebElement link = demoBlazePage.getSamsungGalaxyS6();
        link.click();
    }

    public void waitLink(){
        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(demoBlazePage.getSamsungGalaxyS6()));
    }

    public void addToCartIsDisplayed(){
        demoBlazeSamsungGalaxyS6Page.getAddToCart().isDisplayed();
    }

    public void waitAddToCart(){
        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(demoBlazeSamsungGalaxyS6Page.getAddToCart()));
    }

    public void productDescriptionIsDisplayed(){ demoBlazeSamsungGalaxyS6Page.getProductDescription().isDisplayed();}

    public void priceIsDisplayed(){ demoBlazeSamsungGalaxyS6Page.getPrice().isDisplayed();}

    public void nameOfProductIsDisplayed(){ demoBlazeSamsungGalaxyS6Page.getNameOfProduct().isDisplayed();}

    public void imageOfProductIsDisplayed(){ demoBlazeSamsungGalaxyS6Page.getImageOfProduct().isDisplayed();}

    public void selectAddToCart(){
        WebElement link = demoBlazeSamsungGalaxyS6Page.getAddToCart();
        link.click();
    }

    public void cerrarAlerta(){
        Alert alert = new WebDriverWait(webDriver,Duration.ofSeconds(30)).until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        System.out.println(text);
        alert.accept();
    }

    public void selectCartLink(){
        WebElement link = demoBlazeSamsungGalaxyS6Page.getCartLink();
        link.click();
    }

    public String imprimirTotalPrice(){
        return demoBlazeCartPage.getTotalPrice().getText();
    }

    public void placeOrderIsDisplayed(){ demoBlazeCartPage.getPlaceOrder().isDisplayed();}

    public void waitTotalPrice(){
        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(demoBlazeCartPage.getTotalPrice()));
    }

    public void imprimirListOfProducts(){
        for (int i=0; i<demoBlazeCartPage.getListOfProducts().size(); i++){
            String textoLista = demoBlazeCartPage.getListOfProducts().get(i).getText();
            System.out.println("La lista de elementos son: "+textoLista);
        }
    }
}
