package class2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DataProviderDemo {

    public static WebDriver driver;
    @BeforeMethod
    public void setupBrowser() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
//    Test Scenario:
//    navigate to syntax HRMS
//    login into the webiste using the following credentials and check for correct errors
//    a.username ="Admin"  , password="12345"  ---> Error Message ="Invalid credentials"
//    b.username= "ABCD"   , password ="Hum@nhrm123" -->Error Message ="Invalid credentials"
//    c.username= ""   ,   password ="Hum@nhrm123"   -->Error Message ="Username cannot be empty"
//    d.username= "Admin" ,password= ""  -->Error Message= "Password cannot be empty"
    @DataProvider(name = "credentials")
    public Object[][] data(){
        Object[][] loginData={
                {"Admin", "12345", "Invalid credentials"},
                {"ABCD", "Hum@nhrm123", "Invalid credentials"},
                {"Admin", "", "Password cannot be empt"},
                {"", "Hum@nhrm123", "Username cannot be empty"}
        };
        return  loginData;
    }
    @Test(dataProvider = "credentials") //connect this test case with the data provider
    //this will automatically loop through all arrays inside the 2D array
    public void invalidCredentials(String un, String pw, String errorMsg){
        driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(un);
        driver.findElement(By.xpath("//input[@id = 'txtPassword']")).sendKeys(pw);
        driver.findElement(By.xpath("//input[@name='Submit']")).click();

        //get the error message
        WebElement error = driver.findElement(By.xpath("//span[@id='spanMessage']"));
        String actualError = error.getText();

        Assert.assertEquals(actualError, errorMsg);

        }

    @AfterMethod
    public void close(){
        driver.quit();
    }
}
