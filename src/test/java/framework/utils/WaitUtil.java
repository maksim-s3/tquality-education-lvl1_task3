package framework.utils;

import framework.driver_utils.Driver;
import framework.logger.Log;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {

    public static WebDriverWait getWait() {
        Log.info("WaitUtil: получить экземпляр WebDriverWait");
        return new WebDriverWait(Driver.getInstance(), ConfigManager.getExplicitWaitTime(), ConfigManager.getSleepInMillis());
    }
}
