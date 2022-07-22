package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.ShoppingCart;

import static stepDefinitions.Hooks.driver;

public class CreateOrder {
    ShoppingCart shoppingCart;

    @And("user complete order")
    public void userCompleteOrder() throws InterruptedException {
        shoppingCart = new ShoppingCart(driver);
        shoppingCart.completeOrder();
    }

    @Then("order placed successfully")
    public void orderPlacedSuccessfully() {
        Assert.assertEquals(shoppingCart.getShoppingCartTitle(), "Thank you");
        String url = "https://demo.nopcommerce.com/checkout/completed";
        Assert.assertEquals(shoppingCart.getShoppingCartUrlWhenOrderComplete(), url);
    }
}
