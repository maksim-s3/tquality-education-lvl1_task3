package objects.custom_elements;

import enums.WebTables;
import framework.base.elements.Button;
import framework.base.elements.Table;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class WebTableUsers extends Table {
    private static By tr = By.xpath("//*[contains(@class, 'rt-tr -') and not(contains(@class, 'padRow'))]");
    private static By td = By.xpath(".//*[contains(@class, 'td') and contains(text(), *)]");
    private static By th = By.xpath("//*[contains(@class, 'rt-th ')]");
    private String exampleButtonDeleteRecord = "//*[@id='delete-record-%d']";

    public WebTableUsers(By locator, String descriptionElement) {
        super(locator, descriptionElement, tr, td, th);
    }

    public boolean isUserInTable(User user){
        List<User> listUsers = getListUsers();
        return listUsers.contains(user);
    }

    private List<User> getListUsers(){
        List<User> listUsers = new ArrayList<>();
        List<String> listHeadings = new ArrayList<>();
        for(WebElement heading : getChildElements(th)){
            listHeadings.add(heading.getText());
        }
        for (WebElement row : getChildElements(tr)) {
            listUsers.add(new User(
                    row.findElements(td).get(listHeadings.indexOf(WebTables.FIRST_NAME.getTitle())).getText(),
                    row.findElements(td).get(listHeadings.indexOf(WebTables.LAST_NAME.getTitle())).getText(),
                    row.findElements(td).get(listHeadings.indexOf(WebTables.EMAIL.getTitle())).getText(),
                    Integer.parseInt(row.findElements(td).get(listHeadings.indexOf(WebTables.AGE.getTitle())).getText()),
                    Integer.parseInt(row.findElements(td).get(listHeadings.indexOf(WebTables.SALARY.getTitle())).getText()),
                    row.findElements(td).get(listHeadings.indexOf(WebTables.DEPARTMENT.getTitle())).getText()));
        }
        return listUsers;
    }

    public int getNumberOfUsers(){
        return getChildElements(tr).size();
    }

    public void deleteUser(User user) {
        if(isUserInTable(user)){
            int index = getListUsers().indexOf(user);
            Button button = new Button(By.xpath(String.format(exampleButtonDeleteRecord, index+1)), "Кнопка Delete user");
            button.click();
        }
    }
}
