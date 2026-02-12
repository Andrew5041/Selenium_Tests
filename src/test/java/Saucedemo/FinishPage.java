package Saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FinishPage extends BasePage{
    protected FinishPage(WebDriver driver) {
        super(driver);
    }

    private final By confirmationTextElement = By.cssSelector("[data-test='complete-header']");


    public String getConfirmationInfo(){

        String confirmationText = driver.findElement(confirmationTextElement).getText();

        return confirmationText;


    }




}
