package java_tekrar.day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C02_FileExistUpload extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //chooseFile butonuna basalim
        WebElement dosyaSec = driver.findElement(By.xpath("//*[@id='file-upload']"));

        //Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu = "C:\\Users\\Zehra\\Desktop\\End(Gorev yoneticisi temizleme).bat";
        dosyaSec.sendKeys(dosyaYolu);
        /*
         Dosyasec butonuna direk click yapamayabiliriz çünkü windows'a müdahaleye izin vermeyebilir
        Bu yüzden Dosyasec butonunu direk locate edip sendKeys() methodu ile string değişkene atadığımız dosya yolumuzu
        göndeririz.
         */
        //Upload butonuna basalim.
        driver.findElement(By.xpath("//*[@id='file-submit']")).click();

        //“File Uploaded!” textinin goruntulendigini test edelim.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());

        }

    }

