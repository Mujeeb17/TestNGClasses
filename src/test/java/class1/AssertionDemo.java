package class1;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AssertionDemo {
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
    public void closeBrowser(){
        driver.quit();
    }

    //enter username Admin, and enter false password. verify 'invalid credentials is displayed'
    @Test
    public void invalidCredentialsVerification(){
        driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("password");
        driver.findElement(By.xpath("//input[@name='Submit']")).click();

        String text = driver.findElement(By.xpath("//span[text()='Invalid credentials']")).getText();
        String expectedError = "Invalid credentials";

        //assert the value
        Assert.assertEquals(text, expectedError);

        //now check password textbox using assertions
        boolean pwDisplayed = driver.findElement(By.xpath("//input[@id='txtPassword']")).isDisplayed();
        Assert.assertTrue(pwDisplayed);
    }
}
