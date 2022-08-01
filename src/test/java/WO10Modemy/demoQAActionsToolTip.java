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
import org.openqa.selenium.interactions.Actions;

public class demoQAActionsToolTip {
    private WebDriver driver;

    @Before
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");// Bypass OS security model
        options.addArguments("--disable-dev-shm-usage");// overcome limited resource problems
        options.addArguments("ignore-certificate-errors");//self-described
        options.addArguments("ignore-ssl-errors");
        options.addArguments("--start-maximized");
        //PONIZSZY ARGUMENT URUCHAMIA uBLOCK ORIGIN
        options.addArguments("--load-extension=" + "C:\\Users\\Robert\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\cjpalhdlnbpafiamejdnhcphjbkeiagm\\1.43.0_49");

        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver(options);
//      driver.manage().window().maximize();

    }


    @Test
    public void testToolTipAsAttribute() {
        String URL = "https://www.google.com/search?q=gg&source=hp&ei=kxjcYtyAIdTBxc8Pidmn2AQ&iflsig=AJiK0e8AAAAAYtwmo5L0_Ylnl2M6QYu1enOEonWfRiGZ&ved=0ahUKEwicloWwro_5AhXUYPEDHYnsCUsQ4dUDCAc&uact=5&oq=gg&gs_lcp=Cgdnd3Mtd2l6EAMyCwgAEIAEELEDEIMBMggIABCABBCxAzILCAAQgAQQsQMQgwEyCwgAEIAEELEDEIMBMhEILhCABBCxAxDHARCvARDUAjIICAAQgAQQsQMyCAgAEIAEELEDMgsILhCABBCxAxDUAjILCAAQgAQQsQMQgwEyBQgAEIAEOhEILhCABBCxAxCDARDHARDRAzoICC4QsQMQgwFQAFh8YIQIaABwAHgAgAFaiAGcAZIBATKYAQCgAQE&sclient=gws-wiz";
        driver.get(URL);
        WebElement googleToolTip = driver.findElement(By.id("logo"));
        String toolTip = googleToolTip.getAttribute("title");
        String expectedValue = "Przejdź do strony głównej Google";
        Assert.assertEquals("mismatched logo tooltip", expectedValue, toolTip);
        System.out.print("zawartość tooltipa: " + toolTip);

    }
    @Test
    public void testToolTipAsDiv() {
        String URL = "https://demoqa.com/tool-tips";
        driver.get(URL);
        WebElement object = driver.findElement(By.id("toolTipButton"));
        Actions actions = new Actions(driver);
        actions.moveToElement(object).perform();
        //oczekiwanie na wyswietlenie tolltipa
        try{
            Thread.sleep(4000);
        }
        catch(InterruptedException e){
        }

        WebElement tooltip = driver.findElement(By.xpath("//div[@class='tooltip-inner']"));
        System.out.print(tooltip.getText());
        String expectedToolTipText = "You hovered over the Button";
        Assert.assertEquals("mismatched tooltip content", expectedToolTipText, tooltip.getText());

    }

    @After
public void after (){
//    driver.quit();
    }
}