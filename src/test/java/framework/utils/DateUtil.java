package framework.utils;

import framework.logger.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
    private static SimpleDateFormat formatter = null;

    public static Date getDate(String template){
        Log.info("DateUtil: Получить текущую дату и время по шаблону");
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
        Log.info("DateUtil: Получить дату и время из строки по шаблону");
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
