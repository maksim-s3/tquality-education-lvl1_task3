package framework.logger;

import org.testng.ITestResult;
import org.testng.reporters.ExitCodeListener;

public class AllureScreenShooter extends ExitCodeListener {
    public void onTestFailure(final ITestResult result) {
        super.onTestFailure(result);
        AllureHelpers.takeScreenshot();
        AllureHelpers.takeLogFile();
    }

    public void onTestSuccess(final ITestResult result){
        super.onTestSuccess(result);
        AllureHelpers.takeScreenshot();
        AllureHelpers.takeLogFile();
    }
}
