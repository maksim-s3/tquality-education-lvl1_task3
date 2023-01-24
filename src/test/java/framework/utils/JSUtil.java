package framework.utils;

import framework.driver_utils.Driver;
import framework.logger.Log;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JSUtil {
    private static final String SCROLL_INTO_VIEW = "arguments[0].scrollIntoView(true);";
    public static void scrollIntoView(WebElement element){
        Log.info("JSUtil: скролл");
        ((JavascriptExecutor) Driver.getInstance()).executeScript(SCROLL_INTO_VIEW, element);
    }
}
