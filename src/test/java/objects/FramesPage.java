package objects;

import framework.base.BaseForm;
import org.openqa.selenium.By;

public class FramesPage extends BaseForm {
    private static By locatorFramesPage = By.xpath("//*[contains(@class, 'main-header') and contains(text(), 'Frames')]");

    public FramesPage() {
        super(locatorFramesPage);
    }
}
