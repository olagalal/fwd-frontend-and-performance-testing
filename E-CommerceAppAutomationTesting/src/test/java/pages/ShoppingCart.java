package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ShoppingCart {

    @FindBy(id = "termsofservice")
    WebElement acceptTerms;
    @FindBy(id = "checkout")
    WebElement checkoutBtn;
    //@FindBy(id = "BillingNewAddress_CountryId")
    @FindBy(xpath = "//select[@id='BillingNewAddress_CountryId']")
    WebElement country;
    @FindBy(id = "BillingNewAddress_City")
    WebElement city;
    @FindBy(id = "BillingNewAddress_Address1")
    WebElement address1;
    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement postalCode;
    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement phone;
    @FindBy(xpath = "//div[@id=\"billing-buttons-container\"]//button[@name=\"save\"]")
    WebElement continue2ndStep;
    @FindBy(className = "shipping-method-next-step-button")
    WebElement continueShippingSteps;
    @FindBy(className = "payment-method-next-step-button")
    WebElement continuePaymentSteps;
    @FindBy(className = "payment-info-next-step-button")
    WebElement continuePaymentInformationSteps;
    @FindBy(className = "confirm-order-next-step-button")
    WebElement confirmOrder;
    By itemsNamesInShoppingCart = By.xpath("//a[@class=\"product-name\"]");
    By itemsQtyInShoppingCart = By.xpath("//input[@class=\"qty-input\"]");
    @FindBy(xpath = "//h1")
    WebElement shoppingCartTitle;

    WebDriver driver;

    public ShoppingCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
    }

    public void completeOrder() throws InterruptedException {
        acceptTerms.click();
        checkoutBtn.click();
        Select countrySelect = new Select(country);
        countrySelect.selectByVisibleText("Egypt");
        city.sendKeys("Cairo");
        address1.sendKeys("Cairo,Build1");
        postalCode.sendKeys("13567");
        phone.sendKeys("0123456789");
        continue2ndStep.click();
        Thread.sleep(2000);
        continueShippingSteps.click();
        Thread.sleep(2000);
        continuePaymentSteps.click();
        Thread.sleep(2000);
        continuePaymentInformationSteps.click();
        Thread.sleep(2000);
        confirmOrder.click();
        Thread.sleep(2000);
    }

    public List<WebElement> getItemsNamesInShoppingCart() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return driver.findElements(itemsNamesInShoppingCart);
    }

    public List<WebElement> getItemsQtyInShoppingCart() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return driver.findElements(itemsQtyInShoppingCart);
    }

    public String getShoppingCartTitle() {
        return shoppingCartTitle.getText();
    }

    public String getShoppingCartUrlWhenOrderComplete() {
        return driver.getCurrentUrl();
    }

}
