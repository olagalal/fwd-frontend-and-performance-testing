package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Shoes {


    @FindBy(id = "attribute-option-15")
    WebElement redColor;

    WebDriver driver;

    public Shoes(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
    }

    public void selectRedColor() {
        redColor.click();
    }

    public boolean isRedColorSelected() {
        return redColor.isSelected();
    }
}
