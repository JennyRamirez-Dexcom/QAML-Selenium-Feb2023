package Steps;

import Pages.DemoBlazeProductStorePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class DemoBlazeProductStoreSteps extends BaseSteps{

    public DemoBlazeProductStoreSteps(WebDriver driver){
        super(driver);
    }

    DemoBlazeProductStorePage demoBlazeProductStorePage = new DemoBlazeProductStorePage(webDriver);
    public void openDemoBlazerPage(){
        webDriver.get("https://www.demoblaze.com/");
        webDriver.manage().window().maximize();
        imprimir("Accesando a la url de DemoBlaze");
    }

    public boolean isCorrectlyDisplayedCategoryItem(WebElement element){
        if(element.isDisplayed()){
            return true;
        }else{
            return false;
        }
    }

    public boolean isCorrectElmentText(WebElement element, String txtToCompare){
        imprimir("El texto del elemento html es: " + element.getText());
        if(element.getText().equals(txtToCompare)){
            return true;
        }else{
            return false;
        }
    }

    public void verifyCategoryListIsDisplayed(){
        boolean catList = isCorrectlyDisplayedCategoryItem(demoBlazeProductStorePage.getCategoryListTitle());
        imprimir("La lista de categorias exist: " + catList);
        Assert.assertEquals(catList,true);

        String catListText = "CATEGORIES";
        boolean isCorrectText = isCorrectElmentText(demoBlazeProductStorePage.getCategoryListTitle(),catListText);
        imprimir("El titulo de la lista de Categorias esta correcto: " + isCorrectText);
        Assert.assertEquals(isCorrectText,true);
    }

    public void verifyCategoryItemExist(WebElement element, String htmlText){
        boolean elementExist = isCorrectlyDisplayedCategoryItem(element);
        imprimir("La categoria de: " + htmlText + " existe: " + elementExist);
        Assert.assertEquals(elementExist,true);

        boolean isCorrectCategoryText = isCorrectElmentText(element,htmlText);
        imprimir("El titulo de la categoria: " + htmlText + " esta correcto: " + isCorrectCategoryText);
        Assert.assertEquals(isCorrectCategoryText,true);
    }

    public void verifyAllCategoriesExist(){
        verifyCategoryItemExist(demoBlazeProductStorePage.getPhonesCategory(), "Phones");
        verifyCategoryItemExist(demoBlazeProductStorePage.getNoteBooksCategory(), "Laptops");
        verifyCategoryItemExist(demoBlazeProductStorePage.getMonitorsCategory(), "Monitors");
    }
}
