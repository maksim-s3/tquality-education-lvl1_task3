package framework.base.elements;

import framework.base.BaseElement;
import framework.logger.Logger;
import org.openqa.selenium.By;

public class InputField extends BaseElement {
    public InputField(By locator, String descriptionElement) {
        super(locator, descriptionElement);
    }

    public void setValue(String text){
        Logger.debug(String.format("InputField: ввести текст \"%s\" в input: %s", text, descriptionElement));
        getElement().sendKeys(text);
    }
}
