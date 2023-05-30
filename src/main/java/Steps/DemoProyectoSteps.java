package Steps;

import Pages.DemoProyectoPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertNotEquals;


public class DemoProyectoSteps extends BaseSteps {
    public DemoProyectoSteps(WebDriver driver) {
        super(driver);
    }
    DemoProyectoPage demoProyectoPage = PageFactory.initElements(webDriver, DemoProyectoPage.class);

    public void abrirPaginaDemoQA() throws InterruptedException {
        Thread.sleep(1000);
        webDriver.get("https://www.demoblaze.com/");
    }

    public void clickSubmit(int seleccion)throws InterruptedException {
        Thread.sleep(1000);
        WebElement botonSubmit = webDriver.findElement(By.xpath("//a[@href='prod.html?idp_=" + seleccion + "']"));
        botonSubmit.click();
    }

    public void waitButtonVisibleExplicitDescripcion() {
        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOf(
                        demoProyectoPage.getTituloTextoProducto()));
    }

    public String obtenerTituloDescripcion() {
        WebElement contenidoTexto = demoProyectoPage.getTituloTextoProducto();
        return contenidoTexto.getText();
    }

    public String obtenerInfoProducto() {
        WebElement contenidoTexto = demoProyectoPage.getDetalleInfProducto();
        return contenidoTexto.getText();
    }

    public String obtenerNombreProducto() {
        WebElement contenidoTexto = demoProyectoPage.getNombreProducto();
        return contenidoTexto.getText();
    }

    public String obtenerPrecioProducto() {
        WebElement contenidoTexto = demoProyectoPage.getTextoPrecio();
        String cadena =  contenidoTexto.getText();
          char[] cadenaCaracter=cadena.toCharArray();
          String precioArticulo="";
          for(int i=0;i<cadenaCaracter.length;i++){
              if (Character.isDigit(cadenaCaracter[i])){
                  precioArticulo+=cadenaCaracter[i];
              }
          }
        return precioArticulo;
    }

    public boolean botonAddCar() {
        WebElement elementoVista = demoProyectoPage.getBotonAgregarCompra();
        return elementoVista.isDisplayed();
    }

    public void clicAddCar() {
        try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
        WebElement elementoVista = demoProyectoPage.getBotonAgregarCompra();
        Assert.assertTrue(elementoVista.isDisplayed());
        elementoVista.click();
    }

    public void mensajeAlerta() {
        Alert alert = new WebDriverWait(webDriver,
                Duration.ofSeconds(2)).until(ExpectedConditions.alertIsPresent());
        String mesajeText = alert.getText();
        alert.accept();
        Assert.assertEquals(mesajeText,"Product added");
    }

    public boolean imagenProductoVisible() {
        WebElement elementoVista = demoProyectoPage.getImagenVisible();
        return elementoVista.isDisplayed();
    }

    public void clickCarroCompras() throws InterruptedException {
        Thread.sleep(1000);
        WebElement botonSubmit = demoProyectoPage.getOpcionCarts();
        botonSubmit.click();
    }

    public List<WebElement> getListaCar() throws InterruptedException {
        Thread.sleep(1000);
        List<WebElement> listaPrecio = demoProyectoPage.getListaArticulos();
        return listaPrecio;
    }

    public int numeroArticulos() throws InterruptedException {
        Thread.sleep(1000);
        int contador = getListaCar().size();
        return contador;
    }

    public void tablaListaProductos() {
        int rowsize = demoProyectoPage.getRowelements().size();
        int colsize = demoProyectoPage.getColumnelements().size();

        for (int i = 1; i < rowsize; i++) {
            assertNotEquals(webDriver.findElement(By.xpath("//table//tr[" + i + "]//td[1]//img")).getAttribute("src"), null);
            for (int j = 2; j <= colsize; j++) {
                assertNotEquals(webDriver.findElement(By.xpath("//table//tr[" + i + "]//td[" + j + "]")).getText(),null);
            }
        }

    }

    public String precioTotal(){
        WebElement precio=demoProyectoPage.getTotalCompra();
        return precio.getText();
    }

    public int sumaTotalCompra(){
        int rowsize = demoProyectoPage.getRowelements().size();
        int totalBruto=0;
        for (int i = 1; i < rowsize; i++) {
            totalBruto += Integer.valueOf(webDriver.findElement(By.xpath("//table//tr[" + i + "]//td[3]")).getText());
        }
        return totalBruto;
    }

    public boolean buttonPlaceOrder() {
        WebElement buttonOrder = demoProyectoPage.getButtonOrden();
        return buttonOrder.isDisplayed();
    }

}
