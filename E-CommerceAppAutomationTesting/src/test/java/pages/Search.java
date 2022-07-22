package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Search {

    @FindBy(xpath = "//a[contains(text(),'awesome')]")
    WebElement awesomeTag;

    By searchedItems = By.xpath("//h2/a");

    WebDriver driver;

    public Search(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
    }

    public void selectAwesomeTag() {
        awesomeTag.click();
    }

    public List<WebElement> getSearchedItems() {
        return driver.findElements(searchedItems);
    }
}
