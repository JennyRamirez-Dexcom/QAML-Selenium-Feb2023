package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DemoProyectoPage {

  @FindBy(xpath = "//div[@class='col-lg-4 col-md-6 mb-4']")
  private WebElement productoVer;

  public WebElement getProductoVer() {
        return productoVer;
    }

  //
  @FindBy(xpath = "//div[@id='tbodyid']//strong[text()='Product description']")
  private WebElement tituloTextoProducto;

  public WebElement getTituloTextoProducto() {
        return tituloTextoProducto;
    }

    @FindBy(xpath = "//div[@id='more-information']//p")
    private WebElement detalleInfProducto;

    public WebElement getDetalleInfProducto() {
        return detalleInfProducto;
    }

  @FindBy(xpath = "//div[@id='tbodyid']//h2[@class='name']")
  private WebElement nombreProducto;

  public WebElement getNombreProducto() {
    return nombreProducto;
  }

  @FindBy(xpath = "//div[@id='tbodyid']//h3[@class='price-container']")
  private WebElement textoPrecio;

  public WebElement getTextoPrecio() {
    return textoPrecio;
  }

  @FindBy(xpath = "//a[text()='Add to cart']")
  private WebElement botonAgregarCompra;

  public WebElement getBotonAgregarCompra() {
    return botonAgregarCompra;
  }

  @FindBy(xpath = "//div[@class='item active']//img[@src]")
  private WebElement imagenVisible;

  public WebElement getImagenVisible() {
    return imagenVisible;
  }

  @FindBy(xpath = "//li[@class='nav-item']//a[@id='cartur']")
  private WebElement opcionCarts;

  public WebElement getOpcionCarts() {
    return opcionCarts;
  }

  @FindBy( xpath = "//*[@id='tbodyid']//descendant::tr")
  private List<WebElement> listaArticulos;
  public List<WebElement> getListaArticulos(){
    return listaArticulos;
  }

  @FindBy( xpath = "//table//tr")
  private List<WebElement> rowelements;
  public List<WebElement> getRowelements() {
      return rowelements;
  }
  @FindBy( xpath = "//table//th")
  private List<WebElement> columnelements;
  public List<WebElement> getColumnelements(){
        return columnelements;
  }

  @FindBy( xpath = "//div[@class='panel-heading']//h3[@id='totalp']")
  private WebElement totalCompra;
  public WebElement getTotalCompra(){
    return totalCompra;
  }

  @FindBy( xpath = "//button[text()='Place Order']")
  private WebElement buttonOrden;
  public WebElement getButtonOrden(){
    return buttonOrden;
  }

}
