package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.Login;

import static stepDefinitions.Hooks.driver;

public class PasswordRecovery {
    Login login;
    pages.PasswordRecovery passwordRecovery;

    @And("user clicked on forgot password")
    public void userClickedOnForgotPassword() {
        login = new Login(driver);
        login.clickForgetPassword();
    }

    @And("user entered email for reset password")
    public void userEnteredEmailForResetPassword() {
        passwordRecovery = new pages.PasswordRecovery(driver);
        passwordRecovery.enterEmail("Ola@email.com");
    }

    @And("user clicked on recover button")
    public void userClickedOnRecoverButton() {
        passwordRecovery.clickOnRecoverBtn();
    }

    @Then("user should have a success message for recover")
    public void userShouldHaveASuccessMessageForRecover() {
        String resetMessage = driver.findElement(By.xpath("//div[@class=\"bar-notification success\"]")).getText();
        Assert.assertEquals(resetMessage, "Email with instructions has been sent to you.");
    }
}
