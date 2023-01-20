package objects;

import framework.base.BaseForm;
import org.openqa.selenium.By;

public class SamplePage extends BaseForm {
    private static By locatorSamplePage = By.xpath("//*[@id='sampleHeading']");
    public SamplePage() {
        super(locatorSamplePage);
    }
}
