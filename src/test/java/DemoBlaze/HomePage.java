package DemoBlaze;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomePage extends BasePage{


    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public void go(){

        driver.get(baseUrl);
    }

    public void selectCategory(String productCategory) {

        String category = "//a[text()='" + productCategory +"']";
        By laptopCategory = By.xpath(category);
        driver.findElement(laptopCategory).click();
    }

    public ProductPage selectProduct(String productName) {

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(productName))).click();
        return new ProductPage(driver, wait);
    }

    public void openContactModal() {
        driver.findElement(By.linkText("Contact")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("exampleModal")));
    }

    public void fillContactForm(String email, String name, String message) {
        driver.findElement(By.id("recipient-email")).sendKeys(email);
        driver.findElement(By.id("recipient-name")).sendKeys(name);
        driver.findElement(By.id("message-text")).sendKeys(message);
    }

    public void sendMessage(){

        driver.findElement(By.xpath("//button[text()='Send message']")).click();

    }

    public String getAlertTextAndAccept(){

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();

        String alertText = alert.getText();

        alert.accept();

        return alertText;

    }

    public List<Integer> getProductPrices(){

        By productCardsLocator = By.cssSelector("#tbodyid .card");

        List<WebElement> allProducts = wait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(productCardsLocator, 0)
        );

        List<Integer> allPrices = new ArrayList<>();

        for (WebElement product : allProducts) {

            WebElement priceCell = product.findElement(By.xpath(".//h5"));

            int productPrice = Integer.parseInt(priceCell.getText().replace("$", "").trim());

            allPrices.add(productPrice);

        }

        return allPrices;

    }

    public int returnTheHighestPrice(List<Integer> allPrices) {

        /*   int max = allPrices.get(0);

        for (int i = 1; i < allPrices.size(); i++ ){

            if (allPrices.get(i) > max){
                max = allPrices.get(i);

            }
        }*/

        int maxPrice = Collections.max(allPrices);
        return maxPrice;

    }

    public ProductPage goToTheProductWithTheHighestPrice(int maxPrice){

        driver.findElement(By.xpath("//h5[text()='$" + maxPrice + "']/preceding-sibling::h4/a")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Add to cart']")));

        return new ProductPage(driver, wait);

    }
}
