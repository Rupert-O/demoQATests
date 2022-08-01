package WO10Modemy;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.UUID;
import java.util.concurrent.TimeUnit;


public class AddingNewModem {
    private WebDriver driver;
    String meterModemsUrl = "https://10.1.11.198/ami/AppBase.go#/meterModems";

    @Before
    public void setUp() {
        // Uruchom nowy egzemplarz przeglądarki Chrome
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");// Bypass OS security model
        options.addArguments("--disable-dev-shm-usage");// overcome limited resource problems
        options.addArguments("ignore-certificate-errors");//self-described
        options.addArguments("ignore-ssl-errors");
//        options.addArguments("--headless");
//        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application");  //chrome binary location specified here
//        options.addArguments("start-maximized");
//        options.addArguments("disable-infobars");
//        options.addArguments("--disable-extensions");
//        options.addArguments("--disable-gpu");
//        options.setExperimentalOption("useAutomationExtension", false);

        driver = new ChromeDriver(options);

        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();

//    }
//    @Test
//    public void logIn() {

        driver.get("https://10.1.11.198/ami/MainLogin.l4d");
        WebElement login;
        login = driver.findElement(By.id("j_username"));
        login.sendKeys("01Z00351");

        WebElement password = driver.findElement(By.name("j_password"));
        password.sendKeys("energa2!");

        WebElement logInButton = driver.findElement(By.id("submitBtn"));
        logInButton.click();

        // Przejdź do Modemy
        driver.get(meterModemsUrl);
//        String targetURl = driver.getCurrentUrl();
//        Assertions.assertEquals(targetURl, "https://10.1.11.198/ami/PpeList.go");
    }
    @Test
    public void firstTest() {
        // Znajdź element wprowadzania tekstu na podstawie jego nazwy
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException e){

        }
        WebElement gear = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[1]/div/div/div/div[1]/div[1]"));
        gear.click();
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){

        }
        WebElement DodajButton = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]"));
        DodajButton.click();

        UUID uuid = UUID.randomUUID();

        WebElement ModemNameInput = driver.findElement(By.id("concentratorName"));
        WebElement ModemSerialNumber = driver.findElement(By.id("concentratorSerialNumber"));
        WebElement ModemModel = driver.findElement(By.id("concentratorModel"));

        ModemNameInput.clear();
        ModemNameInput.sendKeys("Selenium Test Modem "+uuid);

        ModemSerialNumber.clear();
        ModemSerialNumber.sendKeys(""+uuid);

        ModemModel.click();
//        // Wyczyść teskst zapisany w elemencie
//        element.clear();
//
//        // Wpisz informacje do wyszukania
//        element.sendKeys("Testowanie Selenium WebDriver");
//
//        // Prześlij formularz
//        element.submit();
    }
    @After
    public void tearDown() throws Exception {
        // Zamknij przeglądarkę
        // It's always recommendable to use the quit() method as it releases the driver.
//        driver.quit();
    }
}
