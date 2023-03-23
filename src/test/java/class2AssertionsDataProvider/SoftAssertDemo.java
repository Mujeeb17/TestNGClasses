package class2AssertionsDataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SoftAssertDemo {

    public static WebDriver driver;
    @BeforeMethod
    public void setupBrowser(){
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void close(){
        driver.quit();
    }

    @Test
    public void test(){
        //find the login button and click
        WebElement login = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        login.click();

        //locate and get error message
        String text = driver.findElement(By.xpath("//span[text()='Username cannot be empty']")).getText();

        //make sure the text is the same as: Username cannot be empty
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(text, "Username cannot be empty");

        //make sure login button is displayed
        sa.assertTrue(login.isDisplayed());

        //using assertAll
        sa.assertAll();
    }
}
