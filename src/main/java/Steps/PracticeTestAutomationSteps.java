package Steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PracticeTestAutomationSteps extends BaseSteps{
    public PracticeTestAutomationSteps(WebDriver driver) {
        super(driver);
    }
    public void abrirPracticeTestAutomation(String pagina) {
        webDriver.get("https://practicetestautomation.com/practice-test-login/");
    }
    public void capturarUsuario(String UserName){
        WebElement username = webDriver.findElement(
                By.id("username")
        );
        username.sendKeys(UserName);
    }
    public void capturarPassword(String Password){
        WebElement password = webDriver.findElement(
                By.id("password")
        );
        password.sendKeys(Password);
    }
    public void clickOnSubmit(){
        WebElement submit = webDriver.findElement(By.id("submit"));
        submit.click();
    }

    public void VerifyURLContent(String textoDeseado){
        String practiceTestAutomationURL = webDriver.getCurrentUrl();
        //String textoDeseado = "practicetestautomation.com/logged-in-successfully/";

        if (practiceTestAutomationURL.contains(textoDeseado)){
            System.out.println("URL SI contiene texto deseado");
        } else{
            System.out.println("URL NO contiene texto deseado");
        }
    }

    public void VerifyTextShowed(){
        WebElement loginText = webDriver.findElement(By.cssSelector(".post-header"));
        WebElement congratulationsText = webDriver.findElement(By.cssSelector(".post-content"));

        if (loginText.getText().contains("Logged") || congratulationsText.getText().contains("Congratulations")){
            System.out.println("Si se encuentran los textos deseados");
        } else{
            System.out.println("No se encuentran los textos deseados");
        }
    }

    public void VerifyPrecenseOfLogOutButton(){
        boolean logoutButton = webDriver.findElement(By.linkText("Log out")).isDisplayed();
        if (logoutButton){
            System.out.println("Si se muestra el botón Log out");
        } else
            Assert.fail("No se encontró el botón Log out");
    }
}
