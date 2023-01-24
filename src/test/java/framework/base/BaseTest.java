package framework.base;

import framework.logger.Listener;
import org.testng.annotations.AfterMethod;
import framework.driver_utils.Driver;
import org.testng.annotations.Listeners;

@Listeners(Listener.class)
public abstract class BaseTest {

    @AfterMethod
    public void tearDown() {
        Driver.quit();
    }
}
