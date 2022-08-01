package WO10Modemy;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class demoQAiFrames {
    private WebDriver driver;
    String URL = "https://demoqa.com/frames";

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
    public void test(){
        //WebElement iFrame1 = driver.findElement(By.id("frame1"));
        driver.switchTo().frame("frame1");//szuka po atrybucie ID lub name
        WebElement textIniFrame1 = driver.findElement(By.id("sampleHeading"));
        //przelaczenie sie z iFrane do okna glownego
        driver.switchTo().defaultContent();
        System.out.print(textIniFrame1.getText());
    }

    @Test
    public void nestedFrames(){
        String nestedFramesURL = "https://demoqa.com/nestedframes";
        driver.get(nestedFramesURL);
        //PRZELACZA SIE DO PARENT FRAME I WYSWIETLA W KONSOLI TEKST Z TEGO iFRAME
        driver.switchTo().frame("frame1");//szuka po atrybucie ID lub name
        WebElement textIniFrame1 = driver.findElement(By.tagName("body"));
        System.out.print(textIniFrame1.getText() + "\n");

        //PRZELACZA SIE DO CHILD FRAME I WYSWIETLA W KONSOLI TEKST Z TEGO iFRAME
//        WebElement<List> childiFramesList = driver.findElements(By.tagName("iframe"));
        driver.switchTo().frame(0);//szuka po kolejnosci ramek i przelacza sie do tej o kolejnosci =0
        WebElement textIniFrame2 = driver.findElement(By.tagName("p"));
        System.out.print(textIniFrame2.getText());

        // PRZELACZENIE SIE Z POWRTEM DO PARENT iFRAME
        driver.switchTo().parentFrame();

        //PRZELACZENIE SIE DO OKNA GLOWNEGO
        driver.switchTo().defaultContent();//przelacza do glownego okna, niezaleznie od tego w jak bardzo zagniezdzaonej ramce sie znajudejesz obecnie

    }

    @After
    public void tearDown(){
        driver.quit();
    }
}