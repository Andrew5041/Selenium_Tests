package Saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage extends BasePage{
    protected OverviewPage(WebDriver driver) {
        super(driver);
    }

    private final By finishButton = By.cssSelector("#finish");

    public FinishPage goToFinishPage(){

        driver.findElement(finishButton).click();

        return new FinishPage(driver);


    }



}
