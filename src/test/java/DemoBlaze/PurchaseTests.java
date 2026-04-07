package DemoBlaze;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;

public class PurchaseTests extends BaseTests{


    String confirmationSuccess = "Thank you for your purchase!";


    @ParameterizedTest
    @CsvSource({
            "Laptops, Sony vaio i5, Andrzej, 123456",
            "Laptops, MacBook air, Marek, 987654",
            "Phones, Samsung galaxy s6, Jan, 111222"
    })
    @Epic("DemoBlaze")
    @Feature("Shopping process")
    public void purchaseShouldEndWithConfirmationText(String productCategory, String productName, String name, String creditCard ){

        HomePage homePage = new HomePage(driver, wait);

        homePage.go();

        homePage.selectCategory(productCategory);

        ProductPage productPage = homePage.selectProduct(productName);

        productPage.addToCart();

        CartPage cartPage = productPage.goToCart();

        Assertions.assertTrue(cartPage.isProductInCart(productName));

        cartPage.placeOrder(name, "Poland", "Cracow", creditCard, "12", "2027");

        Assertions.assertEquals(confirmationSuccess, driver.findElement(By.cssSelector("div.sa-custom + h2")).getText());

    }
}
