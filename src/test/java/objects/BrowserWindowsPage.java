package objects;

import framework.base.BaseForm;
import framework.base.elements.Button;
import framework.logger.Logger;
import org.openqa.selenium.By;

public class BrowserWindowsPage extends BaseForm {
    private static By locatorAlertsPage = By.xpath("//*[contains(@class, 'main-header') and contains(text(), 'Browser Windows')]");
    private Button buttonNewTab = new Button(By.xpath("//*[@id='tabButton']"), "Кнопка New Tab");

    public BrowserWindowsPage() {
        super(locatorAlertsPage);
    }

    public void clickButtonNewTab(){
        Logger.info(getClass().getSimpleName()+": Клик по кнопке New Tab");
        buttonNewTab.scroll();
        buttonNewTab.click();
    }
}
