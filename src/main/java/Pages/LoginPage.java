package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy (id = "loginusername")
    private WebElement loginUsername;
    @FindBy (id = "loginpassword")
    private  WebElement password;
    @FindBy (xpath = "//button[@onclick='logIn()']")
    private WebElement loginButton;
    @FindBy (id = "nameofuser")
    private WebElement welcomeMessage;



    public WebElement getLoginUsername() {
        return loginUsername;
    }
    public WebElement getPassword() {
        return password;
    }
    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getWelcomeMessage() {
        return welcomeMessage;
    }
}
