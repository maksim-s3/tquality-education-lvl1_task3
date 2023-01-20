package framework.base.elements;

import framework.base.BaseElement;
import org.openqa.selenium.By;

public class Link extends BaseElement {

    public Link(By locator, String descriptionElement) {
        super(locator, descriptionElement);
    }
}
