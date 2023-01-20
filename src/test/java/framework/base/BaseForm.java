package framework.base;

import framework.driver_utils.Driver;
import framework.logger.Logger;
import framework.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class BaseForm {
    private By locator;
    private String className = getClass().getSimpleName();

    protected BaseForm(By locator) {
        this.locator = locator;
    }

    public boolean isPageOpen() {
        Logger.info(className + ": Проверка статуса формы");
        return !Driver.getInstance().findElements(locator).isEmpty();
    }

    public void waitForPageToLoad() {
        Logger.info(className + ": Ожидание загрузки формы");
        WaitUtil.getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
