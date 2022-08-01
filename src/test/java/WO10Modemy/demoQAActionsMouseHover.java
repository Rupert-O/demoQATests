package WO10Modemy;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class demoQAActionsMouseHover {
    private WebDriver driver;
    String URL = "https://demoqa.com/tool-tips";

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
        driver.get(URL);
    }

    @Test
    public void testMouseHoverMenu(){
        String URL2 = "https://demoqa.com/menu/";
        driver.get(URL2);

        WebElement menuTarget1 = driver.findElement(By.xpath("//a[.='Main Item 2']"));
        Actions action2 = new Actions(driver);
        action2.moveToElement(menuTarget1);
        action2.perform();

        WebElement menuTarget2 = driver.findElement(By.xpath("//a[.='SUB SUB LIST »']"));
        action2.moveToElement(menuTarget2);
        action2.perform();

        WebElement menuTarget3 = driver.findElement(By.xpath("//a[.='Sub Sub Item 2']"));
        action2.moveToElement(menuTarget3);
        action2.perform();

        menuTarget3.click();
        String expectedCurrentUrl = "https://demoqa.com/menu/#";
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("mismatched URL", expectedCurrentUrl, currentUrl);
        System.out.print(currentUrl);

    }
    @After
    public void tearDown(){
//        driver.quit();
    }
}