package Steps;

import Pages.ProductDetailsPage;
import Steps.BaseSteps;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailsSteps extends BaseSteps {
    public ProductDetailsSteps(WebDriver driver) {
        super(driver);
    }

    ProductDetailsPage productDetailsPage = PageFactory.initElements(webDriver,ProductDetailsPage.class);

    public void verifyProductDetailsAreCorrectlyDisplayed(){
        hardAssertBooleanCondition(this.isCorrectlyDisplayedElement(productDetailsPage.getImgProduct()));
        hardAssertBooleanCondition(this.isCorrectlyDisplayedElement(productDetailsPage.getH2ProductName()));
        hardAssertBooleanCondition(this.isCorrectlyDisplayedElement(productDetailsPage.getH3ProductPrice()));
        hardAssertBooleanCondition(this.isCorrectlyDisplayedElement(productDetailsPage.getDivProductDescription()));
        hardAssertBooleanCondition(this.isCorrectlyDisplayedElement(productDetailsPage.getBtnAddToCart()));
    }

    public void printProductDetails(){
        printToConsole("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        fluentWaitElementIsDisplayed(productDetailsPage.getImgProduct());
        printToConsole("Nombre del producto: " + this.getElementText(productDetailsPage.getH2ProductName()));
        printToConsole("Precio del producto: " + this.getElementText(productDetailsPage.getH3ProductPrice()));
        printToConsole("Descripción del producto: " + this.getElementText(productDetailsPage.getDivProductDescription()));
        printToConsole("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    public void clickOnAddToCartBtn(){
        productDetailsPage.getBtnAddToCart().click();
    }
    public void addProductToCard() throws Exception{
        clickOnAddToCartBtn();
        printToConsole("Agregando producto al carrito de compra...");
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = webDriver.switchTo().alert();
        String txtAlert = alert.getText();
        printToConsole("El texto de la alerta es: " + txtAlert);
        hardAssertStringEquals(txtAlert,"Product added");

        try{
            alert.accept();
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
