package class4;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AnnotationsDemo2 {
    @BeforeClass
    public void bc(){
        System.out.println("I am before class");
    }

    @Test
    public void testC(){
        System.out.println("I am test C");
    }
}
