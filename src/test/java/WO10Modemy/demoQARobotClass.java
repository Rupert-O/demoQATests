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

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class demoQARobotClass {

    private WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");// Bypass OS security model
        options.addArguments("--disable-dev-shm-usage");// overcome limited resource problems
        options.addArguments("ignore-certificate-errors");//self-described
        options.addArguments("ignore-ssl-errors");
        options.addArguments("--start-maximized");
        //PONIZSZY ARGUMENT URUCHAMIA uBLOCK ORIGIN
        options.addArguments("--load-extension=" + "C:\\Users\\Robert\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\cjpalhdlnbpafiamejdnhcphjbkeiagm\\1.43.0_49");

        driver = new ChromeDriver(options);

    }
    @Test
    public void test() throws AWTException, InterruptedException {
        Robot robot = new Robot(); //tworzymy obiekt robot z klasy robot

        String URL = "https://www.filemail.com/pl/share/upload-file";
        driver.get(URL);
        WebElement upload = driver.findElement(By.id("addBtn"));
        upload.click();
        //https://docs.oracle.com/javase/10/docs/api/java/awt/Robot.html
        try{
            Thread.sleep(1000);
            }
        catch(InterruptedException e){
            }

        robot.keyPress(KeyEvent.VK_4);

        try{
            Thread.sleep(1000);
            }
        catch(InterruptedException e){
            }

        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        //Even though Robot class specifies to follow keyRelease for each keyPress event, Alphabets and numbers don't have any side effects on the next statements.
        //On the other hand, all the modifier keys such as SHIFT, ALT, etc. will always have a side effect on the next statements. As a result, it is still mandatory to specify keyRelease for each keyPress event of the modifier keys.
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
        }

        WebElement t = driver.findElement(By.xpath("//div[@class='name-holder ng-binding']"));
        Assert.assertEquals("File name mismatched", "43508899.txt", t.getText());
//        System.out.print(t.getText());

    }
    @After
    public void after(){
//        driver.quit;
    }
}
