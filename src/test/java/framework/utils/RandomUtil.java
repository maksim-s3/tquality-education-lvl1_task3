package framework.utils;

import com.github.javafaker.Faker;
import framework.logger.Logger;

public class RandomUtil {
    private static final int MIN = 10;
    private static final int MAX = 100;
    private static Faker faker = new Faker();

    public static String getRandomText(int min, int max){
        Logger.info(String.format("RandomUtil: получить сгенерированный текст длиной от %d до %d", min, max));
        String text = faker.internet().password(min, max);
        return text;
    }

    public static String getRandomText(){
        Logger.info(String.format("RandomUtil: получить сгенерированный текст длиной от %d до %d", MIN, MAX));
        return getRandomText(MIN, MAX);
    }

    public static int getRandomIntNumber(int min, int max){
        Logger.info(String.format("RandomUtil: получить сгенерированное число от %d до %d", min, max));
        return faker.number().numberBetween(min, max);
    }

    public static int getRandomIntNumber(){
        Logger.info(String.format("RandomUtil: получить сгенерированное число от %d до %d", MIN, MAX));
        return getRandomIntNumber(MIN, MAX);
    }
}
