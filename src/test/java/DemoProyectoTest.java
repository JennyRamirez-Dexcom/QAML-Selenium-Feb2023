import Steps.DemoProyectoSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoProyectoTest extends BaseTest {
    private WebDriver webDriver = getWebDriver();
    private DemoProyectoSteps demoProyectoSteps = new DemoProyectoSteps(webDriver);

    @BeforeTest(description = "Inicio página",alwaysRun = true)
    public void beforeDemoQATests() throws InterruptedException {
        demoProyectoSteps.imprimir("--------PROYECTO FINAL--------");
        demoProyectoSteps.abrirPaginaDemoQA();
        demoProyectoSteps.maximizarVentana();
    }

    @Test(description = "SR-12120-Productos del catálogo que se muestren elementos",priority = 0)
    public void productoCatologoDetalle() throws InterruptedException {
        demoProyectoSteps.imprimir("SR-12120");
        demoProyectoSteps.abrirPaginaDemoQA();
        demoProyectoSteps.clickSubmit(1);

       demoProyectoSteps.waitButtonVisibleExplicitDescripcion();
        String tituloDescripcionActual=demoProyectoSteps.obtenerTituloDescripcion();
        String tituloDescripcionEsperada="Product description";
        Assert.assertEquals(tituloDescripcionActual,tituloDescripcionEsperada);

        String descripcionActual=demoProyectoSteps.obtenerInfoProducto();
        String descripcionEsperada="The Samsung Galaxy S6 is powered by 1.5GHz octa-core Samsung Exynos 7420 processor " +
                "and it comes with 3GB of RAM. The phone packs 32GB of internal storage cannot be expanded."; //Cambiar
        Assert.assertEquals(descripcionActual,descripcionEsperada);

        String nombreProductoActual=demoProyectoSteps.obtenerNombreProducto();
        String nombreProductoEsperado="Samsung galaxy s6";
        Assert.assertEquals(nombreProductoActual,nombreProductoEsperado);

        String precioProductoActual=demoProyectoSteps.obtenerPrecioProducto();
        String precioProductoEsperado="360";
        Assert.assertEquals(precioProductoActual,precioProductoEsperado);

        boolean botonActual = demoProyectoSteps.botonAddCar();
        Assert.assertTrue(botonActual);

        boolean imagenActual = demoProyectoSteps.imagenProductoVisible();
        Assert.assertTrue(imagenActual);
        webDriver.manage().deleteAllCookies();
    }

    @Test(description = "SR-12121-Agregar producto,Confirmar mensaje",priority = 1)
    public void mensajeAgregarProducto() throws InterruptedException {
        demoProyectoSteps.imprimir("SR-12121");
        demoProyectoSteps.abrirPaginaDemoQA();
        demoProyectoSteps.clickSubmit(2);

        demoProyectoSteps.clicAddCar();
        demoProyectoSteps.mensajeAlerta();
        demoProyectoSteps.clickCarroCompras();
        webDriver.manage().deleteAllCookies();
    }

    @Test(description = "SR-12130-Al hacer clic en el enlace del carrito, se mostrará listado articulos comprados",
            priority = 2)
    public void verListaCompras() throws Exception {
        webDriver.manage().deleteAllCookies();
        demoProyectoSteps.imprimir("SR-12130");
        demoProyectoSteps.abrirPaginaDemoQA();
        demoProyectoSteps.clickSubmit(4);
        demoProyectoSteps.clicAddCar();
        demoProyectoSteps.mensajeAlerta();

        webDriver.navigate().back();
        webDriver.navigate().back();

        demoProyectoSteps.clickSubmit(5);
        demoProyectoSteps.clicAddCar();
        demoProyectoSteps.mensajeAlerta();

        demoProyectoSteps.clickCarroCompras();
        demoProyectoSteps.getListaCar();
        demoProyectoSteps.tablaListaProductos();

        int numeroArticulosActual=demoProyectoSteps.numeroArticulos();
        int numeroArticulosEsperado=2;
        Assert.assertEquals(numeroArticulosActual,numeroArticulosEsperado);

        String precioTotalActual=demoProyectoSteps.precioTotal();
        String precioTotalActualEsperado= String.valueOf(demoProyectoSteps.sumaTotalCompra());
        Assert.assertEquals(precioTotalActual,precioTotalActualEsperado);

        boolean botonActual = demoProyectoSteps.buttonPlaceOrder();
        Assert.assertTrue(botonActual);

        webDriver.manage().deleteAllCookies();
    }
    @AfterTest(description = "Metodo finaliza el WebDrive",
            alwaysRun = true)
    public void afterDemoQATests() {
        demoProyectoSteps.finalizarWebDriver();
    }
}
