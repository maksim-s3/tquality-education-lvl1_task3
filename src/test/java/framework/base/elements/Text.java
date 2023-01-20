package framework.base.elements;

import framework.base.BaseElement;
import org.openqa.selenium.By;

public class Text extends BaseElement {

    public Text(By locator, String descriptionElement){
        super(locator, descriptionElement);
    }
}
