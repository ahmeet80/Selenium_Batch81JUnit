package day09_Iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_WindowHandle {
    //1- Amazon Sayfasina girelim
    //2- Url'nin amazon içerdiğini test edelim
    //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
    //4- title'in BestBuy içerdiğini test edelim
    //5- İlk sayfaya dönüp sayfada java aratalım
    //6- Arama sonuclarının java içerdiğini test edelim
    //7- Yeniden bestbuy sayfasına gidelim
    //8- Logonun görünürlüğünü test edelim
    //9- Sayfaları Kapatalım

    WebDriver driver;


    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        //driver.close();
    }

    @Test
    public void test1() throws InterruptedException {
        //1- Amazon Sayfasina girelim
        driver.get("https://amazon.com");
        String amazonWindowHandle = driver.getWindowHandle();
        /*
    Eğer bize verilen task'te sayfalar arası geçiş varsa her driver.get() methodundan sonra
    driver'ın window handle değerini string bir değişkene atarız
    Sonrasında farklı bir sayfaya ya da sekmeye gittikten sonra tekrar ilk sayfaya dönmemiz istenirse
    String değişkene atadığımız window handle değerleriyle sayfalar arası geçiş yapabiliriz
      */
        //2- Url'nin "amazon" içerdiğini test edelim
        String expectedUrl = "amazon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));


        //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        driver.switchTo().newWindow(WindowType.WINDOW); // Yeni bir pencere açmak için bu methodu kullanırız
        driver.get("https://www.bestbuy.com");
        String bestbuyWindowHandle = driver.getWindowHandle();

        //4- title'in "BestBuy" içerdiğini test edelim
        String expectedTittle = "Best Buy";
        String actualTittle = driver.getTitle();
        Assert.assertTrue(actualTittle.contains(expectedTittle));

        //5- İlk sayfaya dönüp sayfada "java" aratalım
        driver.switchTo().window(amazonWindowHandle); // Sayfalar arası geçiş için bu method kullanılır
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("java", Keys.ENTER);

        //6- Arama sonuclarının java içerdiğini test edelim
        WebElement aramaSonucu = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String ecxpectedArananKelime = "java";
        String actualSonuc = aramaSonucu.getText();
        Assert.assertTrue(actualSonuc.contains(ecxpectedArananKelime));

        //7- Yeniden bestbuy sayfasına gidelim
        driver.switchTo().window(bestbuyWindowHandle);

        //8- Logonun görünürlüğünü test edelim
        WebElement bestbuyLogo = driver.findElement(By.xpath("(//*[@class='logo'])[1]"));
        Assert.assertTrue(bestbuyLogo.isDisplayed());

        //9- Sayfaları Kapatalım
        driver.quit();


    }

}
