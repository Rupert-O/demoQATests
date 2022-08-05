package WO10Modemy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class demoQAActionsSlider {
    private WebDriver driver;
    String URL = "https://demoqa.com/slider/";

    @Before
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");// Bypass OS security model
        options.addArguments("--disable-dev-shm-usage");// overcome limited resource problems
        options.addArguments("ignore-certificate-errors");//self-described
        options.addArguments("ignore-ssl-errors");
        options.addArguments("--start-maximized");
        options.addArguments("headless");//pozwala uruchamiac przegladarke w trybie non-GUI  ->  A headless browser is a browser simulation program that does not have a user interface.
        //PONIZSZY ARGUMENT URUCHAMIA uBLOCK ORIGIN
        options.addArguments("--load-extension=" + "C:\\Users\\Robert\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\cjpalhdlnbpafiamejdnhcphjbkeiagm\\1.43.0_49");

        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver(options);
//      driver.manage().window().maximize();
        driver.get(URL);
    }


    @Test
    public void testMouseHoverSlider(){
        WebElement slider = driver.findElement(By.xpath("//input[@class='range-slider range-slider--primary']"));
        WebElement sliderValue = driver.findElement(By.id("sliderValue"));

        int x = slider.getLocation().getX();
        int y = slider.getLocation().getY();
        System.out.print("x: " + x + "\n" + "y: " + y + "\n" + "Slider value: " + sliderValue.getAttribute("value"));

        Actions action = new Actions(driver);
        //MoveToElement(IWebElement, Int32, Int32)	Moves the mouse to the specified offset
        // of the top-left corner of the specified element. Find top left corner of webelemnt and move cursor acooridngly to offset
        action.moveToElement(sliderValue,150,0).perform();
        slider.click();

        x = slider.getLocation().getX();
        y = slider.getLocation().getY();
        System.out.print("\nAfter performing action:\n" + "x: " + x + "\n" + "y: " + y + "\n" + "Slider value: " + sliderValue.getAttribute("value"));

    }
    @After
    public void tearDown(){
//        driver.quit();
    }
}