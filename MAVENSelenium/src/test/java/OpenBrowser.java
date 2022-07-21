import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {

    public static void main(String[] args) throws InterruptedException {

        String chromePath = System.getProperty("user.dir")+"/src/main/resources/chromedriver";
        System.setProperty("webdriver.chrome.driver",chromePath);
        WebDriver driver = new ChromeDriver();

//        driver.navigate().to("https://www.google.com");
        https://trello.com/b/qAktTwQL/client-1https://trello.com/b/qAktTwQL/client-1

        int sec = 3;
        Thread.sleep(sec*1000);

//        driver.findElement(By.name("q")).click();
//        driver.findElement(By.name("q")).sendKeys("Selenium");

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");

//        driver.findElement(By.linkText("Elemental Selenium")).click();
//        driver.findElement(By.partialLinkText("Elementa")).click();
//        driver.findElement(By.tagName("button")).click();
//        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();

        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        Thread.sleep(sec*1000);

//        driver.close(); //close tab
        driver.quit();
    }

}