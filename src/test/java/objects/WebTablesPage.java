package objects;

import framework.base.BaseForm;
import framework.base.elements.Button;
import framework.logger.Log;
import models.User;
import objects.custom_elements.WebTableUsers;
import org.openqa.selenium.By;

public class WebTablesPage extends BaseForm {
    private static By locatorWebTablesPage = By.xpath("//*[contains(@class, 'main-header') and contains(text(), 'Web Tables')]");
    private By tableLocator = By.xpath("//*[@class = 'rt-table']");
    private WebTableUsers webTableUsers = new WebTableUsers(tableLocator, "Таблица с пользователями на странице WebTable");
    private Button buttonAdd = new Button(By.xpath("//*[@id='addNewRecordButton']"), "Кнопка Add");

    public WebTablesPage() {
        super(locatorWebTablesPage);
    }

    public void clickButtonAddNewRecord(){
        Log.info(getClass().getSimpleName()+": Клик по кнопке Add на форме");
        buttonAdd.scroll();
        buttonAdd.click();
    }

    public boolean isUserInTable(User user) {
        Log.info(getClass().getSimpleName()+": Поиск User в таблице");
        return webTableUsers.isUserInTable(user);
    }

    public int getNumberOfRecords(){
        Log.info(getClass().getSimpleName()+": Получить количество непустых записей в таблице");
        return webTableUsers.getNumberOfUsers();
    }
    public void deleteUserFromTable(User user){
        Log.info(getClass().getSimpleName()+": Удалить User из таблицы");
        webTableUsers.deleteUser(user);
    }
}
