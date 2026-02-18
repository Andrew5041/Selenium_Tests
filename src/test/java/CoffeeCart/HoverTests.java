package CoffeeCart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HoverTests extends BaseTests {

    @Test
    @DisplayName("Should show coffee description on hover")
    public void shouldShowDescriptionOnHover() {
        CoffeePage coffeePage = new CoffeePage(driver);
        coffeePage.go();

        // Act
        coffeePage.hoverOverCoffee("Cappuccino");

        // Pobieramy opis
        String description = coffeePage.getCoffeeDescription("Cappuccino");

        // Assert
        // Sprawdzamy, czy opis zawiera spodziewane słowa (Coffee Cart ma opisy w tooltipach)
        Assertions.assertTrue(description.toLowerCase().contains("espresso"),
                "Description does not contain 'espresso'!");
    }
}

