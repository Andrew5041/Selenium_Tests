package Saucedemo;

import io.qameta.allure.Epic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class CartTests extends BaseTests {

    @Epic("SauceDemo")
    @Test
    public void CheckAddingProductsToCart() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.go();

        InventoryPage inventoryPage = loginPage.login("standard_user", "secret_sauce");

        String FirstProductName = inventoryPage.getProductNames().get(0);
        String SecondProductName = inventoryPage.getProductNames().get(1);

        System.out.println(FirstProductName);
        System.out.println(SecondProductName);

        inventoryPage.addToCart(FirstProductName);
        inventoryPage.addToCart(SecondProductName);

        List<String> productsAddedToCart = new ArrayList<>();

        productsAddedToCart.add(FirstProductName);
        productsAddedToCart.add(SecondProductName);

        Assertions.assertEquals(2, inventoryPage.getCartBadgeSize(), "There is different that 2 number of products added to the cart");

        CartPage cartPage = inventoryPage.goToCartPage();

        System.out.println(productsAddedToCart);

        Assertions.assertEquals(productsAddedToCart, cartPage.getProductNamesFromCart(), "Products list are not the same");

        cartPage.removeProductFromCart();

        Assertions.assertEquals(1, inventoryPage.getCartBadgeSize(), "There is different that 2 number of products added to the cart");

    }
}
