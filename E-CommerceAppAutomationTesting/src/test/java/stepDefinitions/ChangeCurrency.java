package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.Home;

import java.util.List;

import static stepDefinitions.Hooks.driver;

public class ChangeCurrency {
    Home home;

    @And("user change currency from usd to euro")
    public void userChangeCurrencyFromUsdToEuro() {
        home = new Home(driver);
        home.changeCurrencyFromUsdToEuro();
    }

    @Then("all products shown are in euro")
    public void allProductsShownAreInEuro() {
        List<WebElement> itemsPrice = driver.findElements(By.xpath("//div[@class=\"prices\"]/span"));
        String firstItemPrice = itemsPrice.get(0).getText();
        Assert.assertTrue(firstItemPrice.contains("€"));
    }
}
