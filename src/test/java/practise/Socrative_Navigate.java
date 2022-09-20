package practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.pqc.jcajce.provider.QTESLA;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Socrative_Navigate {
    //https://api.socrative.com/rc/Aquv3u
    // Room name: MURAT4738
    // Enter your name : istediginiz ismi giriniz
    // Socrativi sonuna kadar surdurup bitiren test hotasyonunu yazınız

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown(){
        //driver.close();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://api.socrative.com/rc/Aquv3u");

        WebElement roomName = driver.findElement(By.xpath("//*[@id='studentRoomName']"));  // Room Name
        roomName.click();
        roomName.sendKeys("MURAT4738",Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='studentLoginButton']")).click();

        WebElement enterYourName = driver.findElement(By.xpath("//*[@class='button button-primary button-large action-button']")); // Enter your name
        enterYourName.click();
        enterYourName.sendKeys("AhmetK");
        //driver.findElement(By.xpath("//*[@id='studentLoginButton']")).click(); // Student Login Join


        //WebElement secenekSeciciB = driver.findElement(By.xpath("(//*[@class='answer-option-letter'])[2]"));

    }
}
// (//*[@class='answer-option-letter'])[2]  B secenekler