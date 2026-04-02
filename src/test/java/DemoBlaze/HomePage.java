package DemoBlaze;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
}
