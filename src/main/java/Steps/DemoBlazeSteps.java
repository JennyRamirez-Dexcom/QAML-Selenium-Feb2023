package Steps;

import Pages.CalendarioWaitsPage;
import Pages.DemoBlazePage;
import org.asynchttpclient.ClientStats;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class DemoBlazeSteps extends BaseSteps{
    public DemoBlazeSteps(WebDriver driver) {
        super(driver);
    }

    DemoBlazePage demoBlazePage = PageFactory.initElements(webDriver, DemoBlazePage.class);

    public void openDemoBlazePageHome(){

        //webDriver.navigate().to("https://www.demoblaze.com/");
       webDriver.get("https://www.demoblaze.com/");
    }

    public void selectProduct() {
       // Actions action = new Actions(webDriver);
        //action.keyDown(Keys.CONTROL).moveToElement(demoBlazePage.getSelectProduct()).click();

     demoBlazePage.getSelectProduct().click();

       //List<WebElement> items = webDriver.findElements(By.xpath("//*[@id='tbodyid']/div"));
       //items.get(0); //quería seleccionar por medio de un arreglo, pero no funcionó.

    }

    public void webDriverDelayHome(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
       WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tbodyid']/div[1]/div/div/h4")));
    }

    public void webDriverDelayCart(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/a[@class='btn btn-success btn-lg']")));
    }

    public void addToCart(){
        demoBlazePage.getAddToCart().click();
    }

    public void acceptAlert(){
        webDriver.switchTo().alert().accept();
    }

    public String textAlert(){
       String textAlert= webDriver.switchTo().alert().getText();
       return textAlert;
    }

    public String textAlertExpected(){
        String textAlert = "Product added";
        return textAlert;
    }

    public void webDriverDelayAlert(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.alertIsPresent());
    }

   public String checkTextProduct(){
         return demoBlazePage.getProductDescription().getText();

    }

    public String productDescriptionExpected(){
        String productDescription="The Samsung Galaxy S6 is powered by 1.5GHz octa-core Samsung Exynos 7420" +
                " processor and it comes with 3GB of RAM. The phone packs 32GB of " +
                "internal storage cannot be expanded.";
        return productDescription;
    }

    public String priceOfProductExpected(){
        String productPrice="$360 *includes tax";
        return productPrice;
    }

    public String priceOfProduct(){
        return demoBlazePage.getPriceOfProduct().getText();
    }

    public boolean isImagePresent(){
      boolean isPresentImage= demoBlazePage.getImagePresent().isDisplayed();
        return isPresentImage;
    }

    public boolean ImagePresentExpected(){
        return true;
    }

    public String titleProduct(){
        String title = demoBlazePage.getTitlePage().getText();
        return title;
    }

    public String titleProductExpected(){
        String titleProduct = "Samsung galaxy s6";
        return titleProduct;
    }

    public void CartButtom(){
        demoBlazePage.getCartButtom().click();
    }


    public String checkInfoTextCart(int indice) {

        List<WebElement> items = webDriver.findElements(By.xpath("//*[@id='tbodyid']/tr/td"));
       String info= items.get(indice).getText(); //quería seleccionar por medio de un arreglo, pero no funcionó.
        return info;

    }


    public boolean placeOrder() {
    demoBlazePage.getPlaceOrder();
        return true;
    }


    public String totalCart() {
       String total = demoBlazePage.getTotal().getText();
       return total;
    }

    public String expectedTotal(){
        String expectedTotal="360";
        return expectedTotal;
    }


    public boolean checkImageCart(int indice) {

        List<WebElement> items = webDriver.findElements(By.xpath("//*[@id='tbodyid']/tr/td"));
        boolean info= items.get(indice).isDisplayed();
        return true;

    }

    public void webDriverDelayInfoCart(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tbodyid']/tr/td")));
    }

    public void webDriverDelayAlertDisappears(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='cartur']")));
    }


    public String infoTitleCartExpected(){
        String infoTitleCartExpected = "Samsung galaxy s6";
        return infoTitleCartExpected;
    }

    public String xCartExpected(){
       String xCartExpected= "Delete";
        return xCartExpected;
    }

    public String priceCartExpected(){
        String priceCartExpected  = "360";
        return priceCartExpected;
    }

    public boolean isImageceCartExpected(){
        boolean isImageceCartExpected = true;
        return isImageceCartExpected;
    }

    public void closePage(){
        finalizarWebDriver();
    }


    ///
   public void selectMultipliesProducts(){

       List<WebElement> products = webDriver.findElements(By.xpath("//*/h4/a"));


        for (int index = 0; index < products.size(); index++) {
            String productsName = products.get(index).getText();
            System.out.println(productsName);
            }
    }
}

          //  public String checkInfoTextCart(int indice) {

               // List<WebElement> items = webDriver.findElements(By.xpath("//*[@id='tbodyid']/tr/td"));
               // String info= items.get(indice).getText(); //quería seleccionar por medio de un arreglo, pero no funcionó.
               // return info;


            // List<WebElement> products = (List<WebElement>) demoBlazePage.getMultipliesProducts();

            // @FindBy(xpath = "//*[@class='card-img-top img-fluid']")
            //private WebElement multipliesProducts;


           /* List<WebElement> items = webDriver.findElements(By.xpath("//*[@id='tbodyid']/tr/td"));
            boolean info= items.get(indice).isDisplayed();
            return true;*/










