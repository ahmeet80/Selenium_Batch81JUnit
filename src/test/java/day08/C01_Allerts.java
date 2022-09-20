package day08;

import com.google.j2objc.annotations.Weak;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_Allerts {
    /*
   - https://the-internet.herokuapp.com/javascript_alerts adresini gidelim
   - click for JS Alert butonuna tıklayalım
   - Tıkladiktan sonra cşkan uyari mesajina (alerte) tamam diyelim
     */

    WebDriver driver;

    Select select;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void tearDown(){
        //driver.close();
    }
    @Test
    public void test1() throws InterruptedException {
        //- https://the-internet.herokuapp.com/javascript_alerts adresini gidelim
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //- click for JS Alert butonuna tıklayalım
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        //- Tıkladiktan sonra cikan uyari mesajina (alerte) tamam diyelim
        Thread.sleep(3000);
        driver.switchTo().alert().accept(); // switchTo() ile locatesiz islem yapiyoruz
    }
}
