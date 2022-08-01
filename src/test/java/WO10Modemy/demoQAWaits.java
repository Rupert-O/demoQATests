package WO10Modemy;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class demoQAWaits {
    private WebDriver driver;
    String URL = "https://demoqa.com/webtables";

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
        WebElement AddButton = driver.findElement(By.id("addNewRecordButton"));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        AddButton.click();

    }
    @Test
    public void test1(){
        driver.get("https://demoqa.com/broken");

//      Skroluje o 500 piksel w dol
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
//
        driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(10)));

        WebElement BrokenLink = driver.findElement(By.xpath("//a[.='Click Here for Broken Link']"));
        BrokenLink.click();

    }
    @After
    public void tearDown(){
//        driver.quit();
    }
}
