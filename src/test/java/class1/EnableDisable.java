package class1;

import org.testng.annotations.Test;

public class EnableDisable {

    @Test
    public void aTest() {
        System.out.println("I am first test case");
    }

    @Test(enabled = false)
    public void bTest() {
        System.out.println("I am second test case");
    }

    @Test
    public void cTest() {
        System.out.println("I am third test case");
    }

}
