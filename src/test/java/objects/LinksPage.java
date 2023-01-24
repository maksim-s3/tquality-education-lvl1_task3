package objects;

import enums.LinksForm;
import framework.base.BaseForm;
import framework.base.elements.Link;
import framework.logger.Log;
import org.openqa.selenium.By;

public class LinksPage extends BaseForm {
    private static By locatorLinksPage = By.xpath("//*[contains(@class, 'main-header') and contains(text(), 'Links')]");
    private String exampleLink = "//*[@id='%s']";

    public LinksPage() {
        super(locatorLinksPage);
    }

    public void clickLink(LinksForm textLink){
        Log.info(getClass().getSimpleName()+": Клик по ссылке: "+textLink.getTitle());
        Link link = new Link(By.xpath(String.format(exampleLink, textLink.getTitle())), String.format("Ссылка %s на странице Links", textLink));
        link.click();
    }
}
