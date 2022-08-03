package WO10Modemy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.Robot;
import java.awt.event.KeyEvent;

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
    public void test(){
        Robot robot = new Robot(); //tworzymy obiekt robot z klasy robot

        String URL = "https://www.filemail.com/pl/share/upload-file";
        driver.get(URL);
        WebElement upload = driver.findElement(By.id("addBtn"));
        upload.click();
        //https://docs.oracle.com/javase/10/docs/api/java/awt/Robot.html
        robot.keyPress(KeyEvent.VK_4);


    }
    @After
    public void after(){
//        driver.quit;
    }
}
