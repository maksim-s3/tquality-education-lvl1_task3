package framework.base.elements;

import framework.base.BaseElement;
import framework.logger.Log;
import framework.utils.ActionUtil;
import org.openqa.selenium.By;

public class Slider extends BaseElement {
    private Text positionValue;

    public Slider(By locator, String descriptionElement, By locatorPositionValue) {
        super(locator, descriptionElement);
        positionValue = new Text(locatorPositionValue, "Позиция слайдера");
    }

    public int getPosition(){
        Log.debug(getClass().getSimpleName() + ": Получить фактическую позицию слайдера");
        return Integer.parseInt(positionValue.getAttribute("value"));
    }

    public void setPosition(int value) {
        Log.debug(getClass().getSimpleName() + ": Установить позицию " + value + "% для слайдера");
        while (value != getPosition()) {
            if (value < getPosition()) {
                moveLeft();
            } else if (value > getPosition()) {
                moveRight();
            }
        }
    }

    private void moveRight() {
        Log.debug(getClass().getSimpleName()+": Сдвинуть слайдер вправо");
        ActionUtil.moveRight();
    }

    private void moveLeft() {
        Log.debug(getClass().getSimpleName()+": Сдвинуть слайдер влево");
        ActionUtil.moveLeft();
    }
}
