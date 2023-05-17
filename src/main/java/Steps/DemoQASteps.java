package Steps;

import Pages.DemoQASelectMenuPage;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class DemoQASteps extends BaseSteps{

    public DemoQASteps(WebDriver driver) {

        super(driver);
    }

    DemoQASelectMenuPage  demoQASelectMenuPage = new DemoQASelectMenuPage(webDriver); //creando instancia del POM



    public void abrirPaginaDemoQA(){
        webDriver.get("https://demoqa.com/text-box/");

        imprimir("Navegando en DemoQA");
    }
//    public boolean checkFullNameEmailIsDisplayed(){
//        WebElement fullName = webDriver.findElement(
//                By.cssSelector("input[type='text']")
//        );
//        imprimir("Full Name" + isCorrectlyDisplayedElement(fullName));
//        return isCorrectlyDisplayedElement(fullName);
//    }
//    public boolean checkEmailIsDisplayed(){
//        WebElement email = webDriver.findElement(
//                By.cssSelector("input[type='email']")
//        );
//        imprimir("Email: " + isCorrectlyDisplayedElement(email));
//        return isCorrectlyDisplayedElement(email);
//    }
//    public boolean checkCurrentAddressIsDisplayed(){
//        WebElement currentAddress = webDriver.findElement(
//                By.cssSelector("textarea[id='currentAddress']")
//        );
//        imprimir("Current Address: " + isCorrectlyDisplayedElement(currentAddress));
//        return isCorrectlyDisplayedElement(currentAddress);
//    }
//    public boolean permanentAddressIsDisplayed(){
//        WebElement permanentAddress = webDriver.findElement(
//                By.cssSelector("label[id='permanentAddress-label']")
//        );
//        imprimir("Permanent Address: " + isCorrectlyDisplayedElement(permanentAddress));
//        return isCorrectlyDisplayedElement(permanentAddress);
//    }

//    public boolean submitEnabled(){
//        WebElement submit = webDriver.findElement(
//                By.cssSelector("button[class='btn btn-primary']")
//        );
//        imprimir("Submit is enabled: " + isEnableElement(submit));
//        return isEnableElement(submit);
//    }

    public void fillForm(){
        WebElement sendFullName = webDriver.findElement(By.id("userName"));
        sendFullName.sendKeys("Yuri Ordaz");
        WebElement email = webDriver.findElement(By.id("userEmail"));
        email.sendKeys("yuri@gmail.com");
        WebElement currentAddress = webDriver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Av.Saturno #555");
        WebElement permanentAddress = webDriver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("Calle Marte #888");
    }


    public void enviarFullName(String nombreCompleto){
        webDriver.findElement(By.id("userName")).sendKeys(nombreCompleto);
    }

    public void enviarEmail(String correoElectronico){
        webDriver.findElement(By.id("userEmail")).sendKeys(correoElectronico);
    }

    public void enviarCurrentAddress(String direccionActual){
        webDriver.findElement(By.id("currentAddress")).sendKeys(direccionActual);

    }

    public void enviarPermanentAddress(String direccionPermanente){
        webDriver.findElement(By.id("permanentAddress")).sendKeys(direccionPermanente);
    }

    public void clickSubmit(){
        WebElement botonSubmit = webDriver.findElement(By.cssSelector("button[id='submit']"));
        botonSubmit.click();
    }
    public void navegarSelectMenuPage(){
        webDriver.navigate().to("https://demoqa.com/select-menu");
    }
    public void seleccionarColorPorText(String color){ //qué color selecciona, el método recibe una cadena "Color"
        Select listaColores = new Select(demoQASelectMenuPage.getListaColores());
        listaColores.selectByVisibleText(color);
    }

    public String getColorSeleccionado(){
        Select listaColores = new Select(demoQASelectMenuPage.getListaColores());
        return listaColores.getFirstSelectedOption().getText();
    }

    public void seleccionarColorPorIndex(int index){
        Select listaColores = new Select(demoQASelectMenuPage.getListaColores());
        listaColores.selectByIndex(index);
    }

    public void seleccionarColorPorValue(String valor) {
        Select listaColores = new Select(demoQASelectMenuPage.getListaColores());
        listaColores.selectByValue(valor);
    }

    private List<WebElement> getOpcionesColores(){
        Select listaColores = new Select(demoQASelectMenuPage.getListaColores());
        return listaColores.getOptions();
    }

    public void imprimirOpcionesDisponibles(){
        for (WebElement opcion: getOpcionesColores()) {
            imprimir(opcion.getText());
        }
    }

    public void imprimirValoresOpcionesColoresDisponibles(){
        for (WebElement opciones: getOpcionesColores()) {
            imprimir(opciones.getAttribute("value"));
        }
    }

    public void scrollHaciaListaCarros(){
    new Actions(webDriver)
            .scrollToElement(demoQASelectMenuPage.getListaCarros())
            .perform();
        }


    private List<WebElement> getOpcionesCarros(){
        Select listaColores = new Select(demoQASelectMenuPage.getListaCarros());
        return listaColores.getOptions();
    }

    public void imprimirOpcionesCarrosDisponibles(){
        for (WebElement opcion: getOpcionesCarros()) {
            imprimir(opcion.getText());
        }
    }
}


