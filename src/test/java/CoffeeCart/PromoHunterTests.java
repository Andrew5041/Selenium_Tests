package CoffeeCart;

import io.qameta.allure.Epic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PromoHunterTests extends BaseTests {


    @Epic("CoffeCart")
    @Test
    public void CheckGettingExtraCupOfCoffee(){

        CoffeePage coffePage = new CoffeePage(driver);

        coffePage.go();

        coffePage.addCoffee("Espresso_Macchiato");
        coffePage.addCoffee("Cappuccino");
        coffePage.addCoffee("Americano");

        coffePage.acceptPromo();

        WebElement cartButton = driver.findElement(By.cssSelector("[aria-label='Cart page']"));
        Assertions.assertEquals("cart (4)", cartButton.getText());

    }
}
