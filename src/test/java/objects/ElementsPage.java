package objects;

import framework.base.BaseForm;
import org.openqa.selenium.By;

public class ElementsPage extends BaseForm {
    private static By locatorElementsPage = By.xpath("//*[contains(@class, 'main-header') and contains(text(), 'Elements')]");

    public ElementsPage() {
        super(locatorElementsPage);
    }
}
