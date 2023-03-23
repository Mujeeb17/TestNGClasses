package class1AnnotationsAndModifiers;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotations {

    @Test(groups = "regression")
    public void aFirstTestCase(){
        System.out.println("I am the first test case");
    }

    @Test
    public void secondTestCase(){
        System.out.println("second test case");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I am before method");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("I am after method");
    }
}
