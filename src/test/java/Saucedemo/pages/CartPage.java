package Saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {


    protected CartPage(WebDriver driver) {
        super(driver);
    }

    private final By productNamesInCartList = By.xpath("//div[@data-test='inventory-item-name']");

    private final By removeButtonsList = By.cssSelector("[data-test^='remove']");

    private final By checkoutButton = By.cssSelector("#checkout");


    public List<String> getProductNamesFromCart() {
        List<WebElement> productNamesElements = driver.findElements(productNamesInCartList);
        List<String> productNamesFromCart = new ArrayList<>();

        for (WebElement element : productNamesElements) {
            String productName = element.getText().replace(" ", "-").toLowerCase();
            productNamesFromCart.add(productName);
        }

        return productNamesFromCart;
    }

    public void removeProductFromCart() {

        List<WebElement> removeButtons = driver.findElements(removeButtonsList);
        removeButtons.get(0).click();
    }

    public CheckoutPage goToCheckout() {

        driver.findElement(checkoutButton).click();

        return new CheckoutPage(driver);


    }
}
