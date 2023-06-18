package Pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    @FindBy(css = "tr[class='success']>td:nth-child(1)")
    private WebElement productImage;

    @FindBy(css = "tr[class='success']>td:nth-child(2)")
    private WebElement productTitle;

    @FindBy(css = "tr[class='success']>td:nth-child(3)")
    private WebElement productPrice;

    @FindBy(css = "tr[class='success']>td:nth-child(4)")
    private WebElement deleteButton;

    @FindBy(css = "div[class='col-lg-1']")
    private WebElement totalPrice;

    @FindBy(css = "button[class='btn btn-success']")
    private WebElement placeOrderButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPagePresent() {
        try {
            getFluentWait(120, 3).until(ExpectedConditions.visibilityOf(productTitle));
            return true;
        }
        catch (TimeoutException e) {
            return false;
        }
    }

    public boolean validateImage() {
        return productImage.isDisplayed();
    }

    public boolean validateTitle() {
        System.out.println(productTitle.getText());
        return productTitle.isDisplayed();
    }

    public boolean validatePrice() {
        System.out.println(productPrice.getText());
        return productPrice.isDisplayed();
    }

    public boolean validateDeleteLink() {
        System.out.println(deleteButton.getText());
        return deleteButton.isDisplayed();
    }

    public boolean validateTotalPrice() {
        System.out.println(totalPrice.getText());
        return totalPrice.isDisplayed();
    }

    public void placeOrderButton() {
        placeOrderButton.click();
    }
}
