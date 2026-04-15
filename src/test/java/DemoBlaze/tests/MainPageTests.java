package DemoBlaze.tests;

import DemoBlaze.pages.HomePage;
import DemoBlaze.pages.ProductPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MainPageTests extends BaseTests {


    @Test
    public void chosenProductShouldBeTheMostExpensive() {

        HomePage homePage = new HomePage(driver, wait);

        homePage.go();

        homePage.selectCategory("Laptops");

        List<Integer> allProductPrices = homePage.getProductPrices();

        int highestPrice = homePage.returnTheHighestPrice(allProductPrices);

        ProductPage productPage = homePage.goToTheProductWithTheHighestPrice(highestPrice);

        Assertions.assertEquals(highestPrice, productPage.getProductPrice());

    }
}
