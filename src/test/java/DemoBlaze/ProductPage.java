package DemoBlaze;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage{



    public ProductPage(WebDriver driver, WebDriverWait wait) {
        super(driver,wait); // DWA parametry
    }

    By addToCartButton = By.xpath("//a[text()='Add to cart']");
    By goToCartButton = By.cssSelector("#cartur");

    public void addToCart(){

        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public CartPage goToCart(){

        driver.findElement(goToCartButton).click();
        return new CartPage(driver, wait);
    }
}
