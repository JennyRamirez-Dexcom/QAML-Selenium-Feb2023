package Pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDetailsPage extends BasePage {

    @FindBy(css = "h2[class='name']")
    private WebElement productTitle;

    @FindBy(css = "h3[class='price-container']")
    private WebElement productPrice;

    @FindBy(id = "myTabContent")
    private WebElement productDescription;

    @FindBy(id = "imgp")
    private WebElement productImage;

    @FindBy(css = "a[class='btn btn-success btn-lg']")
    private WebElement addToCart;

    @FindBy(id = "cartur")
    private WebElement cartButton;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPagePresent() {
        try {
            getFluentWait(60, 5).until(ExpectedConditions.visibilityOf(productTitle));
            return true;
        }
        catch (TimeoutException e) {
            return false;
        }
    }

    public boolean validateProductTitle() {
        return productTitle.isDisplayed();
    }

    public boolean validateProductPrice() {
        return productPrice.isDisplayed();
    }

    public boolean validateProductDescription() {
        return productDescription.isDisplayed();
    }

    public boolean validateProductImage() {
        return productImage.isDisplayed();
    }

    public boolean validateAddToCart() {
        return addToCart.isDisplayed();
    }

    public void clickAddToCart() {
        addToCart.click();
    }

    public void manageWindow() {
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }

    public void clickCartButton() {
        cartButton.click();
    }
}
