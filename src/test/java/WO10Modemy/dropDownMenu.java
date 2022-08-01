package WO10Modemy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class dropDownMenu {
    private WebDriver driver;
    String URL = "https://demoqa.com/select-menu";

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
    public void singleSelectMenu(){
        Select select = new Select(driver.findElement(By.id("oldSelectMenu")));
        select.selectByIndex(4);
        System.out.print("Options choosed by selenium test = " + select.getFirstSelectedOption().getText() + "\n");

        //List all of options of single select menu
        List<WebElement> availableOptions = select.getOptions();
        System.out.print(availableOptions.get(1).getText());
        int i;
        for (i = 0; i<availableOptions.size(); i++)//size podaje liczbe elementow w liscie, elementy sa numerowane od 0 do n wiec n = .size()-1
        {
            System.out.print(availableOptions.get(i).getText() + "\n");
        }

        //Count number of options
        System.out.print("Number of available options: " + availableOptions.size());
            }
    @Test
    public void multiSelectMenu(){
        Select select1 = new Select(driver.findElement(By.id("cars")));
        if(select1.isMultiple()){
            select1.selectByIndex(0);
            select1.selectByIndex(3);
        }

        System.out.print("Options choosed by selenium test = ");
        List<WebElement> lista = select1.getAllSelectedOptions();
        int i;
        for(i=0; i<lista.size(); i++)
        {
            System.out.print(lista.get(i).getText() + ", ");
        }
    }

    @After
    public void tearDown(){
//        driver.quit();
    }
}
