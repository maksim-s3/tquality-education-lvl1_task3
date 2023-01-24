package framework.base;

import framework.driver_utils.Driver;
import framework.logger.Log;
import framework.utils.JSUtil;
import framework.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public abstract class BaseElement {
    protected By locator;
    protected String descriptionElement;
    private String className = getClass().getSimpleName();

    protected BaseElement(By locator, String descriptionElement) {
        this.locator = locator;
        this.descriptionElement = descriptionElement;
    }

    protected WebElement getElement() {
        Log.debug(String.format(className + ": получить WebElement (%s): %s", locator.toString(), descriptionElement));
        return Driver.getInstance().findElement(locator);
    }

    protected WebElement getChildElement(By locator) {
        Log.debug(String.format(className + ": получить дочерний WebElement из (%s)", this.locator.toString() + locator.toString()));
        return getElement().findElement(locator);
    }

    protected List<WebElement> getChildElements(By locator) {
        Log.debug(String.format(className + ": получить список дочерних WebElement из (%s)", this.locator.toString() + locator.toString()));
        return getElement().findElements(locator);
    }

    public void click() {
        Log.debug(String.format(className + ": клик по (%s): %s", locator.toString(), descriptionElement));
        WaitUtil.getWait().until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
    }

    public String getText() {
        Log.debug(String.format(className + ": получить текст из (%s): %s", locator.toString(), descriptionElement));
        return getElement().getText();
    }

    public String getAttribute(String attribute) {
        Log.debug(String.format(className + ": получить атрибут (\"%s\") из (%s): %s", attribute, locator.toString(), descriptionElement));
        return getElement().getAttribute(attribute);
    }

    public void scroll() {
        Log.debug(String.format(className + ": скролл к элементу (%s): %s", locator.toString(), descriptionElement));
        JSUtil.scrollIntoView(getElement());
    }

    public void waitVisibilityOfElementLocated() {
        Log.debug(String.format(className + ": ожидание появления в DOM и видимости элемента (%s): %s", locator.toString(), descriptionElement));
        WaitUtil.getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitInvisibilityOfElementLocated() {
        Log.debug(String.format(className + ": ожидание удаления из DOM и скрытия элемента (%s): %s", locator.toString(), descriptionElement));
        WaitUtil.getWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}
