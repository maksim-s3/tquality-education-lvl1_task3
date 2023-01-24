package test_cases;

import enums.Category;
import enums.LeftAccordionListItem;
import framework.base.BaseTest;
import framework.logger.Log;
import framework.utils.DPClass;
import models.User;
import objects.*;
import objects.forms.RegistrationForm;
import objects.navigation.LeftAccordion;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase3 extends BaseTest {
    @Test(dataProvider = "TestCase3", dataProviderClass = DPClass.class)
    public void test(User user) {
        Log.info("Test Case 3: Шаг 1. Перейти на главную страницу");
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpen(), "Main page is not open");

        Log.info("Test Case 3: Шаг 2. Кликнуть на кнопку Elements. На открывшейся странице в левом меню кликнуть пункт Web Tables");
        mainPage.clickOnCategory(Category.ELEMENTS);
        ElementsPage elementsPage = new ElementsPage();
        Assert.assertTrue(elementsPage.isPageOpen(), "Page Elements id not open");
        LeftAccordion leftAccordion = new LeftAccordion();
        leftAccordion.clickItemSubMenu(LeftAccordionListItem.WEB_TABLES);
        WebTablesPage webTablesPage = new WebTablesPage();
        Assert.assertTrue(webTablesPage.isPageOpen(), "Page Web Tables is not open");

        Log.info("Test Case 3: Шаг 3. Кликнуть на кнопку Add");
        webTablesPage.clickButtonAddNewRecord();
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.waitForPageToLoad();
        Assert.assertTrue(registrationForm.isPageOpen(), "Form Registration is not open");

        Log.info("Test Case 3: Шаг 4. Ввести данные пользователя User из таблицы и затем нажать на кнопку Submit");
        registrationForm.fillRegistrationForm(user);
        registrationForm.clickButtonSubmit();
        Assert.assertFalse(registrationForm.isPageOpen(), "Form Registration is not closed");
        Assert.assertTrue(webTablesPage.isUserInTable(user), "User is not find");

        Log.info("Test Case 3: Шаг 5. Нажать на кнопку Delete в строке пользователя User");
        int numberOfRecords = webTablesPage.getNumberOfRecords();
        webTablesPage.deleteUserFromTable(user);
        Assert.assertNotEquals(webTablesPage.getNumberOfRecords(), numberOfRecords, "User is not deleted. Number records is match");
        Assert.assertFalse(webTablesPage.isUserInTable(user), "User is not deleted");
    }
}
