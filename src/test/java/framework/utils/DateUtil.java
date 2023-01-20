package framework.utils;

import framework.logger.Logger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
    private static SimpleDateFormat formatter = null;

    public static Date getDate(String template){
        Logger.info("DateUtil: Получить текущую дату и время по шаблону");
        formatter = new SimpleDateFormat(template, Locale.ENGLISH);
        Date date = null;
        try {
            date = formatter.parse(formatter.format(new Date()));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return date;
    }

    public static Date getDateFromString(String template, String string){
        Logger.info("DateUtil: Получить дату и время из строки по шаблону");
        formatter = new SimpleDateFormat(template, Locale.ENGLISH);
        Date date = null;
        try {
            date = formatter.parse(string);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return date;
    }
}
