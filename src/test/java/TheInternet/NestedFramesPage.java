package TheInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NestedFramesPage extends BasePage {


    protected NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    By topFrameLocator = By.cssSelector("frame[src='/frame_top']");

    By middleFrameLocator = By.cssSelector("frame[src='/frame_middle']");

    By bottomFrameLocator = By.cssSelector("frame[src='/frame_bottom']");

    public void goToTopFrame(){

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(topFrameLocator));

    }

    public void goToMiddleFrame(){

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(middleFrameLocator));

    }

    public void switchToDefaultContent(){

        driver.switchTo().defaultContent();

    }

    public String getMiddleFrameText(){

        return driver.findElement(By.cssSelector("#content")).getText();
    }

    public void goToBottomFrame() {
        // Najpierw musimy wyjść na samą górę, bo ramka BOTTOM
        // nie jest widoczna z wnętrza ramki TOP/MIDDLE
        driver.switchTo().defaultContent();

        // Teraz możemy wejść do ramki dolnej
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(bottomFrameLocator));
    }

    public String getBottomFrameText() {
        // Ramka dolna ma tekst bezpośrednio w body
        return driver.findElement(By.tagName("body")).getText().trim();
    }







}
