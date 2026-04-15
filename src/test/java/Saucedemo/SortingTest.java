package Saucedemo;

import io.qameta.allure.Epic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingTest extends BaseTests {

    @Epic("SauceDemo")
    @Test
    public void checkSortingTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.go();

        InventoryPage inventoryPage = loginPage.login("standard_user", "secret_sauce");

        List<Double> pricesBefore = inventoryPage.getProductPrices();

        inventoryPage.sortPricesLowToHigh();

        List<Double> pricesAfter = inventoryPage.getProductPrices();

        Assertions.assertTrue(inventoryPage.isSorted(pricesAfter), "List is not sorted");


        //LUB

        List<Double> actualPrices = inventoryPage.getProductPrices();

        // 4. Weryfikacja (Asercja)
        // Tworzymy kopię listy i ją sortujemy
        List<Double> expectedSortedPrices = new ArrayList<>(actualPrices);
        Collections.sort(expectedSortedPrices);

        Assertions.assertEquals(expectedSortedPrices, actualPrices, "Prices are not sorted correctly!");

    }
}
