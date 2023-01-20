package framework.utils;

import framework.driver_utils.Driver;
import framework.logger.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class ActionUtil {
    private static Actions action = new Actions(Driver.getInstance());

    public static void moveRight(){
        Logger.info("ActionUtil: нажать клавишу вправо");
        action.sendKeys(Keys.RIGHT).perform();
    }

    public static void moveLeft(){
        Logger.info("ActionUtil: нажать клавишу влево");
        action.sendKeys(Keys.LEFT).perform();
    }

}
