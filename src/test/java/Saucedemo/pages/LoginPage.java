package Saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {


    By loginNameLocator = By.cssSelector("#user-name");

    By passwordLocator = By.cssSelector("#password");

    By loginButtonLocator = By.cssSelector("#login-button");

    private final By errorMessage = By.cssSelector("[data-test='error']"); // Do Testu B


    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void go() {

        driver.get(baseUrl);

    }

    public InventoryPage login(String username, String password) {

        driver.findElement(loginNameLocator).sendKeys(username);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(loginButtonLocator).click();

        return new InventoryPage(driver);

    }

    // Metoda pomocnicza dla błędnego logowania (zwraca ten sam obiekt, bo zostajemy na stronie logowania)
    public LoginPage tryLoginExpectingFailure(String username, String password) {
        driver.findElement(loginNameLocator).sendKeys(username);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(loginButtonLocator).click();
        return this;
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
