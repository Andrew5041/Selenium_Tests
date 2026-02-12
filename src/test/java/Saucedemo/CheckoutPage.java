package Saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{
    protected CheckoutPage(WebDriver driver) {
        super(driver);
    }

    private final By firstNameField = By.cssSelector("#first-name");

    private final By lastNameField = By.cssSelector("#last-name");

    private final By postalCodeField = By.cssSelector("#postal-code");

    private final By continueButton = By.cssSelector("#continue");


    public void fillCheckoutFormular(String firstName, String lastName, String postalCode){

        driver.findElement(firstNameField).sendKeys("Jan");
        driver.findElement(lastNameField).sendKeys("Kowalski");
        driver.findElement(postalCodeField).sendKeys("20-601");
    }

    public OverviewPage goToOverview(){

        driver.findElement(continueButton).click();

        return new OverviewPage(driver);


    }





}
