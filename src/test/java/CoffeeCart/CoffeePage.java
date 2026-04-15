package CoffeeCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CoffeePage extends BasePage {


    protected CoffeePage(WebDriver driver) {
        super(driver);
    }

    By extraCoffeeButton = By.cssSelector(".yes");

    By payButton = By.cssSelector(".pay");

    By nameLocator = By.cssSelector("#name");
    By emailLocator = By.cssSelector("#email");

    By promotionCheckbox = By.cssSelector("[name='promotion']");

    By submitButton = By.cssSelector("#submit-payment");

    By snackBarSuccesButton = By.cssSelector(".snackbar");

    public void go() {

        driver.get(baseUrl);
    }

    public void addCoffee(String name) {

        String coffeeName = "[data-test='" + name + "']";

        By coffeeTypeLocator = By.cssSelector(coffeeName);

        driver.findElement(coffeeTypeLocator).click();
    }

    public void acceptPromo() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(extraCoffeeButton))
                .click();
    }


    public void hoverOverCoffee(String name) {
        // Formatuje nazwę do selektora (Coffee Cart używa myślników w data-test)
        String formattedName = name.replace("_", "-");
        By coffeeNameLocator = By.cssSelector("[data-test='" + formattedName + "']");

        WebElement coffeeElement = driver.findElement(coffeeNameLocator);

        // Inicjalizacja klasy Actions
        Actions actions = new Actions(driver);

        // moveToElement() przesuwa kursor, a perform() wykonuje zapisaną akcję
        actions.moveToElement(coffeeElement).perform();
    }

    public String getCoffeeDescription(String name) {
        // Opis pojawia się dynamicznie, zazwyczaj wewnątrz elementu kawy
        // Na Coffee Cart to zazwyczaj tekst wewnątrz karty po hoverze
        String formattedName = name.replace("_", "-");
        By descriptionLocator = By.cssSelector("[data-test='" + formattedName + "']");

        return driver.findElement(descriptionLocator).getText();
    }

    public void pay() {

        driver.findElement(payButton).click();

    }

    public void fillPaymentForm(String name, String email) {

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(nameLocator));

        driver.findElement(nameLocator).sendKeys(name);
        driver.findElement(emailLocator).sendKeys(email);

        WebElement checkbox = driver.findElement(promotionCheckbox);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }

    }

    public void submit() {

        driver.findElement(submitButton).click();

    }

    public String getSuccessMessage() {
        // Czekamy na pojawienie się snackbara i zwracamy jego tekst
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(snackBarSuccesButton))
                .getText();
    }

    public String getCartTotal() {
        // Pobieramy tekst z przycisku pay (np. "total: $0.00")
        return driver.findElement(payButton).getText();
    }

    public boolean isCartEmpty() {
        return getCartTotal().contains("$0.00");
    }
}


