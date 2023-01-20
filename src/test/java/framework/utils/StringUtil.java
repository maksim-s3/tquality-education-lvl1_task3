package framework.utils;

import framework.logger.Logger;

public class StringUtil {
    private static final String REGEX_SELECT_NUMBERS = "[^0-9]+";

    public static int getIntFromString(String text){
        Logger.info(String.format("StringUtil: выбрать цифры из текста \"%s\" и вернуть число", text));
        return Integer.parseInt(text.replaceAll(REGEX_SELECT_NUMBERS, ""));
    }
}
