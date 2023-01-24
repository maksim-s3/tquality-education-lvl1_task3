package test_cases;

import enums.Category;
import enums.LeftAccordionListItem;
import framework.base.BaseTest;
import framework.logger.Log;
import framework.utils.RandomUtil;
import objects.navigation.LeftAccordion;
import objects.MainPage;
import objects.ProgressBarPage;
import objects.SliderPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCase5 extends BaseTest {
    private static final int MIN_SLIDER_POSITION = 0;
    private static final int MAX_SLIDER_POSITION = 100;

    @Parameters({"age" , "ageErrorRate"})
    @Test
    public void test(int age, int ageErrorRate) {
        Log.info("Test Case 5: Шаг 1. Перейти на главную страницу");
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpen(), "Main page is not open");

        Log.info("Test Case 5: Шаг 2. Кликнуть на кнопку Widgets. В левом меню выбрать пункт Slider");
        mainPage.clickOnCategory(Category.WIDGETS);
        LeftAccordion leftAccordion = new LeftAccordion();
        leftAccordion.clickItemSubMenu(LeftAccordionListItem.SLIDER);

        Log.info("Test Case 5: Шаг 3. Установить слайдеру корректное случайно сгенерированное значение");
        SliderPage sliderPage = new SliderPage();
        Assert.assertTrue(sliderPage.isPageOpen(), "Page Slider is not open");
        int value = RandomUtil.getRandomIntNumber(MIN_SLIDER_POSITION, MAX_SLIDER_POSITION);
        sliderPage.setPositionSlider(value);
        Assert.assertEquals(sliderPage.getPositionSlider(), value, "Position Slider is not equals");

        Log.info("Test Case 5: Шаг 4. В левом меню выбрать пункт Progress Bar");
        leftAccordion.clickItemSubMenu(LeftAccordionListItem.PROGRESS_BAR);
        ProgressBarPage progressBarPage = new ProgressBarPage();
        progressBarPage.waitForPageToLoad();

        Log.info("Test Case 5: Шаг 5. Нажать на кнопку Start.");
        progressBarPage.clickButtonStartStop();

        Log.info("Test Case 5: Шаг 6. Нажать на кнопку Stop, когда на полосе загрузки появится значение, равное возрасту инженера, выполняющего задание");
        progressBarPage.stopAfterReachingValue(age);
        Assert.assertTrue(progressBarPage.getValueProgressBar() <= age + ageErrorRate, "Value age does not match");
    }
}
