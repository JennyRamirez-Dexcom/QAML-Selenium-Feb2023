package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InformacionDeProductoPage {
    @FindBy(xpath = "//a[@class='btn btn-success btn-lg']")
    private WebElement botonAddToCart;

    public WebElement getBotonAddToCart(){
        return botonAddToCart;
    }

    @FindBy(xpath = "//div[@id='more-information']/p")
    private WebElement descripcionDeProducto;

    public WebElement getDescripcionDeProducto(){
        return descripcionDeProducto;
    }

    @FindBy(xpath = "//h3[@class='price-container']")
    private WebElement precioDeProducto;

    public WebElement getPrecioDeProducto(){
        return precioDeProducto;
    }

    @FindBy(xpath = "//h2[@class='name']")
    private WebElement nombreDelProducto;

    public WebElement getNombreDelProducto(){
        return nombreDelProducto;
    }

    @FindBy(xpath = "//div[@class='item active']/img")
    private WebElement imagenDeProducto;

    public WebElement getImagenDeProducto(){
        return imagenDeProducto;
    }


}
