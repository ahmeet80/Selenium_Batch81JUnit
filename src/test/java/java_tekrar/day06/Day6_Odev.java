package java_tekrar.day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.xml.transform.sax.SAXResult;
import java.time.Duration;

public class Day6_Odev {
    /*
    1.Bir Class olusturalimYanlisEmailTesti
    2.http://automationpractice.com/index.php sayfasinagidelim
    3.Sign in butonunabasalim
    4.Email kutusuna @isareti olmayan bir mail yazipenter’a
      bastigimizda “Invalid email address” uyarisi ciktigini testedelim
    */
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown(){
        //driver.close();
    }

    @Test
    public void test1(){
        //http://automationpractice.com/index.php sayfasinagidelim
        driver.get("http://automationpractice.com/index.php");

        //Sign in butonunabasalim
        WebElement signIn = driver.findElement(By.xpath("//*[@class='login']"));
        signIn.click();

        //Email kutusuna @isareti olmayan bir mail yazip enter’a
        //bastigimizda “Invalid email address” uyarisi ciktigini testedelim
        WebElement emailBox = driver.findElement(By.xpath("//*[@id='email_create']"));
        emailBox.sendKeys("ahmeet80gmail", Keys.ENTER);
        WebElement hata = driver.findElement(By.xpath("//*[text()='Invalid email address.']"));
        System.out.println(hata.getText());
        String expectedText = "Invalid email address.";
        String actualText = hata.getText();
        Assert.assertEquals(expectedText,actualText);



    }
}
