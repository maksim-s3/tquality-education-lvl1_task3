package test_cases;

import enums.AlertsForm;
import enums.Category;
import enums.LeftAccordionListItem;
import framework.base.BaseTest;
import framework.logger.Logger;
import framework.utils.AlertUtil;
import framework.utils.RandomUtil;
import objects.AlertsPage;
import objects.navigation.LeftAccordion;
import objects.MainPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCase1 extends BaseTest {
    private String textForPromptAlert = RandomUtil.getRandomText();

    @Parameters({ "textSimpleAlert",  "textConfirmAlert", "textResultConfirmAlert", "textPromptAlert"})
    @Test
    public void test(String textSimpleAlert, String textConfirmAlert, String textResultConfirmAlert, String textPromptAlert) {
        Logger.info("Test Case 1: Шаг 1. Перейти на главную страницу");
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpen(), "Main page is not open");

        Logger.info("Test Case 1: Шаг 2. Кликнуть на кнопку Alerts, Frame & Windows. На открывшейся странице в левом меню кликнуть пункт Alerts");
        mainPage.clickOnCategory(Category.ALERTS_FRAME_AND_WINDOWS);
        LeftAccordion leftAccordion = new LeftAccordion();
        leftAccordion.clickItemSubMenu(LeftAccordionListItem.ALERTS);
        AlertsPage alertsPage = new AlertsPage();
        Assert.assertTrue(alertsPage.isPageOpen(), "Form alerts is not open");

        Logger.info("Test Case 1: Шаг 3. Нажать на кнопку Click Button to see alert");
        alertsPage.clickButtonAlert(AlertsForm.SEE_ALERT);
        Assert.assertEquals(AlertUtil.getText(), textSimpleAlert, "Text alert is not equals");

        Logger.info("Test Case 1: Шаг 4. Нажать на кнопку OK");
        AlertUtil.clickAccept();
        Assert.assertFalse(AlertUtil.checkAlert(), "Alert is not closed");

        Logger.info("Test Case 1: Шаг 5. Нажать на кнопку On button click, confirm box will appear");
        alertsPage.clickButtonAlert(AlertsForm.CONFIRM_BOX_ALERT);
        Assert.assertEquals(AlertUtil.getText(), textConfirmAlert, "Text alert is not equals");

        Logger.info("Test Case 1: Шаг 6. Нажать на кнопку OK");
        AlertUtil.clickAccept();
        Assert.assertFalse(AlertUtil.checkAlert(), "Alert is not closed");
        Assert.assertEquals(alertsPage.getTextConfirmResult(), textResultConfirmAlert,
                "Text confirm result is not equals");

        Logger.info("Test Case 1: Шаг 7. Нажать на кнопку On button click, prompt box will appear");
        alertsPage.clickButtonAlert(AlertsForm.PROMPT_BOX_ALERT);
        Assert.assertEquals(AlertUtil.getText(), textPromptAlert, "Text alert is not equals");

        Logger.info("Test Case 1: Шаг 8. Ввести случайно сгенерированный текст, нажать на кнопку OK");
        AlertUtil.sendTextInAlert(textForPromptAlert);
        AlertUtil.clickAccept();
        Assert.assertFalse(AlertUtil.checkAlert(), "Alert is not closed");
        Assert.assertTrue(alertsPage.getTextPromptResult().contains(textForPromptAlert), "Text prompt result is not equals");
    }
}
