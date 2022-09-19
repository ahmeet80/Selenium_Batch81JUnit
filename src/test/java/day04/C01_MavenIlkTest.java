package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        /*
       1- https://www.amazon.com/ sayfasina gidelim
       2- arama kutusunu locate edelim
       3- “Samsung headphones” ile arama yapalim
       4- Bulunan sonuc sayisini yazdiralim
       5- Ilk urunu tiklayalim
       6- Sayfadaki tum basliklari yazdiralim
     */
        // 1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com");

        // 2- arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        Thread.sleep(2000);
        // 3- “Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones"+ Keys.ENTER);
        // 4- Bulunan sonuc sayisini yazdiralim
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(sonucYazisi.getText());
        String[] sonucYazisiArr = sonucYazisi.getText().split(" "); // sonucYazisiArr Array'ine sonuc cumlesinin kelimeleri tek tek atıldı
        System.out.println("\"Samsung headphones\" aramasi sonucunda sonuc : " + sonucYazisiArr[2]);
        Thread.sleep(2000);
        // 5- Ilk urunu tiklayalim
        WebElement ilkUrun = driver.findElement(By.xpath("//*[@class='a-section aok-relative s-image-fixed-height']"));
        ilkUrun.click();
        // 6- Sayfadaki tum basliklari yazdiralim

        // System.out.println(driver.findElement(By.xpath("//h1")).getText()); //Hocaninki

        for (int i = 1; i <=6 ; i++) {
            List<WebElement> basliklar=driver.findElements(By.tagName("h"+i));
            basliklar.stream().forEach(t-> System.out.println(t.getText()));
        }

        driver.close();

    }

}

