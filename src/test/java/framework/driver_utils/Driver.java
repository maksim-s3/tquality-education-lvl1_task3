package framework.driver_utils;

import framework.logger.Log;
import framework.utils.FileUtil;
import org.openqa.selenium.WebDriver;
import framework.utils.ConfigManager;

public class Driver {
    private static Driver instance = null;
    private static WebDriver driver = null;

    private Driver() {
        createDriver();
    }

    private static void createDriver() {
        Log.info("Driver: создание драйвера браузера заданного в pipeline");
        switch (System.getenv("BROWSER").toUpperCase()) {
            case "CHROME":
                driver = BrowserFactory.CHROME.create();
                break;

            case "FIREFOX":
                driver = BrowserFactory.FIREFOX.create();
                break;
            default:
                new RuntimeException("Неправильное имя браузера: " + System.getenv("BROWSER").toUpperCase());
                break;
        }
        driver.get(ConfigManager.getURL());
    }

    public static WebDriver getInstance() {
        Log.info("Driver: получить WebDriver");
        if (instance == null) {
            instance = new Driver();
        }
        return driver;
    }

    public static void quit() {
        Log.info("Driver: закрытие браузера, удаление драйвера, удаление временного каталога");
        driver.quit();
        driver = null;
        instance = null;
        FileUtil.deleteDownloadDirectory();
    }
}
