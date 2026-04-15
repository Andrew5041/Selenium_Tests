package TheInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected final WebDriver driver;
    By loadingIcon = By.cssSelector(".blockUI");

    protected final String baseUrl = "https://the-internet.herokuapp.com/";

    protected BasePage(WebDriver driver) {
        this.driver = driver;

    }

    protected void waitForLoadingIconDisappear() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfElementsToBe(loadingIcon, 0));
    }

    public void setWait() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

}
