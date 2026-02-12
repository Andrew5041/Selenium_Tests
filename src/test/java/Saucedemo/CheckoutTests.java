package Saucedemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckoutTests extends BaseTests{

    @Test
    public void completePurchaseTest(){

        LoginPage loginPage = new LoginPage(driver);

        loginPage.go();

        InventoryPage inventoryPage = loginPage.login("standard_user", "secret_sauce");

        String FirstProductName = inventoryPage.getProductNames().get(0);

        inventoryPage.addToCart(FirstProductName);

        CartPage cartPage = inventoryPage.goToCartPage();

        CheckoutPage checkoutPage = cartPage.goToCheckout();

        checkoutPage.fillCheckoutFormular("Jan", "Kowalski", "20-601");

        OverviewPage overviewPage = checkoutPage.goToOverview();

        FinishPage finishPage = overviewPage.goToFinishPage();

        Assertions.assertEquals("Thank you for your order!", finishPage.getConfirmationInfo(), "Confirmation text is different, did you place the order ?");


    }
}
