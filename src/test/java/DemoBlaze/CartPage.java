package DemoBlaze;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait); // DWA parametry
    }
    By totalSum = By.cssSelector("#totalp");

    By placeOrderButton = By.cssSelector("button[data-target='#orderModal']");
    public void placeOrder(String name, String country, String city, String creditCard, String month, String year){

        wait.until(ExpectedConditions.visibilityOfElementLocated(totalSum));
        driver.findElement(placeOrderButton).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#orderModalLabel")));

        driver.findElement(By.cssSelector("#name")).sendKeys(name);
        driver.findElement(By.cssSelector("#country")).sendKeys(country);
        driver.findElement(By.cssSelector("#city")).sendKeys(city);
        driver.findElement(By.cssSelector("#card")).sendKeys(creditCard);
        driver.findElement(By.cssSelector("#month")).sendKeys(month);
        driver.findElement(By.cssSelector("#year")).sendKeys(year);


        driver.findElement(By.xpath("//button[text()='Purchase']")).click();
    }

    public boolean isProductInCart(String productName) {

        By productRow = By.xpath("//td[text()='" + productName + "']");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productRow)).isDisplayed();
    }
}
