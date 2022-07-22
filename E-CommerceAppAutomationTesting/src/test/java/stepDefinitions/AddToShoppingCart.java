package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.Books;
import pages.Login;
import pages.ShoppingCart;

import java.util.List;

import static stepDefinitions.Hooks.driver;

public class AddToShoppingCart {
    Login login;
    Books books;
    ShoppingCart shoppingCart;

    @And("user navigate to books pages")
    public void userNavigateToBooksPages() {
        login = new Login(driver);
        login.clickOnBooksCat();
    }

    @And("user add items to shopping cart")
    public void userAddItemsToShoppingCart() {
        books = new Books(driver);
        books.addItemsToCart();
    }

    @And("user navigate to shopping cart")
    public void userNavigateToShoppingCart() {
        books.openShoppingCartPage();
    }

    @Then("added items should appear at shopping cart")
    public void addedItemsShouldAppearAtShoppingCart() {
        shoppingCart = new ShoppingCart(driver);
        List<WebElement> itemsName = shoppingCart.getItemsNamesInShoppingCart();
        Assert.assertEquals(itemsName.get(0).getText(), "Fahrenheit 451 by Ray Bradbury");
        Assert.assertEquals(itemsName.get(1).getText(), "First Prize Pies");
        Assert.assertEquals(itemsName.get(2).getText(), "Pride and Prejudice");

        List<WebElement> itemsQty = shoppingCart.getItemsQtyInShoppingCart();
        System.out.println(itemsQty.get(0).getAttribute("value"));
        int qty = 0;
        for (WebElement qtyElement : itemsQty) {
            qty += Integer.parseInt(qtyElement.getAttribute("value"));

        }
        System.out.println("qty : " + qty);
        Assert.assertEquals(qty, 3);

        Assert.assertEquals(shoppingCart.getShoppingCartTitle(), "Shopping cart");
    }

}
