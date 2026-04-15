package DemoBlaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait); // DWA parametry
    }

    By totalSum = By.cssSelector("#totalp");
    By placeOrderButton = By.cssSelector("button[data-target='#orderModal']");


    public void placeOrder(String name, String country, String city, String creditCard, String month, String year) {

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


    public List<Integer> getProductsPrices() {

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[@class='success']")));

        List<Integer> allPrices = new ArrayList<>();

        List<WebElement> rowsSuccess = driver.findElements(By.xpath("//tr[@class='success']"));

        for (WebElement row : rowsSuccess) {

            WebElement priceCell = row.findElement(By.xpath("./td[3]"));

            int productPrice = Integer.parseInt(priceCell.getText().trim());

            allPrices.add(productPrice);

        }

        System.out.println(allPrices);
        return allPrices;

    }

    public int calculateTotal(List<Integer> allPrices) {
        int sum = 0;
        for (int price : allPrices) {
            sum += price;
        }
        System.out.println(sum);
        return sum;

    }

    public int getTotalPrice() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(totalSum));

        WebElement totalPrice = driver.findElement(totalSum);

        int sumPrice = Integer.parseInt(totalPrice.getText());

        return sumPrice;

    }

    public void deleteProduct(String productName) {

        By productRow = By.xpath("//td[text()='" + productName + "']");

        driver.findElement(By.xpath(" //td[text()='" + productName + "']/following-sibling::td/a[text()='Delete']")).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(productRow));

    }
}
