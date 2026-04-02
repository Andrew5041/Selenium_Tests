package DemoBlaze;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class PurchaseTests extends BaseTests{


    String confirmationSuccess = "Thank you for your purchase!";



    @Epic("DemoBlaze")
    @Feature("Shopping process")
    @Test
    public void purchaseShouldEndWithConfirmationText(){

        HomePage homePage = new HomePage(driver, wait);

        homePage.go();

        homePage.selectCategory("Laptops");

        ProductPage productPage = homePage.selectProduct("Sony vaio i5");

        productPage.addToCart();

        CartPage cartPage = productPage.goToCart();

        Assertions.assertTrue(cartPage.isProductInCart("Sony vaio i5"));



        cartPage.placeOrder("Andrzej", "Poland", "Cracow", "123456", "12", "2027");

        Assertions.assertEquals(confirmationSuccess, driver.findElement(By.cssSelector("div.sa-custom + h2")).getText());

    }
}
