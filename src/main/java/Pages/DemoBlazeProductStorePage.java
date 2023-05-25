package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoBlazeProductStorePage extends BasePage {

    public DemoBlazeProductStorePage(WebDriver driver){
        super(driver);
    }

    private WebElement setCategoryListTitle(){
        return webDriver.findElement(By.xpath("//div[@class='list-group']/a[@id='cat']"));
    }

    public WebElement getCategoryListTitle(){
        return setCategoryListTitle();
    }

    private WebElement setPhonesCategory(){
        return webDriver.findElement(By.xpath("//div[@class='list-group']/a[contains(@onclick,'phone')]"));
    }

    public WebElement getPhonesCategory(){
        return setPhonesCategory();
    }

    private WebElement setNotebooksCategory(){
        return webDriver.findElement(By.xpath("//div[@class='list-group']/a[contains(@onclick,'notebook')]"));
    }

    public WebElement getNoteBooksCategory(){
        return setNotebooksCategory();
    }

    private WebElement setMonitorsCategory(){
        return webDriver.findElement(By.xpath("//div[@class='list-group']/a[contains(@onclick,'monitor')]"));
    }

    public WebElement getMonitorsCategory(){
        return setMonitorsCategory();
    }
}
