package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.Books;
import pages.CompareProduct;

import java.util.List;
import static stepDefinitions.Hooks.driver;

public class AddToCompare {

    Books books;
    CompareProduct comparePage;


    @And("user add items to compare list")
    public void userAddItemsToCompareList() {
        books = new Books(driver);
        books.addItemsToCompare();
    }

    @And("user navigate to compare list")
    public void userNavigateToCompareList() {
        books.openComparePage();
    }

    @Then("added items should appear at compare list")
    public void addedItemsShouldAppearAtCompareList() {
        comparePage = new CompareProduct(driver);
        Assert.assertEquals(comparePage.getCompareListTitle(), "Compare products");

        List<WebElement> itemsName = comparePage.getItemNames();
        Assert.assertEquals(itemsName.get(2).getText(),"Pride and Prejudice");
        Assert.assertEquals(itemsName.get(1).getText(),"First Prize Pies");
        Assert.assertEquals(itemsName.get(0).getText(),"Fahrenheit 451 by Ray Bradbury");
    }
}
