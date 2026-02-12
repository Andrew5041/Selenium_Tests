package Saucedemo;

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

    private final By shoppingBadge = By.cssSelector("[data-test='shopping-cart-badge']");
    protected final String baseUrl = "https://www.saucedemo.com";

    protected BasePage(WebDriver driver){
        this.driver = driver;

    }
    protected void waitForLoadingIconDisappear(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfElementsToBe(loadingIcon, 0));
    }

    public int getCartBadgeSize() {
        // Obsługa przypadku, gdy badge znika (0 produktów)
        List<WebElement> badge = driver.findElements(shoppingBadge);
        if (badge.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(badge.get(0).getText());
    }
}
