package CoffeeCart;

import io.qameta.allure.Epic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckoutTests extends BaseTests {

    @Epic("CoffeCart")
    @Test
    public void CheckSuccessfulCheckout() {

        CoffeePage coffeePage = new CoffeePage(driver);

        coffeePage.go();

        coffeePage.addCoffee("Espresso");

        coffeePage.pay();

        coffeePage.fillPaymentForm("John", "johndoe@gmail.com");

        coffeePage.submit();

        String expectedMsg = "Thanks for your purchase. Please check your email for payment.";

        Assertions.assertEquals(expectedMsg, coffeePage.getSuccessMessage());

    }
}
