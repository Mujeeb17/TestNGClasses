package class1AnnotationsAndModifiers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNGExample {

    public static WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void setupBrowser(){
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
    }
    @Test(groups = "regression")
    public void login(){
        driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Hum@nhrm123");
        driver.findElement(By.xpath("//input[@name='Submit']")).click();
    }

    //verify that password textbox is displayed on login page
    @Test
    public void passwordTextBoxVerification(){
        System.out.println(driver.findElement(By.xpath("//input[@id = 'txtPassword']")).isDisplayed());
    }
}
