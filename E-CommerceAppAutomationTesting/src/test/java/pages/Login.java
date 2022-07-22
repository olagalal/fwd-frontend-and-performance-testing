package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

    WebDriver driver;

    @FindBy(id = "Email")
    WebElement emailTextField;
    @FindBy(id = "Password")
    WebElement passwordTextField;
    @FindBy(xpath = "//div[@class=\"buttons\"]/button[@type = \"submit\"]")
    WebElement loginButton;
    @FindBy(linkText = "Forgot password?")
    WebElement forgetPassword;

    @FindBy(xpath = "//body/div[6]/div[2]/ul[1]/li[5]/a[1]")
    WebElement booksCat;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
    }

    public void enterEmail(String email) {
        emailTextField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordTextField.sendKeys(password);
    }

    public void clickLogIn() {
        loginButton.click();
    }

    public void clickForgetPassword() {
        forgetPassword.click();
    }

    public void clickOnBooksCat() {
        booksCat.click();
    }

}
