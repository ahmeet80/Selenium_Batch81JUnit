package java_tekrar.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_DropDownHandle {
    /*
    ●Bir class oluşturun:C3_DropDownAmazon
    ●https://www.amazon.com/ adresinegidin.
    -Test1
    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
    oldugunu testedin
    -Test2
    1.Kategori menusunden Books seceneginisecin
    2.Arama kutusuna Java yazin ve aratin
    3.Bulunan sonuc sayisiniyazdirin
    4.Sonucun Java kelimesini icerdigini testedin
    */

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }

    @After
    public void tearDOwn(){
        //driver.close();
    }

    @Test
    public void test(){
    //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu testedin(yani, 45 olmadıgını)

        List<WebElement> drops = driver.findElements(By.xpath("//*[@class='nav-search-scope nav-sprite']"));
        System.out.println(drops.size());
        int expectedDdlSize = 28;
        int actualDdlSize = drops.size();
        Assert.assertNotEquals(expectedDdlSize,actualDdlSize);
    }

    @Test
    public void test2(){
    // 1.Kategori menusunden Books seceneginisecin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        ddm.sendKeys("Books");

    //    2.Arama kutusuna Java yazin ve aratin
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java",Keys.ENTER);
    //    3.Bulunan sonuc sayisini yazdirin
        WebElement resultText = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String resultTextSentence = resultText.getText();
        String [] resultTextSentenceSplitWord = resultTextSentence.split(" ");
        String resultTextNumber = resultTextSentenceSplitWord[3];
        System.out.println(resultTextNumber);

        //    4.Sonucun Java kelimesini icerdigini testedin
        String expectedKelime = "Java";
        String actualSonucYazisi = resultText.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));

    }
}
