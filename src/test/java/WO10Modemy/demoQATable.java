package WO10Modemy;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class demoQATable {
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
        Integer tRow = 1;
        Integer tColumn = 1;
        List<WebElement> allRows;
        do {
            allRows = driver.findElements(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[" + tRow + "]/div/div[" + tColumn + "]"));
//            System.out.print("number of rows in table " + allRows.size() + "\n");
            System.out.print("content of cell: " + allRows.get(0).getText() + "\n");
            tRow++;
        }while(allRows.get(0).getText() != " ");
    }
    @Test
    public void test2(){
        String URL2 = "https://stackoverflow.com/questions/3815173/increment-a-integers-int-value";
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
