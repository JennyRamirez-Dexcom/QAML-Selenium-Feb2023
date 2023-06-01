import Steps.DemoBlazeSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class DemoBlazeTest extends BaseTest {
    private WebDriver webDriver = getWebDriver();
    DemoBlazeSteps demoBlazeSteps = new DemoBlazeSteps(webDriver);


    @BeforeTest(description = "Se abrirá la pantalla al home y le dará un tiempo al driver para que la página cargue correctamente", groups = "Test unitario")
    public void openPageHome(){

        demoBlazeSteps.openDemoBlazePageHome();
        demoBlazeSteps.maximizarVentana();
        demoBlazeSteps.webDriverDelayHome();

       demoBlazeSteps.selectProduct();
       demoBlazeSteps.webDriverDelayCart();
       demoBlazeSteps.addToCart();
       demoBlazeSteps.webDriverDelayAlert();

    }

    @Test(description = "SR-12120 ", priority = 2, groups = "Test Unitario")
    public void addToCartProduct() {

        demoBlazeSteps.acceptAlert();

        Assert.assertEquals(demoBlazeSteps.checkTextProduct(), demoBlazeSteps.productDescriptionExpected());
        Assert.assertEquals(demoBlazeSteps.priceOfProduct(), demoBlazeSteps.priceOfProductExpected());
        Assert.assertEquals(demoBlazeSteps.isImagePresent(), demoBlazeSteps.ImagePresentExpected());
        Assert.assertEquals(demoBlazeSteps.titleProduct(), demoBlazeSteps.titleProductExpected());
    }

      @Test(description = "SR-12121", priority = 1, groups = "Test Unitario")
      public void productAddedAlert(){

        Assert.assertEquals(demoBlazeSteps.textAlert(), demoBlazeSteps.textAlertExpected());

      }


    @Test(description = "SR-12130", priority = 3, groups = "Test Unitario")
    public void cart(){

        demoBlazeSteps.CartButtom();
        demoBlazeSteps.webDriverDelayInfoCart();

        Boolean isImageceCart = demoBlazeSteps.checkImageCart(0);
        String infoTitleCart = demoBlazeSteps.checkInfoTextCart(1);
        String priceCart = demoBlazeSteps.checkInfoTextCart(2);
        String xCart = demoBlazeSteps.checkInfoTextCart(3);
        boolean isPresentPlaceOrder = demoBlazeSteps.placeOrder();
        String total =demoBlazeSteps.totalCart();


        Assert.assertEquals(isImageceCart, demoBlazeSteps.isImageceCartExpected());
        Assert.assertEquals(infoTitleCart, demoBlazeSteps.infoTitleCartExpected());
        Assert.assertEquals(priceCart, demoBlazeSteps.priceCartExpected());
        Assert.assertEquals(xCart, demoBlazeSteps.xCartExpected());
        Assert.assertEquals(isPresentPlaceOrder, true);
        Assert.assertEquals(total,demoBlazeSteps.expectedTotal());


    }

    @AfterTest(description = "close page")
    public void close(){
        demoBlazeSteps.closePage();
    }

    //hice un test para revisar todos los nombres del home, No pedido en el requerimiento
    //por eso está comentado, pero dunciona

   /* @Test(description = "comprar varios productos", groups = "Test múltiple")
    public void addMultipliesProducts(){
    demoBlazeSteps.selectMultipliesProducts();
    }*/

}


