package Steps;

import Pages.DemoQADroppablePage;
import Pages.DemoQADynamicPropertiesPage;
import Pages.DemoQASelectMenuPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class DemoQASteps extends BaseSteps {

    public DemoQASteps(WebDriver driver) {
        super(driver);
    }

    DemoQADroppablePage demoQADroppablePage = PageFactory.initElements(webDriver, DemoQADroppablePage.class);
    DemoQASelectMenuPage demoQASelectMenuPage = PageFactory.initElements(webDriver, DemoQASelectMenuPage.class);
    DemoQADynamicPropertiesPage demoQADynamicPropertiesPage = PageFactory.initElements(webDriver, DemoQADynamicPropertiesPage.class);

    public void abrirPaginaDemoQA(){
        webDriver.get("https://demoqa.com/text-box/");

        imprimir("Navegando en DemoQA");
    }

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
    //convertir mi lista a un select
    public void seleccionarColorPorText(String color){
        Select listaColores = new Select(demoQASelectMenuPage.getListaColores());
        listaColores.selectByVisibleText(color);
    }

    public String getColorSeleccionado(){
        Select listaColores = new Select(demoQASelectMenuPage.getListaColores());
        return listaColores.getFirstSelectedOption().getText();
    }

    public void seleccionarColorPorValue(String valor){
        Select listaColores = new Select(demoQASelectMenuPage.getListaColores());
        listaColores.selectByValue(valor);
    }
    public void seleccionarColorPorIndex(int index){
        Select listaColores = new Select(demoQASelectMenuPage.getListaColores());
        listaColores.selectByIndex(index);
    }

    private List<WebElement> getOpcionesColores(){
        Select listaColores = new Select(demoQASelectMenuPage.getListaColores());
        return listaColores.getOptions();
    }
    public void imprimirOpcionesDisponibles(){
        for (WebElement o: getOpcionesColores()) {imprimir(o.getText());
        }
    }
 public void imprimirValoresOpcionesDisponibles(){
       for (WebElement o: getOpcionesColores()) {
            imprimir(o.getAttribute("value"));
        }
    }
    public void scrollHaciaListaCarros(){
        new Actions(webDriver)
                .scrollToElement(demoQASelectMenuPage.getListaCarros())
                .perform();
    }

    private List<WebElement> getOpcionesCarros(){
        Select listaCarros = new Select(demoQASelectMenuPage.getListaCarros());
        return listaCarros.getOptions();
    }
    public void imprimirOpcionesCarrosDisponibles() {
       for (WebElement o : getOpcionesCarros()) {
            imprimir(o.getText());
        }
    }

    public void abrirDroppablePage() {
        webDriver.navigate().to("https://demoqa.com/droppable");
    }

    public void abrirDynamicPropertiesPage(){
        webDriver.get("https://demoqa.com/dynamic-properties");
    }

    public void dragAndDrop() {
        dragAndDropElement(
                demoQADroppablePage.getDivDragabble(),
                demoQADroppablePage.getDivContainer()
        );
    }

    public String getcolorchangeTextColor(){
        String rgbColor = demoQADynamicPropertiesPage.getColorchangeButton().getCssValue("color");
        return Color.fromString(rgbColor).asHex();
    }


    public void waitForVisibleAfter5SecondsTextToBeInputcolor(String color){
        waitForElementuttonTextToBeRed(color);
    }

    private void waitForElementuttonTextToBeRed(String colorIn) {
        Wait<WebDriver> fluentWait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        fluentWait.until(webDriver1 -> {
            String currentColor = demoQADynamicPropertiesPage.getColorchangeButton().getCssValue("color");
            currentColor = Color.fromString(currentColor).asHex();
            return currentColor.equals(colorIn);
        });
    }

    public void waitForVisibleAfter5SecondsButtontoBeDisplayed(){
        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(demoQADynamicPropertiesPage.getVisibleAfter5SecondsButton()));
    }

    public boolean visibleAfter5MinutesISDisplayed() {
        return isCorrectlyDisplayedElement(demoQADynamicPropertiesPage.getVisibleAfter5SecondsButton());

    }
}
