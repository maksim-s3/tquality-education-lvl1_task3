package framework.utils;

import framework.driver_utils.Driver;
import framework.logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BrowserUtil {
    private static String originalWindow;
    public static void closeCurrentTab(){
        Log.info("BrowserUtil: закрыть текущее окно и переключиться на предыдущее");
        Driver.getInstance().close();
        switchToPreviousTab();
    }
    public static void switchToNextTab(){
        Log.info("BrowserUtil: переключиться на следующее окно");
        originalWindow = Driver.getInstance().getWindowHandle();
        for (String windowHandle : Driver.getInstance().getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                Driver.getInstance().switchTo().window(windowHandle);
                break;
            }
        }
    }
    public static void switchToPreviousTab(){
        Log.info("BrowserUtil: переключиться на предыдущее окно");
        Driver.getInstance().switchTo().window(originalWindow);
    }

    public static void switchToFrame(By frameLocator){
        Log.info(String.format("BrowserUtil: переключиться на Frame (%s)", frameLocator));
        WebElement frame = Driver.getInstance().findElement(frameLocator);
        Driver.getInstance().switchTo().frame(frame);
    }

    public static void switchToDefaultContent(){
        Log.info("BrowserUtil: переключиться на основное окно");
        Driver.getInstance().switchTo().defaultContent();
    }

    public static String getUrlCurrentTab(){
        Log.info("BrowserUtil: получить URL текущей вкладки");
        return Driver.getInstance().getCurrentUrl();
    }
}
