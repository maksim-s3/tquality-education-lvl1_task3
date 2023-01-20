package objects;

import framework.base.BaseForm;
import framework.base.elements.Slider;
import framework.logger.Logger;
import org.openqa.selenium.By;

public class SliderPage extends BaseForm {
    private static By locatorSliderPage = By.xpath("//*[contains(@class, 'main-header') and contains(text(), 'Slider')]");
    private Slider slider = new Slider(By.xpath("//input[contains(@class, 'range-slider')]"), "Слайдер на странице Slider",
            By.xpath("//*[@id='sliderValue']"));

    public SliderPage() {
        super(locatorSliderPage);
    }

    public void setPositionSlider(int value) {
        Logger.info(getClass().getSimpleName() + ": Установить значение: " + value + " для слайдера");
        slider.scroll();
        slider.click();
        slider.setPosition(value);
    }

    public int getPositionSlider() {
        Logger.info(getClass().getSimpleName() + ": Получить положение слайдера");
        return slider.getPosition();
    }
}
