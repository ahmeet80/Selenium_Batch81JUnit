package java_tekrar.day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeClassAfterClass {
    /*
    BeforeClass ve AfterClass notasyonları kullanıyorsak oluşturacağımız method'u static yapmamız gerekiyor
     */
    static WebDriver driver;
    @BeforeClass // beforeclass-afterclass kullanirsak ayni browserda islem yaapar once beforeclass calisir arada 3 method calisir en son afterclass calisir. Toplam da 5 method calisir
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    @Ignore
    /*
     Çalışmasını istemediğimiz test için @Ignore notasyonu kullanılır
     */
    public void method1() throws InterruptedException {
        Thread.sleep(1000);
        driver.get("https://amazon.com");
    }

    @Test

    public void method2(){

        driver.get("https://techproeducation.com");
    }

    @Test
    public void method3(){
        driver.get("https://hepsiburada.com");
    }
}
