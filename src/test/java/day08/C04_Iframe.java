package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C04_Iframe {
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
        // https://html.com/tags/iframe/ adresine gidiniz
        driver.get("https://html.com/tags/iframe/");
         /*
        Bir web sitesinde bir video(youtube vb.) varsa <iframe> tag'ı içerisindeyse bu video'yu direk locate edip
        çalıştırmak dinamik olmaz çünkü link değişebilir ve locate'imiz çalışmaz.
        Bunun için bütün frame'leri bir array liste atıp index ile frame'i seçip sonrasında play tuşunu locate edip
        çalıştırabiliriz.
        */
        // YouTube videosunu calistiriniz
        List<WebElement> iFramesList = new ArrayList<>(driver.findElements(By.xpath("//iframe")));
        driver.switchTo().frame(iFramesList.get(0));
        WebElement youtubePlayButton = driver.findElement(By.xpath("//*[@aria-label=\"Oynat\"]"));
        youtubePlayButton.click();

    }
}
