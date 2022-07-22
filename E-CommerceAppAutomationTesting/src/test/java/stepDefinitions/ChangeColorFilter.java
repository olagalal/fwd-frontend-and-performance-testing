package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.Home;
import pages.Shoes;

import static stepDefinitions.Hooks.driver;

public class ChangeColorFilter {
    Home home;
    Shoes shoes;

    @And("user hover on apparel category")
    public void userHoverOnAppearlCategory() {
        home = new Home(driver);
        home.hoverOnapparelCat();
    }

    @And("user click on shoes category")
    public void userClickOnShoesCategory() {
        home.clickOnShoesCat();
    }

    @And("user change color to red")
    public void userChangeColorToRed() {
        shoes = new Shoes(driver);
        shoes.selectRedColor();
    }

    @Then("shoes with red color only should appear to the user")
    public void shoesWithRedColorOnlyShouldAppearToTheUser() {
        Assert.assertTrue(shoes.isRedColorSelected());
    }
}
