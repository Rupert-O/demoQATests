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
import java.awt.event.InputEvent;

public class demoQARobotClassMouseEvents {

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
        String URL = "https://www.filemail.com/pl/share/upload-file";
        driver.get(URL);
        WebElement sendAsEmail = driver.findElement(By.cssSelector(".up-tab-email"));
        Integer x = sendAsEmail.getLocation().getX();
        Integer y = sendAsEmail.getLocation().getY();
        System.out.print("x= " + x + "\ny= " + y);


        Robot robot = new Robot();
        robot.mouseMove(x+100, y+250);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        WebElement email = driver.findElement(By.className("tagit-new"));
        Boolean result = email.isDisplayed();

        System.out.print("\n" + result);
        Assert.assertTrue("wysylanie jako email nie wyswietlilo sie", result);

    }

    @After
    public void after() {
//        driver.quit;
    }
}
