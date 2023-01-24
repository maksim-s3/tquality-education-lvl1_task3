package framework.logger;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart(): " + result.getName());
    }

    public void onTestFailure(ITestResult result) {
        AllureHelpers.takeScreenshot();
        AllureHelpers.takeLogFile();
    }

    public void onTestSuccess(ITestResult result){
        AllureHelpers.takeScreenshot();
        AllureHelpers.takeLogFile();
    }
}
