package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StorePage extends BasePage{
//    public StorePage(WebDriver driver){
//        super(driver);
//    }
    public WebElement PhonesCategorie(){
        return webDriver.findElement(By.xpath("//div[@class='list-group']/child::a[2]"));
    }
    public WebElement laptopsCategorie(){
        return webDriver.findElement(By.xpath("//div[@class='list-group']/child::a[3]"));
    }
    public WebElement monitorsCategorie() {
        return webDriver.findElement(By.xpath("//div[@class='list-group']/child::a[4]"));
    }
}
