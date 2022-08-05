package WO10Modemy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.*;

public class connectWithDatabase {
    private WebDriver driver;

    String dbURL = "jdbc:oracle:thin:@10.144.10.24:1521/CBPEDUB";
    String dbUsername = "";
    String dbPassword = "";



    public connectWithDatabase() throws SQLException, ClassNotFoundException {

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection sql = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        Statement stmt = sql.createStatement();
        ResultSet result = stmt.executeQuery("SELECT * FROM ACQ_TASK at2 WHERE ERR_CODE IN (18, 19)");
        System.out.print(result.getInt());

    }

    @Before
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");// Bypass OS security model
        options.addArguments("--disable-dev-shm-usage");// overcome limited resource problems
        options.addArguments("ignore-certificate-errors");//self-described
        options.addArguments("ignore-ssl-errors");
        options.addArguments("--start-maximized");
        //options.addArguments("headless");//pozwala uruchamiac przegladarke w trybie non-GUI  ->  A headless browser is a browser simulation program that does not have a user interface.
        //PONIZSZY ARGUMENT URUCHAMIA uBLOCK ORIGIN
        options.addArguments("--load-extension=" + "C:\\Users\\Robert\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\cjpalhdlnbpafiamejdnhcphjbkeiagm\\1.43.0_49");

        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver(options);
    }
    @Test
    public void test(){

    }
    @After
    public void after(){
        driver.quit();
    }
}
