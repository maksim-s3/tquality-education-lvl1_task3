package test_cases;

import enums.Category;
import enums.LeftAccordionListItem;
import framework.base.BaseTest;
import framework.logger.Log;
import framework.utils.BrowserUtil;
import objects.*;
import objects.frames.BottomFrame;
import objects.frames.ChildFrame;
import objects.frames.ParentFrame;
import objects.frames.TopFrame;
import objects.navigation.LeftAccordion;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCase2 extends BaseTest {
    @Parameters({"textFromParentFrame", "textFromChildFrame"})
    @Test
    public void test(String textFromParentFrame, String textFromChildFrame) {
        Log.info("Test Case 2: Шаг 1. Перейти на главную страницу");
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpen(), "Main page is not open");

        Log.info("Test Case 2: Шаг 2. Кликнуть на кнопку Alerts, Frame & Windows. На открывшейся странице в левом меню кликнуть пункт Nested Frames");
        mainPage.clickOnCategory(Category.ALERTS_FRAME_AND_WINDOWS);
        LeftAccordion leftAccordion = new LeftAccordion();
        leftAccordion.clickItemSubMenu(LeftAccordionListItem.NESTED_FRAMES);
        NestedFramesPage nestedFramesPage = new NestedFramesPage();
        Assert.assertTrue(nestedFramesPage.isPageOpen(), "Page Nested Frames is not open");
        ParentFrame parentFrame = new ParentFrame();
        Assert.assertEquals(parentFrame.getTextInFrame(), textFromParentFrame, "Text from Parent Frame is not equals");
        ChildFrame childFrame = new ChildFrame();
        Assert.assertEquals(childFrame.getTextInFrame(), textFromChildFrame, "Text from Child Frame is not equals");
        BrowserUtil.switchToDefaultContent();

        Log.info("Test Case 2: Шаг 3. В левом меню выбрать пункт Frames");
        leftAccordion.clickItemSubMenu(LeftAccordionListItem.FRAMES);
        FramesPage framesPage = new FramesPage();
        Assert.assertTrue(framesPage.isPageOpen(), "Page Frames is not open");
        TopFrame topFrame = new TopFrame();
        String textFromTopFrame = topFrame.getTextInFrame();
        BrowserUtil.switchToDefaultContent();
        BottomFrame bottomFrame = new BottomFrame();
        String textFromBottomFrame = bottomFrame.getTextInFrame();
        BrowserUtil.switchToDefaultContent();
        Assert.assertEquals(textFromTopFrame, textFromBottomFrame,
                "Text from upper frame is not equal to text from lower frame");
    }
}
