package objects.frames;

import framework.base.BaseForm;
import framework.base.elements.Text;
import framework.utils.BrowserUtil;
import org.openqa.selenium.By;

public class TopFrame extends BaseForm {
    private static By locator = By.xpath("//*[@id='frame1Wrapper']/*");
    private Text textField = new Text(By.xpath("//*[text()]"), "Текстовое поле в верхнем Frame");

    public TopFrame() {
        super(locator);
        switchTo();
    }

    public void switchTo(){
        BrowserUtil.switchToFrame(locator);
    }

    public String getTextInFrame(){
        return textField.getText();
    }
}
