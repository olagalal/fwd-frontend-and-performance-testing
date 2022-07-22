package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Books {

    @FindAll(@FindBy(xpath = "//div[@class=\"product-item\"]"))
    WebElement itemCard;

    @FindBy(xpath = "//a[contains(text(),'Compare products list')]")
    WebElement compareProductsLink;
    @FindBy(xpath = "//a[contains(text(),'Wishlist')]")
    WebElement wishListLink;
    @FindBy(xpath = "//a[contains(text(),'Shopping cart')]")
    WebElement shoppingCartLink;

    WebDriver driver;

    public Books(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
    }

    public void addItemsToCart() {
        By addToCardBtn = By.xpath("//button[@class=\"button-2 product-box-add-to-cart-button\"]");
        List<WebElement> addToCardList = itemCard.findElements(addToCardBtn);
        for (WebElement addToCard : addToCardList) {
            addToCard.click();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void addItemsToFav() {
        By addToFavBtn = By.xpath("//button[@class=\"button-2 add-to-wishlist-button\"]");
        List<WebElement> addToFavList = itemCard.findElements(addToFavBtn);
        for (WebElement addToFav : addToFavList) {
            addToFav.click();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void addItemsToCompare() {
        By addToCompareBtn = By.xpath("//button[@class=\"button-2 add-to-compare-list-button\"]");
        List<WebElement> addToCompareList = itemCard.findElements(addToCompareBtn);
        for (WebElement addToCompare : addToCompareList) {
            addToCompare.click();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void openShoppingCartPage() {
        shoppingCartLink.click();
    }

    public void openWishListPage() {
        wishListLink.click();
    }

    public void openComparePage() {
        compareProductsLink.click();
    }

}
