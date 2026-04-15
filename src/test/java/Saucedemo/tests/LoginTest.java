package Saucedemo.tests;

import Saucedemo.pages.InventoryPage;
import Saucedemo.pages.LoginPage;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTests {

    @Epic("SauceDemo")
    @Test
    @DisplayName("Standard user should be able to login and see inventory page")
    public void standardUserLoginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.go();

        InventoryPage inventoryPage = loginPage.login("standard_user", "secret_sauce");

        Assertions.assertTrue(inventoryPage.isLoaded(), "Inventory page is not loaded correctly!");


    }

    @Epic("SauceDemo")
    @Test
    @DisplayName("Locked out user should see error message")
    public void lockedOutUserTest() {
        // Arrange
        LoginPage loginPage = new LoginPage(driver);
        loginPage.go();

        // Act
        loginPage.tryLoginExpectingFailure("locked_out_user", "secret_sauce");

        // Assert
        Assertions.assertTrue(loginPage.getErrorMessage().contains("Epic sadface"),
                "Error message is incorrect or not displayed");

    }
}
