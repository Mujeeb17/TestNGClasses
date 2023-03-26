package class4;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerDemo implements ITestListener {

    @Override // ITestResult is another interface that we need to pass the result of the test case
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test case has passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test case has failed");
    }
}
