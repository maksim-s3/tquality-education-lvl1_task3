package framework.logger;

import framework.driver_utils.Driver;
import framework.utils.FileUtil;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import java.nio.charset.StandardCharsets;

public class AllureHelpers {
    private static final String LOG_FILE = "target/log/log_tests.log";

    @SuppressWarnings("UnusedReturnValue")
    @Attachment(value = "AllureTextReport", type = "text/plain", fileExtension = ".txt")
    public static String attachText(final String text) {
        return text;
    }

    @SuppressWarnings("UnusedReturnValue")
    @Attachment(value = "AllureCSVReport", type = "text/csv", fileExtension = ".csv")
    public static String attachCSV(final String csv) {
        return csv;
    }

    @SuppressWarnings("UnusedReturnValue")
    @Attachment(value = "Html source", type = "text/html", fileExtension = ".html")
    public static byte[] getPageSource() {
        return getPageSourceBytes();
    }

    @SuppressWarnings("UnusedReturnValue")
    @Attachment(value = "Screenshot", type = "image/png", fileExtension = ".png")
    public static byte[] takeScreenshot() {
        return getScreenshotBytes();
    }

    @SuppressWarnings("UnusedReturnValue")
    @Attachment(value = "{name}", type = "image/png", fileExtension = ".png")
    public static byte[] takeScreenshot(final String name) {
        return getScreenshotBytes();
    }

    @SuppressWarnings("UnusedReturnValue")
    @Attachment(value = "Element screenshot", type = "image/png", fileExtension = ".png")
    public static byte[] takeScreenshot(final WebElement elem) {
        return getScreenshotBytes(elem);
    }

    @SuppressWarnings("UnusedReturnValue")
    @Attachment(value = "Log", type = "text/html", fileExtension = ".log")
    public static String takeLogFile() {
        return FileUtil.getFile(LOG_FILE).toString();
    }

    public static byte[] getPageSourceBytes() {
        return Driver.getInstance().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    public static byte[] getScreenshotBytes() {
        return ((TakesScreenshot) Driver.getInstance()).getScreenshotAs(OutputType.BYTES);
    }
    public static byte[] getScreenshotBytes(final WebElement elem) {
        return elem.getScreenshotAs(OutputType.BYTES);
    }
}
