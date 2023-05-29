package Steps;

import Pages.CartDetailsPage;
import Pages.ProductStoreHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class ProductStoreHomeSteps extends BaseSteps{

    public ProductStoreHomeSteps(WebDriver driver){
        super(driver);
    }

    ProductStoreHomePage productStoreHomePage = PageFactory.initElements(webDriver,ProductStoreHomePage.class);
    public void openProductStoreUrl(){
        openURL("https://www.demoblaze.com/index.html");
    }

    public void validateHomePageIsLoaded(){
        elementExist(productStoreHomePage.getDivCarouselProducts());
        printToConsole("El banner de productos existe" + " >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        scrollToElement(productStoreHomePage.getACategoryListTitle());
        elementExist(productStoreHomePage.getACategoryListTitle());
        printToConsole("El menu de categorias es visible" + " >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    public void reviewProductsDisplayedAtHome(){
        List<WebElement> productsListTitle =  productStoreHomePage.getH4ProductTitle();
        printToConsole("Los productos disponibles son: ");

        for(WebElement productTitle:productsListTitle){
            printToConsole(productTitle.getText());
        }

        printToConsole("Num total de productos en el home: " + productsListTitle.size() + " >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    public void seeProductDetailsByProductIndex(int prodIndex){
        List<WebElement> productsListTitles =  productStoreHomePage.getH4ProductTitle();
        List<WebElement> productsListCards =  productStoreHomePage.getDivProducCard();
        WebElement productTitle = productsListTitles.get(prodIndex);
        WebElement productCard = productsListCards.get(prodIndex);
        printToConsole("Viendo detalle del producto: " + this.getElementText(productTitle) + " >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        productCard.click();
        implicitlyWait(15 );
        String productDetailsUrl = this.getCurrentUrl();
        boolean correctUrl = productDetailsUrl.contains("prod.html?idp_=") ? true : false;
        printToConsole("Url de los detalles del producto: " + this.getCurrentUrl());
        hardAssertBooleanCondition(correctUrl);
    }

    public void openProductDetailsByIndex(int prodIndex){
        List<WebElement> productsListCards =  productStoreHomePage.getDivProducCard();
        WebElement productCard = productsListCards.get(prodIndex);
        implicitlyWait(10);
        productCard.click();
    }

    public void goToHomePage(){
        productStoreHomePage.getLiMenuHome().click();
        fluentWaitElementIsDisplayed(productStoreHomePage.getDivCarouselProducts());
    }

    public void goToCartDetailsPage(){
        productStoreHomePage.getLiMenuCart().click();
        fluentWaitElementIsDisplayed(productStoreHomePage.getLiMenuHome());
    }
}
