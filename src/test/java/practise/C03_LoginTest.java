package practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_LoginTest {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void test01(){
        // 1) https://www.koalaresorthotels.com/ sayfasina gidiniz
        driver.get("https://www.koalaresorthotels.com");
        // 2)   Login butonuna tikla
        driver.findElement(By.xpath("(//*[@class='nav-link'])[7]")).click();
        // 3) Login ekraaninda olundugunu 4 farkli WebElement kullanarak test ediniz

        // I)
        Assert.assertTrue(driver.getTitle().contains("Log in"));

        // II)
        String expectedUrl = "https://www.koalaresorthotels.com/Account/Logon";
        String actualdUrl = driver.getCurrentUrl();
        Assert.assertEquals("Login Ekranina Giris Yapilmadi",expectedUrl,actualdUrl);

        // III)
        WebElement L3=driver.findElement(By.xpath("//*[@id='btnSubmit']"));
        Assert.assertTrue(L3.isDisplayed());


        // IV)
        Assert.assertTrue("URL Yanlis", driver.getCurrentUrl().contains("Logon"));

    }





}
