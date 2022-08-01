package WO10Modemy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class allLinksOnWebpage {

    private WebDriver driver;
    String URL2 = "https://stackoverflow.com/questions/3815173/increment-a-integers-int-value";

    @Before
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");// Bypass OS security model
        options.addArguments("--disable-dev-shm-usage");// overcome limited resource problems
        options.addArguments("ignore-certificate-errors");//self-described
        options.addArguments("ignore-ssl-errors");
        options.addArguments("--headless");//run test without opening browser window

        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(URL2);
    }

    @Test
    public void test(){
        driver.get(URL2);
        List<WebElement> linki = driver.findElements(By.tagName("a"));
        System.out.print(linki.size());

        for (int i = 0; i< linki.size(); i++) {
            System.out.print("\n" + i + ". " + linki.get(i).getText() + " " + linki.get(i).getAttribute("href"));
        }
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
