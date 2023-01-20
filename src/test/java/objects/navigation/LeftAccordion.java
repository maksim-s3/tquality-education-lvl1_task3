package objects.navigation;

import enums.Category;
import enums.LeftAccordionListItem;
import framework.base.BaseForm;
import framework.base.elements.Button;
import org.openqa.selenium.By;

public class LeftAccordion extends BaseForm {
    private String exampleItemMenu = "//*[contains(text(), '%s')]//parent::*[contains(@class, 'header-wrapper')]";
    private String exampleItemSubMenu = "//*[text()='%s']//ancestor-or-self::*[contains(@class, 'btn')]";
    public LeftAccordion() {
        super(By.xpath("//*[contains(@class, 'accordion')]"));
    }

    public void clickItemMenu(Category itemMenu) {
        Button button = new Button(By.xpath(String.format(exampleItemMenu, itemMenu.getTitle())), "Кнопка категории "+itemMenu.getTitle());
        button.scroll();
        button.click();
    }

    public void clickItemSubMenu(LeftAccordionListItem itemSubMenu) {
        Button button = new Button(By.xpath(String.format(exampleItemSubMenu, itemSubMenu.getTitle())), "Кнопка подкатегории "+itemSubMenu.getTitle());
        button.waitVisibilityOfElementLocated();
        button.scroll();
        button.click();
    }
}
