package framework.base;

import org.testng.annotations.AfterMethod;
import framework.driver_utils.Driver;

public abstract class BaseTest {

    @AfterMethod
    public void tearDown() {
        Driver.quit();
    }
}
