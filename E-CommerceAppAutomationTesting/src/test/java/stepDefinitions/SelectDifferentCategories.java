package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.Home;

import static stepDefinitions.Hooks.driver;

public class SelectDifferentCategories {
    Home home;

    @And("user hover on electronic category")
    public void userHoverOnElectronicCategory() {
        home = new Home(driver);
        home.hoverOnElectronicsCat();
    }

    @And("user click on cellPhone category")
    public void userClickOnCellPhoneCategory() {
        home.clickOnCellPhoneCat();
    }

    @Then("cell phones page should appear to the user")
    public void cellPhonesAppear() {
        String expectedUrl = "https://demo.nopcommerce.com/cell-phones";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }
}
