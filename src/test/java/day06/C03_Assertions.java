package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertions {
    /*
   1) Bir class oluşturun: BestBuyAssertions
   2) https://www.bestbuy.com/ Adresine gidin farkli test method'lari olusturarak asagidaki
   testleri yapin
        ○ Sayfa URL'inin https://www.bestbuy.com/ 'a esit oldugunu test edin
        ○ titleTest => Sayfa başlığının "Rest" içermediğini(contains) test edin
        ○ logoTest => BestBuy logosunun görüntülendigini test edin
        ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
    */
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bestbuy.com/");
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void test1(){
        //○ Sayfa URL'inin https://www.bestbuy.com/ 'a esit oldugunu test edin
        String expecteURL="https://www.bestbuy.com/";
        String actualURL=driver.getCurrentUrl();
        Assert.assertEquals(expecteURL,actualURL);
    }
    @Test
    public void test2() throws InterruptedException {
        //○ titleTest => Sayfa başlığının "Rest" içermediğini(contains) test edin
        String expecteURL="Rest";
        String actualURL=driver.getTitle();
        Thread.sleep(2000);
        Assert.assertFalse(actualURL.contains(expecteURL));

    }
    @Test
    public void test3(){
        //○ logoTest => BestBuy logosunun görüntülendigini test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='logo']")).isDisplayed());
    }
    @Test
    public void test4(){
        //○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@lang='fr']")).isDisplayed());

    }


}