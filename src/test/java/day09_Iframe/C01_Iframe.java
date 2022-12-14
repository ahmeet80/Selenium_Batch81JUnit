package day09_Iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Iframe {
    /*
    ●https://the-internet.herokuapp.com/iframe adresinegidin.
     ●Bir metod olusturun:iframeTest
     ○“An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.○Text Box’a “Merhaba Dunya!”yazin.
     ○TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve konsoldayazdirin.
    */

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
    //●Bir metod olusturun:iframeTest
    public void test1() throws InterruptedException {
     //●https://the-internet.herokuapp.com/iframe adresinegidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

     //“An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement iFrameYazisi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(iFrameYazisi.isDisplayed());
        System.out.println(iFrameYazisi.getText());

        //Text Box’a “Merhaba Dunya!”yazin.
        WebElement textBox = driver.findElement(By.xpath("//*[@id='mce_0_ifr']")); // Frame'e geçiş yapmadan önce orayı id ile locate ederiz
        driver.switchTo().frame(textBox); //Locate ettiğimiz frame geçmek için bu methodu kullanırız
        WebElement textBoxFrame = driver.findElement(By.xpath("//p"));
        textBoxFrame.clear(); // Clear methodu text box'ın içini temizler
        Thread.sleep(2000);
        textBoxFrame.sendKeys("Merhaba Dunya!");

        //       ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        //         dogrulayin ve konsolda yazdirin
        driver.switchTo().defaultContent(); // Iframe'den çıkıp ana sayfaya geçmek için bu method kullanılır
        WebElement elemantal = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(elemantal.isDisplayed());
        System.out.println(elemantal.getText());


    }
}
