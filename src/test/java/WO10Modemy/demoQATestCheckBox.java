package WO10Modemy;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class demoQATestCheckBox {
    private WebDriver driver;
    String URL = "https://demoqa.com/checkbox";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");// Bypass OS security model
        options.addArguments("--disable-dev-shm-usage");// overcome limited resource problems
        options.addArguments("ignore-certificate-errors");//self-described
        options.addArguments("ignore-ssl-errors");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @Test
    public void checkBoxTest() {
        //.isDisplayed
        WebElement expandAllButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div/div/button[1]"));
        boolean status = expandAllButton.isDisplayed();
        System.out.print(status + "\n");
        //.getSize
        Dimension dimension = expandAllButton.getSize();
        System.out.print("Button height: " + dimension.height + "\nButton width: " + dimension.width+ "\n");
        //.getText
        WebElement checkText = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[1]/span"));
        String text = checkText.getText();
        System.out.print(text);

        expandAllButton.click();

        List<WebElement> list = driver.findElements(By.className("rct-checkbox"));
//        List<WebElement> list = driver.findElements(By.className("rct-text"));
        System.out.print("\nNumber of list elements: "+list.size());
        list.get(2).click();

        List<WebElement> list2 = driver.findElements(By.cssSelector("[class^='rct-check']"));
        System.out.print("\nNumber of list2 elements: "+list2.size());

    }

    @After
    public void assertTrue(){
        Boolean result = driver.findElement(By.id("result")).isDisplayed();
        Assert.assertTrue("Result box is visible: ", result);
    }
    public void tearDown() throws Exception {
        // Zamknij przeglądarkę
//      driver.quit;
    }
}
