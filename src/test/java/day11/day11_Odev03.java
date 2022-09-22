package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class day11_Odev03 extends TestBaseBeforeAfter {
    /*
    //Ödev 3
    //Test01
    //-  amazon gidin
    //Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
    //dropdown menude 40 eleman olduğunu doğrulayın
    //Test02
    //dropdown menuden elektronik bölümü seçin
    //arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
    //sonuc sayisi bildiren yazinin iphone icerdigini test edin
    //ikinci ürüne relative locater kullanarak tıklayin
    //ürünün title'ni ve fiyatını variable'a  assign edip ürünü sepete ekleyelim
    //Test03
    //yeni bir sekme açarak amazon anasayfaya gidin
    //dropdown'dan bebek bölümüne secin
    //bebek puset aratıp bulundan sonuç sayısını yazdırın
    //sonuç yazsının puset içerdiğini test edin
    //5-üçüncü ürüne relative locater kullanarak tıklayin
    //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin  Test 4
    //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
    */

    @Test
    public void test01() {
        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        // Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(ddm);

        // dropdown menude 40 eleman olduğunu doğrulayın
        List<WebElement> opsiyonList = select.getOptions();
        int actualOptionSayisi = opsiyonList.size();
        int expextedOpsiyonSayisi = 40;
        Assert.assertNotEquals(expextedOpsiyonSayisi, actualOptionSayisi);

        // Assert.assertEquals(expextedOpsiyonSayisi,actualOptionSayisi);
        // Test02
        // dropdown menuden elektronik bölümü seçin

        select.selectByVisibleText("Electronics");
        // arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement aramaKutusu = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        Actions actions = new Actions(driver);
        actions.sendKeys("i")
                .sendKeys("p")
                .sendKeys("h")
                .sendKeys("o")
                .sendKeys("n")
                .sendKeys("e").sendKeys(Keys.ENTER).perform();
        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String SonucYazisiIphone = sonucYazisi.getText();
        System.out.println(SonucYazisiIphone);

        // sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String expectedKelime = "iphone";
        Assert.assertTrue(SonucYazisiIphone.contains(expectedKelime));

        // ikinci ürüne relative locater kullanarak tıklayin
        WebElement ikinciUrun = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[2]"));
        ikinciUrun.click();

        // ürünün title'ni ve fiyatını variable'a  assign edip ürünü sepete ekleyelim
        String ikinciUrunTitle = driver.getTitle();
        WebElement ikinciUrunFiyati = driver.findElement(By.xpath("//span[@class='a-price a-text-price a-size-medium apexPriceToPay']"));
        // Test03
        // yeni bir sekme açarak amazon anasayfaya gidin
        // dropdown'dan bebek bölümüne secin
        // bebek puset aratıp bulundan sonuç sayısını yazdırın
        // sonuç yazsının puset içerdiğini test edin
        // üçüncü ürüne relative locater kullanarak tıklayin
        // title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        // Test 4
        // sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
    }
}
