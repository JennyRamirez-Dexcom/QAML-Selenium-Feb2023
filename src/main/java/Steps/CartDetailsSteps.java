package Steps;

import Pages.CartDetailsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartDetailsSteps extends BaseSteps{
    public CartDetailsSteps(WebDriver driver) {
        super(driver);
    }

    CartDetailsPage cartDetailsPage = PageFactory.initElements(webDriver,CartDetailsPage.class);
    ProductStoreHomeSteps productStoreHomeSteps = new ProductStoreHomeSteps(webDriver);
    ProductDetailsSteps productDetailsSteps = new ProductDetailsSteps(webDriver);

    public void deleteProducts(){
        List<WebElement> btnDeleteList =  cartDetailsPage.getTdProductBtnDelete();
        for(WebElement item:btnDeleteList){
            item.click();
            fluentWaitElementIsDisplayed(cartDetailsPage.getLiMenuCartFromCart());
        }
    }

    public void addSeveralProductsToCart(int numProducts) throws Exception {
        for(int x=0; x<numProducts; x++){
            productStoreHomeSteps.openProductDetailsByIndex(x);
            productDetailsSteps.addProductToCard();
            productStoreHomeSteps.goToHomePage();
        }

        productStoreHomeSteps.goToCartDetailsPage();
    }

    public void verifyDetailsOfProductsAdded(){
        List<WebElement> productList =  cartDetailsPage.getTrProductAdded();
        List<WebElement> imgList =  cartDetailsPage.getTdProductImage();
        List<WebElement> titleList =  cartDetailsPage.getTdProductTitle();
        List<WebElement> priceList =  cartDetailsPage.getTdProductPrice();
        List<WebElement> btnDeleteList =  cartDetailsPage.getTdProductBtnDelete();

        printToConsole(" ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        printToConsole("Se agregaron " + productList.size() + " productos al carrito que son: ");

        int x=0;
        for(WebElement item:productList){
            hardAssertBooleanCondition(isCorrectlyDisplayedElement(imgList.get(x)));
            hardAssertBooleanCondition(isCorrectlyDisplayedElement(titleList.get(x)));
            hardAssertBooleanCondition(isCorrectlyDisplayedElement(priceList.get(x)));
            hardAssertBooleanCondition(isCorrectlyDisplayedElement(btnDeleteList.get(x)));

            printToConsole("Imagen del producto: " + getValueOfAttributeElement(imgList.get(x),"src"));
            printToConsole("Titulo del producto: " + getElementText(titleList.get(x)));
            printToConsole("Precio del producto: " + getElementText(priceList.get(x)));
            printToConsole("Link delete del producto: " + getElementText(btnDeleteList.get(x)));
            x++;
            printToConsole(" -------------------------------------------------------------------------------------------------------");
        }

        hardAssertBooleanCondition(isCorrectlyDisplayedElement(cartDetailsPage.getH3TotalCart()));
        hardAssertBooleanCondition(isCorrectlyDisplayedElement(cartDetailsPage.getBtnPlaceOrder()));
        printToConsole("El total de los productos es: " + getElementText(cartDetailsPage.getH3TotalCart()));
        printToConsole("El boton para procesar la compar esta activado: " + isEnabledElement(cartDetailsPage.getBtnPlaceOrder()));
    }
}
