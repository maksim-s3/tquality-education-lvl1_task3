package framework.driver_utils;

import framework.logger.Logger;
import framework.utils.ConfigManager;
import framework.utils.FileUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public enum BrowserFactory {
    CHROME{
        public WebDriver create() {
            Logger.info("BrowserFactory: инициализация драйвера для браузера Chrome");
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver(getChromeOptions());
            return CHROME.manage(driver);
        }

        public ChromeOptions getChromeOptions() {
            Logger.info("BrowserFactory: конфигурация браузера Chrome");
            ChromeOptions chromeOptions = new ChromeOptions();
            if (ConfigManager.getIsIncognito()) {
                chromeOptions.addArguments("--incognito");
            }
            chromeOptions.addArguments(String.format("lang=%s", ConfigManager.getBrowserLang()));
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("download.default_directory", FileUtil.DOWNLOAD_DIRECTORY);
            prefs.put("download.prompt_for_download", false);
            chromeOptions.setExperimentalOption("prefs", prefs);
            return chromeOptions;
        }
    },
    FIREFOX{
        public WebDriver create() {
            Logger.info("BrowserFactory: инициализация драйвера для браузера Firefox");
            WebDriverManager.firefoxdriver().setup();
            WebDriver driver = new FirefoxDriver(getFirefoxOptions());
            return FIREFOX.manage(driver);
        }

        public FirefoxOptions getFirefoxOptions() {
            Logger.info("BrowserFactory: конфигурация браузера Firefox");
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            if (ConfigManager.getIsIncognito()) {
                firefoxOptions.addArguments("-private");
            }
            firefoxOptions.addArguments(String.format("lang=%s", ConfigManager.getBrowserLang()));
            firefoxOptions.addPreference("browser.download.folderList", 2);
            firefoxOptions.addPreference("browser.download.manager.showWhenStarting", "False");
            firefoxOptions.addPreference("browser.download.dir", FileUtil.DOWNLOAD_DIRECTORY);
            firefoxOptions.addPreference("browser.helperApps.neverAsk.saveToDisk", "");
            return firefoxOptions;
        }
    };
    public WebDriver create(){
        return null;
    }

    private WebDriver manage(WebDriver driver){
        if (ConfigManager.getFullScreen()) {
            driver.manage().window().maximize();
        }
        driver.manage().timeouts().pageLoadTimeout(ConfigManager.getPageLoadTimeout(), TimeUnit.SECONDS);
        return driver;
    }
}
