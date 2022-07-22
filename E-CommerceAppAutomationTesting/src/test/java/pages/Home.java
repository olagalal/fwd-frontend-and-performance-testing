package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Home {

    @FindBy(linkText = "Register")
    WebElement registerBtn;
    @FindBy(linkText = "Log in")
    WebElement loginBtn;
    @FindBy(id = "small-searchterms")
    WebElement searchBox;
    @FindBy(xpath = "//button[contains(text(),'Search')]")
    WebElement searchButton;
    @FindBy(id = "customerCurrency")
    WebElement selectCurrency;
    @FindBy(xpath = "//body/div[6]/div[2]/ul[1]/li[2]/a[1]")
    WebElement electronicCat;
    @FindBy(xpath = "//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]")
    WebElement cellPhoneCat;

    @FindBy(xpath = "//body/div[6]/div[2]/ul[1]/li[3]/a[1]")
    WebElement apparelCat;
    @FindBy(xpath = "//body/div[6]/div[2]/ul[1]/li[3]/ul[1]/li[1]/a[1]")
    WebElement shoesCat;

    @FindBy(xpath = "//a[contains(text(),'Search')]")
    WebElement searchPage;
    WebDriver driver;

    public Home(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
    }

    public void openHomePage() {
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    public void loginClick() {
        loginBtn.click();
    }

    public void registerClick() {
        registerBtn.click();
    }

    public void search(String item) {
        searchBox.sendKeys(item);
    }

    public void clickOnSearchBtn() {
        searchButton.click();
    }

    public void changeCurrencyFromUsdToEuro() {
        Select currency = new Select(selectCurrency);
        currency.selectByVisibleText("Euro");
    }

    public void hoverOnElectronicsCat() {
        Actions actions = new Actions(driver);
        actions.moveToElement(electronicCat).perform();
    }

    public void clickOnCellPhoneCat() {
        cellPhoneCat.click();
    }

    public void hoverOnapparelCat() {
        Actions actions = new Actions(driver);
        actions.moveToElement(apparelCat).perform();
    }

    public void clickOnShoesCat() {
        shoesCat.click();
    }


    public void openSearchPage() {
        searchPage.click();
    }

}
