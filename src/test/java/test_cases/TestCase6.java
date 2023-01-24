package test_cases;

import enums.Category;
import enums.LeftAccordionListItem;
import framework.base.BaseTest;
import framework.logger.Log;
import framework.utils.DateUtil;
import objects.DatePickerPage;
import objects.MainPage;
import objects.navigation.LeftAccordion;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Date;

public class TestCase6 extends BaseTest {
    private static final String TEMPLATE_SELECT_DATE = "MM/dd/yyyy";
    private static final String TEMPLATE_DATE_AND_TIME = "MMMM d, yyyy h:m a";
    private static final String TEMPLATE_DATE_SELECT_DATE_PICKER = "MMMM d yyyy";

    @Test
    public void test() {
        Log.info("Test Case 6: Шаг 1. Перейти на главную страницу");
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpen(), "Main page is not open");

        Log.info("Test Case 6: Шаг 2. Кликнуть на кнопку Widgets. На открывшейся странице в левом меню кликнуть пункт Date Picker");
        mainPage.clickOnCategory(Category.WIDGETS);
        LeftAccordion leftAccordion = new LeftAccordion();
        leftAccordion.clickItemSubMenu(LeftAccordionListItem.DATE_PICKER);
        DatePickerPage datePickerPage = new DatePickerPage();
        Assert.assertTrue(datePickerPage.isPageOpen(), "Date Picker page is not open");

        Date selectDate = DateUtil.getDate(TEMPLATE_SELECT_DATE);
        Assert.assertEquals(selectDate, datePickerPage.getSelectDateFromTemplate(TEMPLATE_SELECT_DATE),
                "Select Date does not match the current date");
        Date dateAndTime = DateUtil.getDate(TEMPLATE_DATE_AND_TIME);
        Assert.assertEquals(dateAndTime, datePickerPage.getDateAndTimeFromTemplate(TEMPLATE_DATE_AND_TIME),
                "Date And Time does not match the current date");

        Log.info("Test Case 6: Шаг 3. Используя окно выбора даты, в поле Date Picker задать дату ближайшего 29 февраля");
    }
}
