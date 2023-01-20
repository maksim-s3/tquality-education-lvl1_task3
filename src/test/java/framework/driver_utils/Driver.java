package framework.driver_utils;

import framework.logger.Logger;
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
        Logger.info("Driver: создание драйвера браузера заданного в конфигурации");
        switch (ConfigManager.getBrowserName().toUpperCase()) {
            case "CHROME":
                driver = BrowserFactory.CHROME.create();
                break;

            case "FIREFOX":
                driver = BrowserFactory.FIREFOX.create();
                break;
            default:
                new RuntimeException("Неправильное имя браузера: " + ConfigManager.getBrowserName());
                break;
        }
        driver.get(ConfigManager.getURL());
    }

    public static WebDriver getInstance() {
        Logger.info("Driver: получить WebDriver");
        if (instance == null) {
            instance = new Driver();
        }
        return driver;
    }

    public static void quit() {
        Logger.info("Driver: закрытие браузера, удаление драйвера, удаление временного каталога");
        driver.quit();
        driver = null;
        instance = null;
        FileUtil.deleteDownloadDirectory();
    }
}
