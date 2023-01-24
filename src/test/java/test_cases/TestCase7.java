package test_cases;

import enums.Category;
import enums.LeftAccordionListItem;
import framework.base.BaseTest;
import framework.logger.Log;
import framework.utils.FileUtil;
import objects.MainPage;
import objects.UploadAndDownloadPage;
import objects.navigation.LeftAccordion;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;

public class TestCase7 extends BaseTest {
    @Test
    public void test() {
        Log.info("Test Case 7: Шаг 1. Перейти на главную страницу");
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpen(), "Main page is not open");

        Log.info("Test Case 7: Шаг 2. Кликнуть на кнопку Elements. На открывшейся странице в левом меню кликнуть пункт Upload and Download");
        mainPage.clickOnCategory(Category.ELEMENTS);
        LeftAccordion leftAccordion = new LeftAccordion();
        leftAccordion.clickItemSubMenu(LeftAccordionListItem.UPLOAD_AND_DOWNLOAD);
        UploadAndDownloadPage uploadAndDownloadPage = new UploadAndDownloadPage();
        Assert.assertTrue(uploadAndDownloadPage.isPageOpen(), "UploadAndDownload page is not open");

        Log.info("Test Case 7: Шаг 3. Нажать на кнопку Download, дождаться загрузки файла");
        uploadAndDownloadPage.clickButtonDownload();
        FileUtil.waitAllFilesDownloaded();
        File downloadedFile = FileUtil.getLastDownloadedFile();
        Assert.assertNotNull(downloadedFile, "Файл не скачан");
        uploadAndDownloadPage.setPathToFile(downloadedFile.getPath());
        Assert.assertTrue(uploadAndDownloadPage.getUploadedFilePath().endsWith(downloadedFile.getName()),
                "Path is incorrect");
    }
}
