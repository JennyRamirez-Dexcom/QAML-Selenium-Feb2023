import Pages.CartPage;
import Pages.LandingPage;
import Pages.ProductDetailsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoBlazeTest extends BaseTest {

    @Test(description = "Happy path para  validar la información un producto de la página, acceder al detalle del mismo," +
            "agregarlo al carrito de compras y validar que se muestre correctamente", alwaysRun = true)
    public void demoBlazeTest() throws InterruptedException {
        LandingPage landingPage = new LandingPage(driver.getWebDriver());
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver.getWebDriver());
        CartPage cartPage = new CartPage(driver.getWebDriver());

        //Landing Page
        Assert.assertTrue(landingPage.isPagePresent(), "Landing Page present");
        landingPage.selectElementSamsungGalaxyS6();

        //Product Details Page
        Assert.assertTrue(productDetailsPage.isPagePresent(), "Product Details Page present");
        Assert.assertTrue(productDetailsPage.validateProductTitle(), "Product Title present");
        Assert.assertTrue(productDetailsPage.validateProductPrice(), "Product Price present");
        Assert.assertTrue(productDetailsPage.validateProductDescription(), "Product Description present");
        Assert.assertTrue(productDetailsPage.validateProductImage(), "Product Image present");
        Assert.assertTrue(productDetailsPage.validateAddToCart(), "Add To Cart button present");
        productDetailsPage.clickAddToCart();
        Thread.sleep(2000);
        productDetailsPage.manageWindow();
        productDetailsPage.clickCartButton();

        //Cart Page
        Assert.assertTrue(cartPage.isPagePresent(), "Cart Page present");
        Assert.assertTrue(cartPage.validateImage(), "Product Image present");
        Assert.assertTrue(cartPage.validateTitle(), "Product Title present");
        Assert.assertTrue(cartPage.validatePrice(), "Product Price present");
        Assert.assertTrue(cartPage.validateDeleteLink(), "Delete Link present");
        Assert.assertTrue(cartPage.validateTotalPrice(), "Total Price present");
        cartPage.placeOrderButton();
        Thread.sleep(3000);
    }
}
