package TheInternet.tests;

import TheInternet.pages.DragAndDropPage;
import TheInternet.pages.MainPage;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DragAndDropTests extends BaseTests {

    @Epic("TheInternet")
    @Test
    public void checkSwitchingSquares() {

        MainPage mainPage = new MainPage(driver);

        String slug = "drag_and_drop";

        DragAndDropPage dragAndDropPage = mainPage.goToDragAndDropPage(slug);

        dragAndDropPage.changeSquarePositions();

        String aSquare = "a";

        String ASquareColumnName = dragAndDropPage.getSquareHeaders(aSquare);

        Assertions.assertEquals(ASquareColumnName, "B");

    }
}
