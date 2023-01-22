package framework.base;

import framework.logger.AllureScreenShooter;
import org.testng.annotations.AfterMethod;
import framework.driver_utils.Driver;
import org.testng.annotations.Listeners;

@Listeners(AllureScreenShooter.class)
public abstract class BaseTest {

    @AfterMethod
    public void tearDown() {
        Driver.quit();
    }
}
