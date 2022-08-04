package WO10Modemy;

import javafx.scene.control.Tab;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertTrue;

public class demoQATest {
    private WebDriver driver;
    String URLtextBox = "https://demoqa.com/text-box";
@Before
    public void setUp(){
    // Uruchom nowy egzemplarz przeglądarki Chrome
    System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--no-sandbox");// Bypass OS security model
    options.addArguments("--disable-dev-shm-usage");// overcome limited resource problems
    options.addArguments("ignore-certificate-errors");//self-described
    options.addArguments("ignore-ssl-errors");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(URLtextBox);
    }
@Test
    public void Test(){
        //Fill text field Full name
        WebElement textBoxFullName;
        textBoxFullName = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[1]/div[2]/input"));
        textBoxFullName.sendKeys("John");
        textBoxFullName.sendKeys(Keys.TAB);

        //Fill text field Email
        WebElement textBoxEmail;
        textBoxEmail = driver.findElement(By.id("userEmail"));
        textBoxEmail.sendKeys("blabla@gmail.com");
        textBoxEmail.sendKeys(Keys.TAB);

        //Click submit button
        WebElement submmitButton;
        submmitButton = driver.findElement(By.id("submit"));
        //Scroluje o 550 pikseli w dół i 0 w lewo
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,550)");
//
        submmitButton.click();
    }
@After
    public void assertTrue() {
    Boolean outputBox;
    outputBox = driver.findElement(By.id("output")).isDisplayed();
    Assert.assertTrue("output Box is visible - test passed", outputBox);
}
    public void tearDown() throws Exception {

    // Zamknij przeglądarkę
//        driver.quit();
}
}
