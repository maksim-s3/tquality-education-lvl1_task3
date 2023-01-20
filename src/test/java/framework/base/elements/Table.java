package framework.base.elements;

import framework.base.BaseElement;
import org.openqa.selenium.By;

public class Table extends BaseElement {
    protected By tr;
    protected By td;
    protected By th;

    public Table(By locator, String descriptionElement, By tr, By td, By th) {
        super(locator, descriptionElement);
        this.tr = tr;
        this.td = td;
        this.th = th;
    }
}
