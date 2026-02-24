package TheInternet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class MultipleWindowsTests extends BaseTests{

    @Test
    public void CheckSwitchingBetweenBrowserCarts(){

        MainPage mainPage = new MainPage(driver);

        String slug = "windows";

        WindowsPage windowsPage = mainPage.goToWindowsPage(slug);

        String mainWindowHandle = driver.getWindowHandle();

        windowsPage.openNewWindow();

        windowsPage.switchToWindowByTitle("New Window");

        Assertions.assertEquals("New Window", windowsPage.getHeaderText());

        driver.close();
        driver.switchTo().window(mainWindowHandle);

        Assertions.assertTrue(driver.findElement(By.linkText("Click Here")).isDisplayed());
    }
}
