package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CompareProduct {

    @FindBy(xpath = "//h1")
    WebElement compareListTitle;
    By itemsName = By.xpath("//tr[@class=\"product-name\"]//a");


    WebDriver driver;

    public CompareProduct(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
    }

    public String getCompareListTitle() {
        return compareListTitle.getText();
    }

    public List<WebElement> getItemNames() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return driver.findElements(itemsName);
    }
}
