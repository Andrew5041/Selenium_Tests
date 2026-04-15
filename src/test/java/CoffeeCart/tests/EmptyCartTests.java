package CoffeeCart.tests;

import CoffeeCart.pages.CoffeePage;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EmptyCartTests extends BaseTests {

    @Epic("CoffeCart")
    @Test
    @DisplayName("Check if cart is empty on start")
    public void cartShouldBeEmptyOnStart() {

        CoffeePage coffeePage = new CoffeePage(driver);

        coffeePage.go();

        Assertions.assertEquals("Total: $0.00", coffeePage.getCartTotal(),
                "Cart total should be $0.00 on start!");

    }

    @Epic("CoffeCart")
    @Test
    @DisplayName("Negative: Checkout with empty cart")
    public void shouldBeAbleToProceedWithEmptyCart() {
        CoffeePage coffeePage = new CoffeePage(driver);
        coffeePage.go();

        // Symulujemy "błąd" użytkownika - płacimy za nic
        coffeePage.pay();
        coffeePage.fillPaymentForm("John", "johndoe@gmail.com");
        coffeePage.submit();

        // Sprawdzamy, czy aplikacja "łyknęła" pusty zakup
        Assertions.assertEquals("Thanks for your purchase. Please check your email for payment.",
                coffeePage.getSuccessMessage(),
                "App should (hypothetically) show success even for $0.00 purchase");
    }

}
