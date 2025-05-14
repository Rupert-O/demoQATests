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

import java.util.List;

import static org.junit.Assert.assertTrue;

public class demoQARadioButton {
    private static WebDriver driver;
    private static List<WebElement> radioButtons;
    String URL = "https://demoqa.com/radio-button";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");// Bypass OS security model
        options.addArguments("--disable-dev-shm-usage");// overcome limited resource problems
        options.addArguments("ignore-certificate-errors");//self-described
        options.addArguments("ignore-ssl-errors");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(URL);

        radioButtons = driver.findElements(By.className("custom-control-label"));
    }

    @Test
    public void radioButtonYES() {

    try{
        Thread.sleep(1000);
    }
    catch(InterruptedException e){
    }
        radioButtons.get(0).click();
        WebElement result1 = driver.findElement(By.className("mt-3"));
        boolean tip = radioButtons.get(0).isSelected();
        assertTrue("Result of 1st radio button click", tip);
//        assertTrue("Result of first radio button click", result1.isDisplayed());
    }


    @Test
    public void radioButtonImpressive(){

        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
        }
        radioButtons.get(1).click();
//        WebElement result1 = driver.findElement(By.className("mt-3"));
        System.out.print("2nd = " + radioButtons.get(1).isSelected());
        Assert.assertTrue("Result of 2nd radio button click", radioButtons.get(1).isSelected());

//        Assert.assertTrue("Result of first radio button click", result1.isDisplayed());
    }

    @Test
    public void radioButtonNo(){

        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
        }
        radioButtons.get(2).click();
//        WebElement result1 = driver.findElement(By.className("mt-3"));
        Assert.assertFalse("Result of 3rd radio button click", radioButtons.get(1).isSelected());
//        Assert.assertTrue("Result of first radio button click", result1.isDisplayed());
    }

    @After

    public void tearDown(){
//    driver.quit();
    }
}
