package objects;

import framework.base.BaseForm;
import framework.base.elements.Button;
import framework.base.elements.Text;
import framework.logger.Logger;
import org.openqa.selenium.By;

public class AlertsPage extends BaseForm {
    private static By locatorAlertsPage = By.xpath("//*[contains(@class, 'main-header') and contains(text(), 'Alerts')]");
    private String exampleAlertButton = "//*[@id='%s']";
    private Text confirmResult = new Text(By.xpath("//*[@id='confirmResult']"), "Текстовое поле confirm alert");
    private Text promptResult = new Text(By.xpath("//*[@id='promptResult']"), "Текстовое поле prompt alert");

    public AlertsPage() {
        super(locatorAlertsPage);
    }

    public void clickButtonAlert(enums.AlertsForm alertButton){
        Logger.info(getClass().getSimpleName()+": Клик по кнопке алерта: "+ alertButton.getTitle());
        Button button = new Button(By.xpath(String.format(exampleAlertButton, alertButton.getTitle())), "Кнопка выбора алерта");
        button.click();
    }

    public String getTextConfirmResult(){
        Logger.info(getClass().getSimpleName()+": Получить текстовое поле confirm alert result");
        return confirmResult.getText();
    }

    public String getTextPromptResult(){
        Logger.info(getClass().getSimpleName()+": Получить текстовое поле prompt alert result");
        return promptResult.getText();
    }
}
