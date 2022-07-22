package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.Home;

import static stepDefinitions.Hooks.driver;

public class Registration {

    Home home;
    pages.Registration registration;

    @And("user clicked on register link")
    public void clickOnRegisterButton() {
        home = new Home(driver);
        home.registerClick();
    }

    @When("user selected gender")
    public void selectGender() {
        registration = new pages.Registration(driver);
        registration.setGender("female");
    }

    @And("user entered first name")
    public void enterFirstName() {
        registration.setFirstName("Ola");
    }

    @And("user entered last name")
    public void enterLastName() {
        registration.setLastName("Galal");
    }

    @And("user selected birth of date")
    public void enterBirthOfDate() {
        registration.setDayOfBirth(29);
        registration.setMonthOfBirth("October");
        registration.setYearOfBirth(1997);
    }

    @And("user entered email for registration")
    public void enterEmail() {
        registration.setEmail("Ola@email.com");
    }

    @And("user entered company name")
    public void enterCompanyName() {
        registration.setCompanyName("Me dot me");
    }

    @And("user entered password for registration")
    public void enterPassword() {
        registration.setPassword("secretPassword");
    }

    @And("user confirmed password for registration")
    public void confirmPassword() {
        registration.confirmPassword("secretPassword");
    }

    @And("user clicked on register button")
    public void userClickedOnRegisterButton() {
        registration.clickRegisterButton();
    }


    @Then("user should have a success message for registration")
    public void userShouldHaveASuccessMessageForRegistration() {
        WebElement registerTitle = driver.findElement(By.xpath("//h1"));
        Assert.assertEquals(registerTitle.getText(), "Register");

        String registerMessage = driver.findElement(By.xpath("//div[@class=\"result\"]")).getText();
        Assert.assertEquals(registerMessage, "Your registration completed");
    }
}
