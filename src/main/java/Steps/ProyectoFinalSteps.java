package Steps;

import Pages.ProyectoFinalPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProyectoFinalSteps extends BaseSteps{
    public ProyectoFinalSteps(WebDriver webDriver){
        super(webDriver);
    }

    ProyectoFinalPage proyectoFinalPage = PageFactory.initElements(webDriver, ProyectoFinalPage.class);

    //SR-12120
    public void abrirPaginaCart(){
        webDriver.get("https://www.demoblaze.com/");
    }

    public void clickFirstElement(){
        //webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(proyectoFinalPage.getFirstItemCard()));

        proyectoFinalPage.getFirstItemCard().click();
        //Assert.assertEquals("https://www.demoblaze.com/prod.html?idp_=1",webDriver.getCurrentUrl());
    }

    public void showingCartButtonFirstElement(){

        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(proyectoFinalPage.getItemCardCartButton()));

        Assert.assertEquals(proyectoFinalPage.getItemCardCartButton().isDisplayed(),true);
        Assert.assertEquals(proyectoFinalPage.getItemCardCartButton().isEnabled(),true);
        Assert.assertEquals(proyectoFinalPage.getItemCardCartButton().getText(),"Add to cart");
    }

    public void showingPlaceOrderButton(){

        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(proyectoFinalPage.getItemCardCartButton()));

        Assert.assertEquals(proyectoFinalPage.getItemCardCartButton().isDisplayed(),true);
        Assert.assertEquals(proyectoFinalPage.getItemCardCartButton().isEnabled(),true);
        Assert.assertEquals(proyectoFinalPage.getItemCardCartButton().getText(),"Place Order");
    }

    public void showingDescriptionFirstElement(){
        Assert.assertEquals(proyectoFinalPage.getItemCardDescription().isDisplayed(),true);
        Assert.assertEquals(proyectoFinalPage.getItemCardDescription().getText().isEmpty(),false);
    }

    public void showingPriceFirstElement(){
        Assert.assertEquals(proyectoFinalPage.getItemCardPrice().isDisplayed(),true);
        Assert.assertEquals(proyectoFinalPage.getItemCardPrice().getText().contains("$"),true);
        Assert.assertEquals(proyectoFinalPage.getItemCardPrice().getText().contains("*includes tax"),true);
    }

    public void showingTitleFirstElement(){
        Assert.assertEquals(proyectoFinalPage.getItemCardTitle().isDisplayed(),true);
    }

    public void showingImageFirstElement(){
        Assert.assertEquals(proyectoFinalPage.getItemCardImage().isDisplayed(),true);
    }
    //SR-12121
    public void clickAddCartButton(){

        showingCartButtonFirstElement();
        proyectoFinalPage.getItemCardCartButton().click();
    }

    public void alertMessageHandling() throws Exception {
        Alert explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());

        Assert.assertEquals(explicitWait.getText(),"Product added");
        try{
            explicitWait.accept();
        }
        catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //SRS-12130
    public void cartLinkClicked(){
        Assert.assertEquals(proyectoFinalPage.getCartNavbar().isDisplayed(),true);
        Assert.assertEquals(proyectoFinalPage.getCartNavbar().isEnabled(),true);
        proyectoFinalPage.getCartNavbar().click();

    }

//place order button same as   showingCartButtonFirstElement()

    public void totalElements(){
        Assert.assertEquals(proyectoFinalPage.getTotalh2Title().isDisplayed(),true);
        Assert.assertEquals(proyectoFinalPage.getTotalh2Title().getText(),"Total");
        System.out.println(proyectoFinalPage.getTotalh3Value().getText());
        //Assert.assertEquals(proyectoFinalPage.getTotalh3Value().isDisplayed(),true);
        Assert.assertEquals(proyectoFinalPage.getTotalh3Value().getAttribute("outerHTML").isEmpty(),false);
    }

    public void cartItemDetails() throws Exception {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //List<WebElement> webElements = webDriver.findElements(By.className("success"));
        System.out.println("lista 1. " + String.valueOf(proyectoFinalPage.getCartItems().size()));
        //System.out.println(webElements.size());
        for (WebElement element: proyectoFinalPage.getCartItems()
             ) {
            List<WebElement> itemValues = element.findElements(By.tagName("td"));
            System.out.println("lista 2. " + String.valueOf(itemValues.size()));
            Assert.assertNotEquals(itemValues.get(0).findElement(By.tagName("img")),null);
            Assert.assertEquals(itemValues.get(1).getText().isEmpty(),false);
            try{
                Assert.assertEquals(Double.isFinite(Double.parseDouble(itemValues.get(2).getText())) ,true);
            }
            catch(Exception e){
                throw new Exception(e.getMessage());
            }
            Assert.assertEquals(itemValues.get(3).getText(),"Delete");

        }

    }

}
