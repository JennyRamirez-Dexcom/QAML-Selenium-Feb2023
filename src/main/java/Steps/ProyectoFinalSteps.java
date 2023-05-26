package Steps;

import Pages.ProyectoFinalPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

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
        proyectoFinalPage.getFirstItemCard().click();
        Assert.assertEquals("https://www.demoblaze.com/prod.html?idp_=1",webDriver.getCurrentUrl());
    }

    public void showingCartButtonFirstElement(){
        Assert.assertEquals(proyectoFinalPage.getItemCardCartButton().isDisplayed(),true);
        Assert.assertEquals(proyectoFinalPage.getItemCardCartButton().isEnabled(),true);
        Assert.assertEquals(proyectoFinalPage.getItemCardCartButton().getText(),"Add to cart");
    }

    public void showingDescriptionFirstElement(){
        Assert.assertEquals(proyectoFinalPage.getItemCardDescription().isDisplayed(),true);
        Assert.assertEquals(proyectoFinalPage.getItemCardDescription().getText().isEmpty(),false);
    }

    public void showingPriceFirstElement(){
        Assert.assertEquals(proyectoFinalPage.getItemCardPrice().isDisplayed(),true);
        Assert.assertEquals(proyectoFinalPage.getItemCardCartButton().getText().contains("$"),true);
        Assert.assertEquals(proyectoFinalPage.getItemCardCartButton().getText().contains("*includes tax"),true);
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
        Alert alert = webDriver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"Product Added");
        try{
            alert.accept();
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
        Assert.assertEquals(proyectoFinalPage.getTotalh3Value().isDisplayed(),true);
        Assert.assertEquals(proyectoFinalPage.getTotalh3Value().getText().isEmpty(),false);
    }

    public void cartItemDetails(){
        for (WebElement element: proyectoFinalPage.getCartItems()
             ) {
            List<WebElement> itemValues = element.findElements(By.tagName("td"));
        }

    }

}
