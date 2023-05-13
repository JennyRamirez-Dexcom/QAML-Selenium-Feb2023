package Pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver webDriver;

    //Constructor
    public BasePage(WebDriver _webDriver){
        this.webDriver = _webDriver;
    }


}
