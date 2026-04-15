package TheInternet.pages;

import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {


    protected MainPage(WebDriver driver) {
        super(driver);
    }


    public NestedFramesPage goToNestedFramesPage(String slug) {

        driver.get(baseUrl + slug);

        return new NestedFramesPage(driver);

    }

    public WindowsPage goToWindowsPage(String slug) {

        driver.get(baseUrl + slug);

        return new WindowsPage(driver);

    }

    public DragAndDropPage goToDragAndDropPage(String slug) {

        driver.get(baseUrl + slug);

        return new DragAndDropPage(driver);

    }


}
