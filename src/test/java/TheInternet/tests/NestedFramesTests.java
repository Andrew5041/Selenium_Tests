package TheInternet.tests;

import TheInternet.pages.MainPage;
import TheInternet.pages.NestedFramesPage;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NestedFramesTests extends BaseTests {

    @Epic("TheInternet")
    @Test
    public void checkFramesSwitchingTest() {

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
