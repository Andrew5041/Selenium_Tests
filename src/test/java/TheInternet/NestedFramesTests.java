package TheInternet;

import io.qameta.allure.Epic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NestedFramesTests extends BaseTests{

    @Epic("TheInternet")
    @Test
    public void checkFramesSwitchingTest(){

        MainPage mainPage = new MainPage(driver);

        String slug = "nested_frames";

        NestedFramesPage nestedFramesPage = mainPage.goToNestedFramesPage(slug);

        nestedFramesPage.goToTopFrame();

        nestedFramesPage.goToMiddleFrame();

        Assertions.assertEquals("MIDDLE", nestedFramesPage.getMiddleFrameText());

        nestedFramesPage.goToBottomFrame();
        Assertions.assertEquals("BOTTOM", nestedFramesPage.getBottomFrameText());
    }
}
