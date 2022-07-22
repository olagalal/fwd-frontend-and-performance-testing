package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordRecovery {

    WebDriver driver;

    @FindBy(id = "Email")
    WebElement emailEditText;
    @FindBy(name = "send-email")
    WebElement recoveryPasswordButton;

    public PasswordRecovery(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
    }

    public void enterEmail(String email) {
        emailEditText.sendKeys(email);
    }

    public void clickOnRecoverBtn() {
        recoveryPasswordButton.click();
    }
}
