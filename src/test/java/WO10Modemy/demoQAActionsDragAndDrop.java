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

public class demoQAActionsDragAndDrop {
    private WebDriver driver;
    String URL = "https://demoqa.com/droppable";

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
        driver.get(URL);
    }


    @Test
    public void testSimpleDragAndDrop() {
        WebElement draggableElement = driver.findElement(By.id("draggable"));
        WebElement dropBox = driver.findElement(By.id("droppable"));

        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
        }

        Actions action = new Actions(driver);
        action.dragAndDrop(draggableElement, dropBox).perform();

//        action.build();
//        action.perform();

        WebElement textFromDropBox = driver.findElement(By.xpath("//*[@id=\"droppable\"]/p"));
        System.out.print(textFromDropBox.getText());
        Assert.assertEquals("Dropped!", textFromDropBox.getText());

    }

        @Test
        public void testDragAndDropNotAceptable() {
        //TEN TEST NIE DZIALA POPRAWNIE!!!!
            //PRZEJSCIE DO ZAKLADKI "Accept"
            Actions action = new Actions(driver);
            WebElement tabAccept = driver.findElement(By.id("droppableExample-tab-accept"));
            action.click(tabAccept);
            action.perform();

            try{
                Thread.sleep(2000);
            }
            catch(InterruptedException e){
            }

            // IDENTYFIKACJA ELEMENTOW
            WebElement notAcceptableElement = driver.findElement(By.id("notAcceptable"));
            WebElement dropBox = driver.findElement(By.id("droppable"));

            //TEKST W DROPBOXIE PRZED TESTEM
            WebElement textFromDropBoxBeforeDrop = driver.findElement(By.xpath("//*[@id=\"droppable\"]/p"));
            System.out.print("przed: " + textFromDropBoxBeforeDrop.getText());

//            Actions action1 = new Actions(driver);
            action.moveToElement(notAcceptableElement);
            action.dragAndDrop(notAcceptableElement, dropBox);
            action.build();
            action.perform();


            WebElement textFromDropBoxAfterDrop = driver.findElement(By.xpath("//*[@id=\"droppable\"]/p"));
            System.out.print(textFromDropBoxAfterDrop.getText());
            Assert.assertEquals(textFromDropBoxBeforeDrop.getText(), textFromDropBoxAfterDrop.getText());

        }

    @Test
    public void testDragAndDropAceptable() {
        //TEN TEST NIE DZIALA POPRAWNIE!!!!
        //PRZEJSCIE DO ZAKLADKI "Accept"
        Actions action = new Actions(driver);
        WebElement tabAccept = driver.findElement(By.id("droppableExample-tab-accept"));
        action.click(tabAccept);
        action.perform();

        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
        }

        System.out.print("1\n");
        WebElement AcceptableElement = driver.findElement(By.id("acceptable"));
        WebElement dropBox = driver.findElement(By.id("droppable"));
        WebElement textFromDropBoxBeforeDrop = driver.findElement(By.xpath("//*[@id=\"droppable\"]/p"));
        System.out.print("przed: " + textFromDropBoxBeforeDrop.getText());
        action.dragAndDrop(AcceptableElement, dropBox);
        System.out.print("2\n");
        action.build();
        action.perform();

        WebElement textFromDropBoxAfterDrop = driver.findElement(By.xpath("//*[@id=\"droppable\"]/p"));
        System.out.print("3\n");
        System.out.print(textFromDropBoxAfterDrop.getText());
        Assert.assertEquals(textFromDropBoxBeforeDrop.getText(), textFromDropBoxAfterDrop.getText());

    }

    @Test
    public void testDragAndDropByXY() {
        //TEN TEST NIE DZIALA POPRAWNIE!!!! pozycja droboxa to x=0 i y=0 co jest falszem
        //PRZEJSCIE DO ZAKLADKI "Accept"
        Actions action = new Actions(driver);
        WebElement tabAccept = driver.findElement(By.id("droppableExample-tab-accept"));
        action.click(tabAccept);
        action.perform();

        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
        }
        WebElement AcceptableElement = driver.findElement(By.id("acceptable"));
        WebElement dropBox = driver.findElement(By.xpath("//*[@id=\"droppable\"]"));

        int DragMeX = AcceptableElement.getLocation().getX();
        int DragMeY = AcceptableElement.getLocation().getY();
        System.out.print("x= " + DragMeX + " y= " + DragMeY + "\n");
        int dropBoxX = dropBox.getLocation().getX();
        int dropBoxY = dropBox.getLocation().getY();
        System.out.print("x= " + dropBoxX + " y= " + dropBoxY + "\n");

        int offsetX = dropBoxX - DragMeX;
        int offsetY = dropBoxY - DragMeY;
        System.out.print("x= " + offsetX + " y= " +offsetY);
        action.dragAndDropBy(AcceptableElement, offsetX+10, offsetY+10).perform();

    }

    @After
    public void tearDown(){
//        driver.quit();
    }
}