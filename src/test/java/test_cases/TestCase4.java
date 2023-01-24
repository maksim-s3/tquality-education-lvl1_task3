package test_cases;

import enums.Category;
import enums.LeftAccordionListItem;
import enums.LinksForm;
import framework.base.BaseTest;
import framework.logger.Log;
import framework.utils.BrowserUtil;
import objects.*;
import objects.navigation.LeftAccordion;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCase4 extends BaseTest {
    @Parameters({"sampleUrl"})
    @Test
    public void test(String sampleUrl) {
        Log.info("Test Case 4: Шаг 1. Перейти на главную страницу");
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpen(), "Main page is not open");

        Log.info("Test Case 4: Шаг 2. Кликнуть на кнопку Alerts, Frame & Windows.\n" +
                "На открывшейся странице в левом меню кликнуть пункт Browser Windows");
        mainPage.clickOnCategory(Category.ALERTS_FRAME_AND_WINDOWS);
        LeftAccordion leftAccordion = new LeftAccordion();
        leftAccordion.clickItemSubMenu(LeftAccordionListItem.BROWSER_WINDOWS);
        BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage();
        Assert.assertTrue(browserWindowsPage.isPageOpen(), "Page Browser Windows is not open");

        Log.info("Test Case 4: Шаг 3. Кликнуть на кнопку New Tab");
        browserWindowsPage.clickButtonNewTab();
        SamplePage samplePage = new SamplePage();
        BrowserUtil.switchToNextTab();
        samplePage.waitForPageToLoad();
        Assert.assertTrue(BrowserUtil.getUrlCurrentTab().endsWith(sampleUrl), "Current URL does not contain " + sampleUrl);
        Assert.assertTrue(samplePage.isPageOpen(), "Sample Page is not open");

        Log.info("Test Case 4: Шаг 4.Закрыть текущую вкладку");
        BrowserUtil.closeCurrentTab();
        Assert.assertTrue(browserWindowsPage.isPageOpen(), "Page Browser Windows is not open");

        Log.info("Test Case 4: Шаг 5. В левом меню выбрать Elements → Links");
        leftAccordion.clickItemMenu(Category.ELEMENTS);
        leftAccordion.clickItemSubMenu(LeftAccordionListItem.LINKS);
        LinksPage linksPage = new LinksPage();
        Assert.assertTrue(linksPage.isPageOpen(), "Page Links is not open");

        Log.info("Test Case 4: Шаг 6. Перейти по ссылке Home");
        linksPage.clickLink(LinksForm.HOME);
        BrowserUtil.switchToNextTab();
        mainPage.waitForPageToLoad();
        Assert.assertTrue(mainPage.isPageOpen(), "Main Page is not open");

        Log.info("Test Case 4: Шаг 7. Переключиться на прошлую вкладку");
        BrowserUtil.switchToPreviousTab();
        linksPage.waitForPageToLoad();
        Assert.assertTrue(linksPage.isPageOpen(), "Page Links is not open");
    }
}
