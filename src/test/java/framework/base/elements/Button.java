package framework.base.elements;

import framework.base.BaseElement;
import org.openqa.selenium.By;

public class Button extends BaseElement {

    public Button (By locator, String descriptionElement){
        super(locator, descriptionElement);
    }
}
