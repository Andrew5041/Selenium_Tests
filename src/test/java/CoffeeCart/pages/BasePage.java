package CoffeeCart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {

    protected final WebDriver driver;
    By loadingIcon = By.cssSelector(".blockUI");
    protected final String baseUrl = "https://coffee-cart.app/";

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void waitForLoadingIconDisappear() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfElementsToBe(loadingIcon, 0));
    }

}
