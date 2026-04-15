package Saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class InventoryPage extends BasePage {

    private final By pageTitle = By.cssSelector(".title");
    private final By sortButtonLocator = By.cssSelector(".product_sort_container");
    private final By priceList = By.className("inventory_item_price");

    private final By goToCartButton = By.cssSelector("[data-test='shopping-cart-link']");

    private final By productNamesList = By.xpath("//div[@data-test='inventory-item-name']");

    protected InventoryPage(WebDriver driver) {
        super(driver);
    }


    public boolean isLoaded() {
        // Sprawdzamy czy widoczny jest napis "Products"
        return driver.findElement(pageTitle).isDisplayed()
                && driver.getCurrentUrl().contains("inventory.html");
    }

    public List<Double> getProductPrices() {
        List<WebElement> priceElements = driver.findElements(priceList);
        List<Double> prices = new ArrayList<>();

        for (WebElement element : priceElements) {
            // Pobieramy tekst, usuwamy $ i zamieniamy na liczbę
            String priceText = element.getText().replace("$", "");
            prices.add(Double.valueOf(priceText));
        }

        return prices;
    }

    public void sortPricesLowToHigh() {

        WebElement dropdown = driver.findElement(sortButtonLocator);

        Select select = new Select(dropdown);

        select.selectByValue("lohi");
    }

    public boolean isSorted(List<Double> pricesAfter) {

        for (int i = 0; i < pricesAfter.size() - 1; i++) {
            if (pricesAfter.get(i) > pricesAfter.get((i + 1))) {
                return false;
            }
        }
        return true;
    }


    public CartPage goToCartPage() {

        driver.findElement(goToCartButton).click();

        return new CartPage(driver);
    }


    public List<String> getProductNames() {
        List<WebElement> productNamesElements = driver.findElements(productNamesList);
        List<String> productNames = new ArrayList<>();

        for (WebElement element : productNamesElements) {
            String productName = element.getText().replace(" ", "-").toLowerCase();
            productNames.add(productName);
        }

        return productNames;
    }


    public void addToCart(String productName) {

        String AddToCartSelector = "#add-to-cart-" + productName;

        driver.findElement(By.cssSelector(AddToCartSelector)).click();


    }

}
