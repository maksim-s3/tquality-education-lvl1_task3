package objects;

import framework.base.BaseForm;
import framework.base.elements.Text;
import framework.logger.Log;
import framework.utils.DateUtil;
import org.openqa.selenium.By;
import java.util.Date;

public class DatePickerPage extends BaseForm {
    private static By locatorDatePickerPage = By.xpath("//*[contains(@class, 'main-header') and contains(text(), 'Date Picker')]");
    private Text selectDate = new Text(By.xpath("//*[@id='datePickerMonthYearInput']"), "Поле Select Date");
    private Text dateAndTime = new Text(By.xpath("//*[@id='dateAndTimePickerInput']"), "Поле Date And Time");

    public DatePickerPage() {
        super(locatorDatePickerPage);
    }

    public Date getSelectDateFromTemplate(String dateTemplate){
        Log.info(getClass().getSimpleName()+": Вернуть дату из поля Select Date");
        Date date = DateUtil.getDateFromString(dateTemplate, selectDate.getAttribute("value"));
        return date;
    }

    public Date getDateAndTimeFromTemplate(String dateTemplate){
        Log.info(getClass().getSimpleName()+": Вернуть дату из поля Date And Time");
        Date date = DateUtil.getDateFromString(dateTemplate, dateAndTime.getAttribute("value"));
        return date;
    }
}
