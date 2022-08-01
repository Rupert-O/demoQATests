package WO10Modemy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class demoQAWindow {
    private WebDriver driver;
    String URL = "https://demoqa.com/browser-windows";

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
    WebElement NewWindowButton = driver.findElement(By.id("windowButton"));
    NewWindowButton.click();

    //WYSWIETAL  ID OKNA 'PARENT'
    String parentWindow = driver.getWindowHandle();
    System.out.print("ID of parent window: " + parentWindow + "\n");

    //WYSWIETAL  IDiki WSZYSTKICH OKIEN PRZEGLADARKI
    Set<String> allWindowHandles = driver.getWindowHandles();
    System.out.print("IDs of all chrome windows: " + allWindowHandles + "\n");

    Iterator iterator = allWindowHandles.iterator();

    while (iterator.hasNext()){
        String currentIterator = String.valueOf(iterator.next());
        if (!parentWindow.equalsIgnoreCase(currentIterator)){//sprawdza czy handler z tej iteracji jest taki sam jak handler okna parent, jeslli nie (czyli mamy handler okna child) wykonywany jest kod IFa
        System.out.print("ID of child window: " + currentIterator + "\n");

        driver.switchTo().window(currentIterator);
        WebElement content = driver.findElement(By.id("sampleHeading"));
        System.out.print(content.getText());
            }
        }
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}