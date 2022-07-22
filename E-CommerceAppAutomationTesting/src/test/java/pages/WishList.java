package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WishList {

    @FindBy(xpath = "//h1")
    WebElement wishListTitle;

    By itemsName = By.xpath("//a[@class=\"product-name\"]");

    By itemsQty = By.xpath("//input[@class=\"qty-input\"]");


    WebDriver driver;

    public WishList(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
    }

    public String getWishListTitle() {
        return wishListTitle.getText();
    }

    public List<WebElement> getWishListItemNames() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return driver.findElements(itemsName);
    }

    public List<WebElement> getWishListItemQty() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return driver.findElements(itemsQty);
    }
}
