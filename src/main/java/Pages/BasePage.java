package Pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver webDriver;

    //constructor
    public BasePage(WebDriver driver){
        this.webDriver = driver;
    }
}