package objects.frames;

import framework.base.BaseForm;
import framework.base.elements.Text;
import framework.utils.BrowserUtil;
import org.openqa.selenium.By;

public class BottomFrame extends BaseForm {
    private static By locator = By.xpath("//*[@id='frame2Wrapper']/*");
    private Text textFieldInBody = new Text(By.xpath("//*[text()]"), "Текстовое поле в нижнем Frame");

    public BottomFrame() {
        super(locator);
        switchTo();
    }

    public void switchTo() {
        BrowserUtil.switchToFrame(locator);
    }

    public String getTextInFrame() {
        return textFieldInBody.getText();
    }
}
