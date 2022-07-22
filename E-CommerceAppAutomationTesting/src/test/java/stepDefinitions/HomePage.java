package stepDefinitions;

import io.cucumber.java.en.Given;
import pages.Home;
import pages.Registration;

import static stepDefinitions.Hooks.driver;

public class HomePage {
    Home home;
    Registration registration;

    @Given("user navigate to home page")
    public void openHomePage() {
        home = new Home(driver);
        home.openHomePage();
    }
}
