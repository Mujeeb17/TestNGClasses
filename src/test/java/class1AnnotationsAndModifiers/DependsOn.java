package class1AnnotationsAndModifiers;

import org.testng.annotations.Test;

public class DependsOn {
    @Test
    public void login(){
        System.out.println("Logging in");
    }
    @Test(dependsOnMethods = {"login"})
    public void dashBoardVerification(){
        System.out.println("after login, I am verifying dashboard");
    }
}