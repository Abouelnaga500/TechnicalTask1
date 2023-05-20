package tesCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
 public class T01 {
    WebDriver driver;


@Test
public void test_01 () {
    WebElement singInlocation = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span"));
    new Actions(driver).moveToElement(singInlocation).perform();
    driver.findElement(By.xpath("//*[@id=\"nav-flyout-ya-signin\"]/a/span")).click();
    driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("abouelnagamohamed500@gmail.com");
    driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
    Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li")).getText().contains("There was a problem"));


}
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.amazon.eg/?language=en_AE");

    }

    @AfterMethod
    public void testCase()throws Exception{
    Thread.sleep(5000);
        driver.quit();


    }
}