package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Tags {

    WebDriver driver;

    public Tags(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
    }

    public String getTagsUrl() {
        return driver.getCurrentUrl();
    }

}
