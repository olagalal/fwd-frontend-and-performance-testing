package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Registration {

    @FindBy(id = "gender-male")
    WebElement genderMaleRadioButton;
    @FindBy(id = "gender-female")
    WebElement genderFemaleRadioButton;
    @FindBy(id = "FirstName")
    WebElement firstNameEditText;
    @FindBy(id = "LastName")
    WebElement lastNameEditText;

    @FindBy(name = "DateOfBirthDay")
    WebElement dateOfBirthDay;
    @FindBy(name = "DateOfBirthMonth")
    WebElement dateOfBirthMonth;
    @FindBy(name = "DateOfBirthYear")
    WebElement dateOfBirthYear;

    @FindBy(id = "Email")
    WebElement emailEditText;
    @FindBy(id = "Company")
    WebElement companyNameEditText;
    @FindBy(id = "Newsletter")
    WebElement newsletterCheckBox;
    @FindBy(id = "Password")
    WebElement passwordEditText;
    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordEditText;
    @FindBy(id = "register-button")
    WebElement registerButton;


    WebDriver driver;

    public Registration(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setGender(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            genderMaleRadioButton.click();
        } else if (gender.equalsIgnoreCase("female")) {
            genderFemaleRadioButton.click();
        }
    }

    public void setFirstName(String firstName) {
        firstNameEditText.sendKeys(firstName);
    }

    public void setLastName(String lasttName) {
        lastNameEditText.sendKeys(lasttName);
    }


    public void setDayOfBirth(int day) {
        Select daySelect = new Select(dateOfBirthDay);
        daySelect.selectByValue(String.valueOf(5));
    }

    public void setMonthOfBirth(String month) {
        Select monthSelect = new Select(dateOfBirthMonth);
        monthSelect.selectByVisibleText(month);
    }

    public void setYearOfBirth(int year) {
        Select yearSelect = new Select(dateOfBirthYear);
        yearSelect.selectByValue(String.valueOf(year));
    }

    public void setEmail(String email) {
        emailEditText.sendKeys(email);
    }

    public void setCompanyName(String company) {
        companyNameEditText.sendKeys(company);
    }

    public void selectNewsLetter() {
        if (!newsletterCheckBox.isSelected()) {
            newsletterCheckBox.click();
        }
    }

    public void setPassword(String password) {
        passwordEditText.sendKeys(password);
    }

    public void confirmPassword(String password) {
        confirmPasswordEditText.sendKeys(password);
    }

    public void clickRegisterButton() {
        registerButton.click();
    }
}
