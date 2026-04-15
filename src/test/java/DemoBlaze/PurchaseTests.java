package DemoBlaze;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;

import java.util.List;

public class PurchaseTests extends BaseTests {


    String confirmationSuccess = "Thank you for your purchase!";

    By totalSumPage = By.cssSelector("#totalp");


    @ParameterizedTest
    @CsvSource({
            "Laptops, Sony vaio i5, Andrzej, 123456",
            "Laptops, MacBook air, Marek, 987654",
            "Phones, Samsung galaxy s6, Jan, 111222"
    })
    @Epic("DemoBlaze")
    @Feature("Shopping process")
    public void purchaseShouldEndWithConfirmationText(String productCategory, String productName, String name, String creditCard) {

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


    @Test
    public void removingProductShouldUpdateThePrice() {

        HomePage homePage = new HomePage(driver, wait);

        homePage.go();

        homePage.selectCategory("Phones");

        ProductPage phonesPage = homePage.selectProduct("Samsung galaxy s6");

        phonesPage.addToCart();

        homePage.go();

        homePage.selectCategory("Laptops");

        ProductPage laptopsPage = homePage.selectProduct("Sony vaio i5");

        laptopsPage.addToCart();

        CartPage cartPage = laptopsPage.goToCart();

        List<Integer> totalSumList = cartPage.getProductsPrices();

        int totalTableSum = cartPage.calculateTotal(totalSumList);

        Assertions.assertEquals(totalTableSum, cartPage.getTotalPrice());

        cartPage.deleteProduct("Sony vaio i5");

        List<Integer> totalSumListAfterDeletion = cartPage.getProductsPrices();

        int totalTableSumAfterDeletion = cartPage.calculateTotal(totalSumListAfterDeletion);

        Assertions.assertEquals(totalTableSumAfterDeletion, cartPage.getTotalPrice());

    }
}
