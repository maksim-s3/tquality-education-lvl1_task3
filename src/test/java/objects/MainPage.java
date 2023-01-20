package objects;

import enums.Category;
import framework.base.BaseForm;
import framework.base.elements.Button;
import framework.logger.Logger;
import org.openqa.selenium.By;

public class MainPage extends BaseForm {
    private static By locatorMainPage = By.xpath("//*[contains(@class, 'home-banner')]");
    private String exampleCategory = "//*[contains(text(), '%s')]//ancestor-or-self::*[contains(@class, 'card mt-4 top-card')]";

    public MainPage() {
        super(locatorMainPage);
    }

    public void clickOnCategory(Category category){
        Logger.info(getClass().getSimpleName()+": Клик по категории: "+category.getTitle());
        Button button = new Button(By.xpath(String.format(exampleCategory, category.getTitle())), "Кнопка категории "+category.getTitle());
        button.click();
    }
}
