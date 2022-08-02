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
import org.openqa.selenium.interactions.Actions;


public class demoQAActionsKeyboardEvents {
    private WebDriver driver;

    @Before
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");// Bypass OS security model
        options.addArguments("--disable-dev-shm-usage");// overcome limited resource problems
        options.addArguments("ignore-certificate-errors");//self-described
        options.addArguments("ignore-ssl-errors");
        options.addArguments("--start-maximized");
        //PONIZSZY ARGUMENT URUCHAMIA uBLOCK ORIGIN
        options.addArguments("--load-extension=" + "C:\\Users\\Robert\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\cjpalhdlnbpafiamejdnhcphjbkeiagm\\1.43.0_49");

        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver(options);
//      driver.manage().window().maximize();

    }

    @Test
    public void testToolTipAsAttribute() {
        driver.get("https://demoqa.com/text-box");
        Actions actions = new Actions(driver);
        WebElement currAddress = driver.findElement(By.id("currentAddress"));
        WebElement permAddress = driver.findElement(By.id("permanentAddress"));

        currAddress.sendKeys("fwfwfw\newrwertetwqe\n\nrrrweqeq");
//      CTRL + A -> CTRL + C
        actions.keyDown(Keys.CONTROL);//dla keyDown dozwolone sa tylko Keys.CONTROL, Keys.SHIFT i Keys.ALT
        actions.sendKeys("a");
        actions.sendKeys("c");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();

        actions.keyDown(permAddress, Keys.CONTROL);
        actions.sendKeys("v");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();

        Assert.assertEquals("Content of fields mismatched", currAddress.getAttribute("value"), permAddress.getAttribute("value"));
        System.out.print("Current Address field:\n" + currAddress.getAttribute("value") + "\n" + "-----------------------------------------" + "\n" + "Permanent Address field:\n" + permAddress.getAttribute("value"));
    }

    @After
    public void after (){
//    driver.quit();
    }
}
