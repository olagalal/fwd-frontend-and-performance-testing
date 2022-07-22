package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.Home;
import pages.Search;
import pages.Tags;

import static stepDefinitions.Hooks.driver;

public class SelectDifferentTags {
    Home home;
    Tags tags;
    Search search;

    @And("user open search page")
    public void userOpenSearchPage() {
        home = new Home(driver);
        home.openSearchPage();
    }

    @And("user choose awesome tag")
    public void userChooseAwesomeTag() {
        search = new Search(driver);
        search.selectAwesomeTag();

    }

    @Then("awesome products page should appear to the user")
    public void awesomeProductAppear() {
        tags = new Tags(driver);
        String awesomeUrl = "https://demo.nopcommerce.com/awesome";
        Assert.assertEquals(tags.getTagsUrl(), awesomeUrl);
    }
}
