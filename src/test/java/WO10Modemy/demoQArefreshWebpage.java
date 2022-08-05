package WO10Modemy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;

public class demoQArefreshWebpage {
    private WebDriver driver;

    @Before
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");// Bypass OS security model
        options.addArguments("--disable-dev-shm-usage");// overcome limited resource problems
        options.addArguments("ignore-certificate-errors");//self-described
        options.addArguments("ignore-ssl-errors");
        options.addArguments("--start-maximized");
        //options.addArguments("headless");//pozwala uruchamiac przegladarke w trybie non-GUI  ->  A headless browser is a browser simulation program that does not have a user interface.
        //PONIZSZY ARGUMENT URUCHAMIA uBLOCK ORIGIN
        options.addArguments("--load-extension=" + "C:\\Users\\Robert\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\cjpalhdlnbpafiamejdnhcphjbkeiagm\\1.43.0_49");

        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver(options);
    }
    @Test
    public void test(){
        String URL = "https://www.toolsqa.com/selenium-webdriver/refresh-browser/";
        driver.get(URL);

        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
        }

        driver.navigate().refresh();

        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
        }
        Actions action = new Actions(driver);
        action.sendKeys(Keys.F5);

    }
    @After
    public void after(){
        driver.quit();
    }
}
