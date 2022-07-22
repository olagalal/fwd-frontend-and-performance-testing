package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.Books;
import pages.WishList;

import java.util.List;
import static stepDefinitions.Hooks.driver;

public class AddToWishList {
    Books books;
    WishList wishListPage;

    @And("user add items to wish list")
    public void userAddItemsToWishList() {
        books = new Books(driver);
        books.addItemsToFav();
    }

    @And("user navigate to wish list")
    public void userNavigateToWishList() {
        books.openWishListPage();
    }

    @Then("added items should appear at wish list")
    public void addedItemsShouldAppearAtWishList() {
        wishListPage = new WishList(driver);
        List<WebElement> itemsName = (List<WebElement>) wishListPage.getWishListItemNames();
        Assert.assertEquals(itemsName.get(0).getText(),"Fahrenheit 451 by Ray Bradbury");
        Assert.assertEquals(itemsName.get(1).getText(),"First Prize Pies");
        Assert.assertEquals(itemsName.get(2).getText(),"Pride and Prejudice");

        List<WebElement> itemsQty = wishListPage.getWishListItemQty();
        int qty = 0;
        for (WebElement qtyElement : itemsQty){
            qty += Integer.parseInt(qtyElement.getAttribute("value"));
        }
        System.out.println("qty : "+qty);
        Assert.assertEquals(qty,3);

        Assert.assertEquals(wishListPage.getWishListTitle(), "Wishlist");
    }
}
