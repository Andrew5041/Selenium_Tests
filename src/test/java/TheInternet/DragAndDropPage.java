package TheInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class DragAndDropPage extends BasePage{


    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    By squareALocator = By.cssSelector("#column-a");
    By squareBLocator = By.cssSelector("#column-b");


    public String getSquareHeaders(String columnName){

        By headerWithinColumn = By.cssSelector("#column-"+ columnName + " header");

        WebElement header = driver.findElement(headerWithinColumn);

        return header.getText();
    }

    public void changeSquarePositions(){

        Actions actions = new Actions(driver);

        WebElement source = driver.findElement(squareALocator);
        WebElement target = driver.findElement(squareBLocator);

        actions.dragAndDrop(source, target).perform();

    }







    }


