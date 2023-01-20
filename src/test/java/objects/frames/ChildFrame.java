package objects.frames;

import framework.base.BaseForm;
import framework.base.elements.Text;
import framework.utils.BrowserUtil;
import org.openqa.selenium.By;

public class ChildFrame extends BaseForm {
    private static By locator = By.xpath("//iframe");
    private Text textFieldInBody = new Text(By.xpath("//*[text()]"), "Текстовое поле в Child Frame");
    public ChildFrame() {
        super(locator);
        switchTo();
    }

    public void switchTo(){
        BrowserUtil.switchToFrame(locator);
    }

    public String getTextInFrame(){
        return textFieldInBody.getText();
    }

}
