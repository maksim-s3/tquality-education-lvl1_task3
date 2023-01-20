package framework.driver_utils;

import framework.logger.Logger;
import framework.utils.ConfigManager;
import framework.utils.FileUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public enum BrowserFactory {
    CHROME{
        public WebDriver create() {
            Logger.info("BrowserFactory: инициализация драйвера для браузера Chrome");
            WebDriver driver = null;
            try {
                driver = new RemoteWebDriver(new URL(URL_WD_HUB), getChromeOptions());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return CHROME.manage(driver);
        }

        public ChromeOptions getChromeOptions() {
            Logger.info("BrowserFactory: конфигурация браузера Chrome");
            ChromeOptions chromeOptions = new ChromeOptions();
            if (ConfigManager.getIsIncognito()) {
                chromeOptions.addArguments("--incognito");
            }
            chromeOptions.addArguments(BrowserFactory.getLangBrowser());
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
            WebDriver driver = null;
            try {
                driver = new RemoteWebDriver(new URL(URL_WD_HUB), getFirefoxOptions());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return FIREFOX.manage(driver);
        }

        public FirefoxOptions getFirefoxOptions() {
            Logger.info("BrowserFactory: конфигурация браузера Firefox");
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            if (ConfigManager.getIsIncognito()) {
                firefoxOptions.addArguments("-private");
            }
            firefoxOptions.addArguments(BrowserFactory.getLangBrowser());
            firefoxOptions.addPreference("browser.download.folderList", 2);
            firefoxOptions.addPreference("browser.download.manager.showWhenStarting", "False");
            firefoxOptions.addPreference("browser.download.dir", FileUtil.DOWNLOAD_DIRECTORY);
            firefoxOptions.addPreference("browser.helperApps.neverAsk.saveToDisk", "");
            return firefoxOptions;
        }
    };

    public static final String URL_WD_HUB = "http://localhost:4444/wd/hub";

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

    private static String getLangBrowser(){
        return String.format("lang=%s", System.getenv("LANGUAGE_BROWSER"));
    }
}
