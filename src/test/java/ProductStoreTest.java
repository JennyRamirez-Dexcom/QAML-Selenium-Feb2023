import Steps.CartDetailsSteps;
import Steps.ProductDetailsSteps;
import Steps.ProductStoreHomeSteps;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProductStoreTest extends BaseTest{

    private WebDriver webDriver = getWebDriver();
    private ProductStoreHomeSteps productStoreHomeSteps = new ProductStoreHomeSteps(webDriver);
    private ProductDetailsSteps productDetailsSteps = new ProductDetailsSteps(webDriver);
    private CartDetailsSteps cartDetailsSteps = new CartDetailsSteps(webDriver);

    @BeforeTest(description = "Precondiciones para todos los test", alwaysRun = true)
    public void beforeScenario(){
        //Abre la url del sitio
        productStoreHomeSteps.openProductStoreUrl();

        //Valida que el usuario esta en el home
        productStoreHomeSteps.validateHomePageIsLoaded();

        //Imprime a consola el total de los productos desplegados en el home y el nombre de cada uno de ellos
        productStoreHomeSteps.reviewProductsDisplayedAtHome();
    }

    @Test(description = "SR-12120: Cliking any of the products in the catalog displayed in the home page will display all the details",
            priority = 1)
    public void testSR12120(){
        //Da click en un producto de la lista desplegada en el home
        productStoreHomeSteps.seeProductDetailsByProductIndex(2);

        //Verifica que todos los elementos del producto esten visibles
        productDetailsSteps.verifyProductDetailsAreCorrectlyDisplayed();

        //Imprime a consola los detalles del producto seleccionado
        productDetailsSteps.printProductDetails();

        //Regresa al home del sitio
        productStoreHomeSteps.goToHomePage();
    }

    @Test(description = "SR-12121: Clicking add to cart button will display browser alert with the text of Product added and the OK button acept",
            priority = 2)
    public void testSR12121() throws Exception {
        //Entra a la seccion de detalle de un producto seleccionado
        productStoreHomeSteps.seeProductDetailsByProductIndex(3);

        //Verifica que todos los elementos del producto esten visibles
        productDetailsSteps.verifyProductDetailsAreCorrectlyDisplayed();

        //Agrega el producto al carrito de compra y verifica aparezca la ventana de alerta
        productDetailsSteps.addProductToCard();

        //Navega a la seccion del carrrito de compra
        productStoreHomeSteps.goToCartDetailsPage();

        //Elimina el producto que fue agregado previamente
        cartDetailsSteps.deleteProducts();

        //Regresa al home del sitio
        productStoreHomeSteps.goToHomePage();
    }

    @Test(description = "SR-12130: Clicking the cart link will display all the details of the products added to the cart",
            priority = 3, groups = {"smoke"})
    public void testSR12130() throws Exception {
        //Agrega 2 productos al carrito de compra
        cartDetailsSteps.addSeveralProductsToCart(2);

        //Revisa que los detalles de los productos agregados se muestren de manera correcta
        cartDetailsSteps.verifyDetailsOfProductsAdded();
    }

    @AfterTest(description = "Cierra el driver siempre despues de cada test", alwaysRun = true)
    public void afterScenario(){
        //Cierra la sesion del driver del navegador
        productStoreHomeSteps.quitWebDriver();
    }
}
