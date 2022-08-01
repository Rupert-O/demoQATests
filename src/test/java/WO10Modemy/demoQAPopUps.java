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

public class demoQAPopUps {
    private WebDriver driver;
    String URL = "https://demoqa.com/alerts";

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

    // 1 w kolejności przycisk
    @Test
    public void test(){
        WebElement triggerButton1 = driver.findElement(By.id("alertButton"));
        triggerButton1.click();
        String alertText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        System.out.print("Zawartość alertu: " + alertText + "\n");
    }

    // 2 w kolejności przycisk
    @Test
    public void test2(){
        WebElement triggerButton2 = driver.findElement(By.id("timerAlertButton"));
        triggerButton2.click();
        new WebDriverWait(driver, 10)
        .ignoring(NoAlertPresentException.class)
        .until(ExpectedConditions.alertIsPresent());

        String alertText2 = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        System.out.print("Zawartość alertu nr 2: " + alertText2);
    }

    // 4 w kolejności przycisk
    @Test
    public void test3(){
        WebElement promptButton1 = driver.findElement(By.id("promtButton"));
        promptButton1.click();
        String alertText3 = driver.switchTo().alert().getText();
        driver.switchTo().alert().sendKeys("Johnny Johnny");
        driver.switchTo().alert().accept();
        System.out.print("Zawartość alertu nr 2: " + alertText3 + "\n");
        WebElement enteredText = driver.findElement(By.id("promptResult"));
        String enteredTextShortened = enteredText.getText().substring(12);//przycina string - zapisuje wszystko od pozycji 12 do końca
        System.out.print("Wprowadzony tekst: " + enteredTextShortened);
    }

    // 3 w kolejności przycisk
    @Test
    public void test4(){
        WebElement promptButton1 = driver.findElement(By.id("confirmButton"));
        promptButton1.click();
        String alertText4 = driver.switchTo().alert().getText();
        driver.switchTo().alert().dismiss();
        System.out.print("Zawartość alertu nr 4: " + alertText4 + "\n");
        WebElement confirmResult = driver.findElement(By.id("confirmResult"));
        System.out.print("Wprowadzony tekst: " + confirmResult.getText());
        Assert.assertEquals("Expected result doesn't match to actual result","You selected OK", confirmResult.getText());
    }

    @After
    public void tearDown(){
//        driver.quit();
    }
}