package objects;

import framework.base.BaseForm;
import org.openqa.selenium.By;

public class NestedFramesPage extends BaseForm {
    private static By locatorNestedFramesPage = By.xpath("//*[contains(@class, 'main-header') and contains(text(), 'Nested Frames')]");

    public NestedFramesPage() {
        super(locatorNestedFramesPage);
    }
}
