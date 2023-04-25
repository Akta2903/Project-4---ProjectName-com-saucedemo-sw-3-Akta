package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl); //opening the Url
    }

    @Test
    public void userShouldLoginSuccessfullyWithValid() {
        sendTextToElement(By.id("user-name"), "standard_user");
        sendTextToElement(By.id("password"), "secret_sauce");
        clickOnElement(By.id("login-button"));
        String expectedMessage = "Products"; //expected message
        WebElement actualMessage = driver.findElement(By.xpath("//span[@class='title']")); //finding Actual message
        String actualMessage1 = actualMessage.getText(); //Storing the actual message in the string
        Assert.assertEquals("Error Message is not Displayed ", actualMessage1, expectedMessage); //compare actual and expected message

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        sendTextToElement(By.id("user-name"), "standard_user");
        sendTextToElement(By.id("password"), "secret_sauce");
        clickOnElement(By.id("login-button"));
        // Class name Locator --- To find multiple elements
        String expectedSize = "6";
        List<WebElement> productElementList = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        int size = productElementList.size();
        String actualSize =String.valueOf(size);
        verifyElementMethod(expectedSize,actualSize);




    }
}