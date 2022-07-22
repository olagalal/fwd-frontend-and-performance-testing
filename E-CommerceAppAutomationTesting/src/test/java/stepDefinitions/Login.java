package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.Home;

import static stepDefinitions.Hooks.driver;

public class Login {
    Home home;
    pages.Login login;

    @And("user clicked on login link")
    public void userClickedOnLoginLink() {
        home = new Home(driver);
        home.loginClick();
    }

    @And("user entered email for login")
    public void userEnteredEmailForLogin() {
        login = new pages.Login(driver);
        login.enterEmail("Ola@email.com");
    }

    @And("user entered password for login")
    public void userEnteredPasswordForLogin() {
        login.enterPassword("secretPassword");
    }

    @And("user clicked on login button")
    public void userClickedOnLoginButton() {
        login.clickLogIn();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("user should have a success message for login")
    public void userShouldHaveASuccessMessageForLogin() {

        Assert.assertTrue(driver.findElement(By.xpath("//a[@class=\"ico-account\"]")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class=\"ico-account\"]")).getText(), "My account");
    }
}
