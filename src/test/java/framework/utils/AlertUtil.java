package framework.utils;

import framework.driver_utils.Driver;
import framework.logger.Log;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertUtil {

    public static String getText(){
        Log.info("AlertUtil: получить текст из алерта");
        return WaitUtil.getWait().until(ExpectedConditions.alertIsPresent()).getText();
    }

    public static void clickAccept(){
        Log.info("AlertUtil: клик по кнопке ОК");
        WaitUtil.getWait().until(ExpectedConditions.alertIsPresent()).accept();
    }

    public static void clickDismiss(){
        Log.info("AlertUtil: клик по кнопке Отмена");
        WaitUtil.getWait().until(ExpectedConditions.alertIsPresent()).dismiss();
    }

    public static boolean checkAlert(){
        Log.info("AlertUtil: проверка активности алерта");
        try {
            Driver.getInstance().switchTo().alert();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void sendTextInAlert(String text){
        Log.info(String.format("AlertUtil: ввести текст \"%s\" в поле алерта", text));
        WaitUtil.getWait().until(ExpectedConditions.alertIsPresent()).sendKeys(text);
    }
}
