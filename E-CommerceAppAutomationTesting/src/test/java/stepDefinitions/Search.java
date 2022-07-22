package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.Home;

import java.util.List;

import static stepDefinitions.Hooks.driver;

public class Search {
    Home home;
    pages.Search search;

    @And("user enter name of item to search for")
    public void userEnterNameOfItemToSearchFor() {
        home = new Home(driver);
        home.search("HTC");
    }

    @And("user clicked on search button")
    public void userClickedOnSearchButton() {
        home.clickOnSearchBtn();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("user should have products contains the searched word")
    public void userShouldHaveProductsContainsTheSearchedWord() {
        search = new pages.Search(driver);
        List<WebElement> searchedItems = search.getSearchedItems();
        Assert.assertEquals(searchedItems.get(0).getText(), "HTC One M8 Android L 5.0 Lollipop");
        Assert.assertEquals(searchedItems.get(1).getText(), "HTC One Mini Blue");
        Assert.assertTrue(driver.getCurrentUrl().contains("HTC"));
    }
}
