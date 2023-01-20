package objects;

import framework.base.BaseForm;
import framework.base.elements.Button;
import framework.base.elements.Text;
import framework.logger.Logger;
import framework.utils.StringUtil;
import org.openqa.selenium.By;

public class ProgressBarPage extends BaseForm {
    private static By locatorProgressBarPage = By.xpath("//*[contains(@class, 'main-header') and contains(text(), 'Progress Bar')]");
    private String exampleExpectedConditionValue = "//*[@id='progressBar']/*[contains(text(), '%d%%')]";
    private Text progressBarValue = new Text(By.xpath("//*[@id='progressBar']/*"), "Значение прогресс бара");
    private Button buttonStartStop = new Button(By.xpath("//*[@id='startStopButton']"), "Кнопка start/stop прогресс бара");

    public ProgressBarPage() {
        super(locatorProgressBarPage);
    }

    public void clickButtonStartStop(){
        Logger.info(getClass().getSimpleName()+": Клик по кнопке start/stop на форме прогресс бара");
        buttonStartStop.scroll();
        buttonStartStop.click();
    }

    public void stopAfterReachingValue(int value){
        Logger.info(getClass().getSimpleName()+": Клик по кнопке stop когда наберется "+ value+"%");
        progressBarValue.scroll();
        Text expectedCondition = new Text(By.xpath(String.format(exampleExpectedConditionValue, value)),
                "% заполнения прогресс бара");
        expectedCondition.waitVisibilityOfElementLocated();
        clickButtonStartStop();
    }

    public int getValueProgressBar(){
        return StringUtil.getIntFromString(progressBarValue.getText());
    }
}
