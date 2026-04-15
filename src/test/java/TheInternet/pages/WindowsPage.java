package TheInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowsPage extends BasePage {


    protected WindowsPage(WebDriver driver) {
        super(driver);
    }

    By clickNewWindowLocator = By.cssSelector("[href='/windows/new']");

    private final By newWindowHeader = By.tagName("h3");

    public void openNewWindow() {

        driver.findElement(clickNewWindowLocator).click();

    }

    public void switchToWindowByTitle(String expectedTitle) {

        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String handle : allWindowHandles) {

            driver.switchTo().window(handle);
            if (driver.getTitle().equals(expectedTitle)) {
                break;
            }
        }
    }

    public String getHeaderText() {
        return driver.findElement(newWindowHeader).getText();
    }


}
