package WO10Modemy;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class demoQAActions {
    private WebDriver driver;
    String URL = "https://demoqa.com/auto-complete/";

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
        WebElement multiInputBox = driver.findElement(By.id("autoCompleteMultipleInput"));
        multiInputBox.sendKeys("bl");

        actions.sendKeys(Keys.ARROW_DOWN);
        actions.sendKeys(Keys.ENTER);
        Action action = actions.build(); //build() - method of Actions class and creating the composite action.
        action.perform();
    }

    @After
    public void tearDown(){
//        driver.quit();
    }
}
/*
Different Methods for performing Keyboard Events:

keyDown(modifier key): Performs a modifier key press.
sendKeys(keys to send ): Sends keys to the active web element.
keyUp(modifier key): Performs a modifier key release.

Different Methods for performing Mouse Events:

click(): Clicks at the current mouse location.
doubleClick(): Performs a double-click at the current mouse location.
contextClick() : Performs a context-click at middle of the given element.
clickAndHold(): Clicks (without releasing) in the middle of the given element.
dragAndDrop(source, target): Click-and-hold at the location of the source element, moves to the location of the target element
dragAndDropBy(source, xOffset, yOffset):  Click-and-hold at the location of the source element, moves by a given offset
moveByOffset(x-offset, y-offset): Moves the mouse from its current position (or 0,0) by the given offset
moveToElement(toElement): Moves the mouse to the middle of the element
release(): Releases the depressed left mouse button at the current mouse location
 */