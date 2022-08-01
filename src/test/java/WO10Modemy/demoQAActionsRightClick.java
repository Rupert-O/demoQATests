package WO10Modemy;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class demoQAActionsRightClick {
    private WebDriver driver;
    String URL = "http://demoqa.com/buttons";

    @Before
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");// Bypass OS security model
        options.addArguments("--disable-dev-shm-usage");// overcome limited resource problems
        options.addArguments("ignore-certificate-errors");//self-described
        options.addArguments("ignore-ssl-errors");

        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @Test
    public void test() {
        Actions actions = new Actions(driver);
        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));

        actions.contextClick(rightClickBtn); //click RMButton
        actions.perform();

        Assert.assertEquals("message doesn't match", "You have done a right click", driver.findElement(By.id("rightClickMessage")).getText());
    }

//    assertEquals
//    public static void assertEquals(String message,
//                                    Object expected,
//                                    Object actual)
//    Asserts that two objects are equal. If they are not, an AssertionError is thrown with the given message. If expected and actual are null, they are considered equal.
//    Parameters:
//    message - the identifying message for the AssertionError (null okay)
//    expected - expected value
//    actual - actual value

    @After
    public void tearDown(){
//        driver.quit();
    }
}